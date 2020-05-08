package Transport4Future.TokenManagement.Control;

import java.util.Base64;
import java.util.HashMap;
import javax.json.JsonObject;
import com.google.gson.Gson;

import Transport4Future.TokenManagement.Boundary.TokenManagementException;
import Transport4Future.TokenManagement.Entity.Token;
import Transport4Future.TokenManagement.Entity.TokenRequest;
import Transport4Future.TokenManagement.Entity.TokensStore;

public class TokenManager extends FileManager implements ITokenManager {
    
    private static TokenManager tm=null;
    
    /**
     * TokenManager instantiation for Singleton implementation
     *
     * 
     */
    public static TokenManager getTokenManagerInstance() {
        if (tm == null) {
            tm = new TokenManager();
        }
        else {
            System.out.println("Cannot create object tokenManager because an object of class TokenManager already exists");
        }
        return tm;
    }
    
    /**
     * Request for a token
     *
     * @throws TokenManagementException if any error occurs
     */
    public String requestToken(String InputFile) throws TokenManagementException {
        Token myToken = null;

        String fileContents = inputFileCheck(InputFile);

        // Transform the String with the file contents into a JSON object (in memory).
        JsonObject jsonLicense = createJsonLicense(fileContents);
        myToken = checkJsonStruct(jsonLicense);

        checkTokenRequestInformationFormat(myToken);

        insertTokenSignature(myToken);
        insertTokenValue(myToken);

        TokensStore myStore = new TokensStore();
        myStore.add(myToken);

        return myToken.getTokenValue();
    }

    private void checkTokenRequestInformationFormat(Token TokenToVerify) throws TokenManagementException {
        devicePatternCheck(TokenToVerify.getPayload().getDevice());
        datePatternCheck(TokenToVerify.getRequestDate());
        emailPatternCheck(TokenToVerify.getNotificationEmail());

        // Generar un HashMap para guardar los objetos
        Gson gson = new Gson();
        String storePath = System.getProperty("user.dir") + "/Store/tokenRequestsStore.json";

        // Cargar el almacen de tokens request en memoria y añadir el nuevo si no existe
        HashMap<String, TokenRequest> clonedMap = makeClonedMap(gson, storePath);
        if (clonedMap == null || !clonedMap.containsKey(TokenToVerify.getPayload().getDevice())) {
            throw new TokenManagementException("Error: Token Request Not Previously Registered");
        }
    }

    private Token checkJsonStruct(JsonObject jsonLicense) throws TokenManagementException {
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
        return makeToken(tokenRquest, date, email);
    }

    private Token makeToken(String tokenRquest, String date, String email) {
        return new Token(tokenRquest, date, email);
    }

    private void insertTokenSignature(Token myToken) throws TokenManagementException {
        String input = myToken.getHeader().toString() + myToken.getPayload().toString();
        String signature = hashEncoding(input, "SHA-256");
        myToken.setSignature(signature);
    }

    private void insertTokenValue(Token myToken) {
        String stringToEncode = myToken.getHeader().toString() + myToken.getPayload().toString()
                + myToken.getSignature();
        String encodedString = Base64.getUrlEncoder().encodeToString(stringToEncode.getBytes());
        myToken.setTokenValue(encodedString);
    }

}