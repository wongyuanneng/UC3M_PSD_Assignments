package Transport4Future.TokenManagement.Entity;

import java.util.Base64;
import java.util.HashMap;
import javax.json.JsonObject;

import Transport4Future.TokenManagement.Utils.JsonFileParser;
import Transport4Future.TokenManagement.Utils.SHA256Hash;
import Transport4Future.TokenManagement.Utils.TokenManagementException;

public class Token {
    private Header header;
    private Payload payload;
    
    private RequestDate requestDate;
    private Email notificationEmail;
    
    private String signature;
    private String tokenValue;

    /**
     * Token constructor
     * @throws TokenManagementException 
     *
     * 
     */
    public Token (String inputFile) throws TokenManagementException {
        this.checkJsonStruct(inputFile);
        
        this.header = new Header();
        
        this.signature = insertSignature();
        this.tokenValue = insertValue();
        
        this.saveToStore();
    }
    
    public String getSignature() {
        return signature;
    }



    public void setSignature(String signature) {
        this.signature = signature;
    }



    public String getTokenValue() {
        return tokenValue;
    }



    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }



    public Header getHeader() {
        return header;
    }



    public Payload getPayload() {
        return payload;
    }



    public String getRequestDate() {
        return requestDate.getData();
    }



    public String getNotificationEmail() {
        return notificationEmail.getData();
    }

    
    
    @Override
    public String toString() {
        return "Token [header=" + header + ", payload=" + payload + ", requestDate=" + requestDate.getData()
                + ", notificationEmail=" + notificationEmail.getData() + ", signature=" + signature + ", tokenValue=" + tokenValue
                + "]";
    }
    
    /**
     * Checks if token request is previously registered
     * @throws TokenManagementException 
     *
     * 
     */
    public void checkTokenRequest(String tokenRequest) throws TokenManagementException {
        // Generar un HashMap para guardar los objetos
        //String storePath = System.getProperty("user.dir") + "/Store/tokenRequestsStore.json";
        TokenRequestsStore trs = TokenRequestsStore.getInstance();
        // Cargar el almacen de tokens request en memoria y añadir el nuevo si no existe
        HashMap<String, TokenRequest> clonedMap = trs.makeClonedMap();
        if (clonedMap == null || !clonedMap.containsKey(tokenRequest)) {
            throw new TokenManagementException("Error: Token Request Not Previously Registered");
        }
    }
    
    /**
     * Check token structure and data of JSON file in the inputFile path
     * @throws TokenManagementException 
     *
     * 
     */
    public void checkJsonStruct(String inputFile) throws TokenManagementException {
        JsonFileParser jfp = new JsonFileParser();
        JsonObject jsonLicense = jfp.createJsonLicense(inputFile);
        
        String payload = "";
        String notificationEmail = "";
        String requestDate = "";
        try {
            payload = jsonLicense.getString("Token Request");
            notificationEmail = jsonLicense.getString("Notification e-mail");
            requestDate = jsonLicense.getString("Request Date");
        } catch (Exception pe) {
            throw new TokenManagementException("Error: invalid input data in JSON structure.");
        }
        this.payload = new Payload(payload);
        this.notificationEmail = new Email(notificationEmail);
        this.requestDate = new RequestDate(requestDate);
    }
    
    private String insertSignature() throws TokenManagementException {
        String input = this.getHeader().toString() + this.getPayload().toString();
        SHA256Hash myHash = new SHA256Hash();
        return myHash.hash(input);
    }

    private String insertValue() {
        String stringToEncode = this.getHeader().toString() + this.getPayload().toString() + this.getSignature();
        String encodedString = Base64.getUrlEncoder().encodeToString(stringToEncode.getBytes());
        return encodedString;
    }
    
    private void saveToStore() throws TokenManagementException {
        TokensStore myStore = TokensStore.getInstance();
        myStore.add(this);
    }
    
    public boolean isValid() {
        return ((!this.getPayload().isExpired()) && (this.getPayload().isGranted()));
    }
}
