package Transport4Future.TokenManagement.Control;

import java.util.Base64;
import java.util.HashMap;
import javax.json.JsonObject;
import com.google.gson.Gson;

import Transport4Future.TokenManagement.Entity.Token;
import Transport4Future.TokenManagement.Entity.TokenRequest;
import Transport4Future.TokenManagement.Entity.TokensStore;
import Transport4Future.TokenManagement.Utils.GenericHasher;
import Transport4Future.TokenManagement.Utils.SHA256Hash;
import Transport4Future.TokenManagement.Utils.TokenManagementException;

public class TokenManager extends FileManager implements ITokenManager {
    
    private static TokenManager tm=null;
    private static Token t=null;
    
    private TokenManager() {
        
    }
    
    /**
     * TokenManager instantiation for Singleton implementation
     *
     * 
     */
    public static TokenManager getInstance() {
        if (tm == null) {
            tm = new TokenManager();
        }
        else {
            System.out.println("Cannot create object tokenManager because an object of class TokenManager already exists");
        }
        return tm;
    }
    
    @Override
    public TokenManager clone() {
        try {
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException ex) {
            System.out.println("You cannot clone objects of this class.");
        }
        return null;
    }
    
    /**
     * Request for a token
     *
     * @throws TokenManagementException if any error occurs
     */
    public String requestToken(String InputFile) throws TokenManagementException {
        String fileContents = inputFileCheck(InputFile);

        // Transform the String with the file contents into a JSON object (in memory).
        JsonObject jsonLicense = createJsonLicense(fileContents);
        
        checkJsonStruct(jsonLicense);
        checkInformationFormat();

        insertTokenSignature();
        insertTokenValue();

        TokensStore myStore = TokensStore.getInstance();
        myStore.add(t);

        return t.getTokenValue();
    }
    
    @Override
    public void checkInformationFormat() throws TokenManagementException {
        devicePatternCheck(t.getPayload().getDevice());
        datePatternCheck(t.getRequestDate());
        emailPatternCheck(t.getNotificationEmail());

        // Generar un HashMap para guardar los objetos
        Gson gson = new Gson();
        String storePath = System.getProperty("user.dir") + "/Store/tokenRequestsStore.json";

        // Cargar el almacen de tokens request en memoria y añadir el nuevo si no existe
        HashMap<String, TokenRequest> clonedMap = makeClonedMap(gson, storePath);
        if (clonedMap == null || !clonedMap.containsKey(t.getPayload().getDevice())) {
            throw new TokenManagementException("Error: Token Request Not Previously Registered");
        }
    }
    
    @Override
    public void checkJsonStruct(JsonObject jsonLicense) throws TokenManagementException {
        String tokenRquest = "";
        String email = "";
        String date = "";
        try {
            tokenRquest = jsonLicense.getString("Token Request");
            email = jsonLicense.getString("Notification e-mail");
            date = jsonLicense.getString("Request Date");
        } catch (Exception pe) {
            throw new TokenManagementException("Error: invalid input data in JSON structure.");
        }
        t = makeToken(tokenRquest, date, email);
    }
    
    private Token makeToken(String tokenRquest, String date, String email) {
        return new Token(tokenRquest, date, email);
    }

    private void insertTokenSignature() throws TokenManagementException {
        String input = t.getHeader().toString() + t.getPayload().toString();
        GenericHasher myHash = new SHA256Hash();
        String signature = myHash.hash(input);
        t.setSignature(signature);
    }

    private void insertTokenValue() {
        String stringToEncode = t.getHeader().toString() + t.getPayload().toString()
                + t.getSignature();
        String encodedString = Base64.getUrlEncoder().encodeToString(stringToEncode.getBytes());
        t.setTokenValue(encodedString);
    }

}