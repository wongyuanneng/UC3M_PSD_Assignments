package Transport4Future.TokenManagement;

import Transport4Future.TokenManagement.Data.Token;
import Transport4Future.TokenManagement.Data.TokenRequest;
import Transport4Future.TokenManagement.Data.DeactivatedToken;
import Transport4Future.TokenManagement.Data.Operation;
import Transport4Future.TokenManagement.Exceptions.TokenManagementException;

public class TokenManager implements ITokenManagement {

    private static TokenManager manager;

    private TokenManager() {

    }
    
    /**
     * TokenManager instantiation for Singleton implementation
     *
     * 
     */
    public static TokenManager getInstance() {
        if (manager == null) {
            manager = new TokenManager();
        }
        /*
         * else {
         * System.out.println("There is a Token Manager instance already created"); }
         */
        return manager;
    }

    @Override
    public TokenManager clone() {
        try {
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException ex) {
            // System.out.println("Token Manager Object cannot be cloned");
        }
        return null;
    }
    
    /**
     * Generates a token request
     *
     * @throws TokenManagementException if any error occurs
     */
    public String tokenRequestGeneration(String InputFile) throws TokenManagementException {
        TokenRequest req = new TokenRequest(InputFile);
        return req.getHash();
    }

    /**
     * Request for a token
     *
     * @throws TokenManagementException if any error occurs
     */
    public String requestToken(String InputFile) throws TokenManagementException {
        Token myToken = new Token(InputFile);
        return myToken.getTokenValue();
    }
    
    /**
     * Verifies a given token
     *
     * @throws TokenManagementException if any error occurs
     */
    public boolean verifyToken(String TokenString) throws TokenManagementException {
        //duplicated implementation that should be in Token.java, but not sure if we are allowed to remove it from TokenManager
        Token token = new Token(); 
        String decodedValue = token.decodeTokenValue(TokenString); 
        return token.loadTokenData(decodedValue);
    }
    
    /**
     * Revokes a token
     *
     * @throws TokenManagementException if any error occurs
     */
    public String revokeToken(String InputFile) throws TokenManagementException {
        DeactivatedToken myToken = new DeactivatedToken(InputFile);
        String email = myToken.getRevokedToken().getNotificationEmail();
        return email;
    }
    
    /**
     * Check if action can be executed
     *
     * @throws TokenManagementException if any error occurs
     */
    public boolean executeAction(String InputFile) throws TokenManagementException {
        Operation myOperation = new Operation(InputFile);
        if (myOperation.getOperatingToken()==null) {
            return false;
        }
        TokenRequest tokenReq = myOperation.getOperatingToken().getTokenRequestEmmision();
        return myOperation.checkOperation(tokenReq.getDeviceName());
    }
}