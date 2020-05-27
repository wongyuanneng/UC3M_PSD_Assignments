package Transport4Future.TokenManagement;

import java.util.HashMap;

import Transport4Future.TokenManagement.Data.Token;
import Transport4Future.TokenManagement.Data.TokenRequest;
import Transport4Future.TokenManagement.Data.Attributes.RevocationReason;
import Transport4Future.TokenManagement.Data.Attributes.TokenValue;
import Transport4Future.TokenManagement.Data.Attributes.TypeOfRevocation;
import Transport4Future.TokenManagement.Data.Attributes.TypeOfOperation;
import Transport4Future.TokenManagement.Exceptions.TokenManagementException;
import Transport4Future.TokenManagement.IO.RevocationParser;
import Transport4Future.TokenManagement.IO.OperationParser;

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
        Token token = new Token();
        String decodedValue = token.decodeTokenValue(TokenString);
        if (token.setDecoded(decodedValue)) {
            return token.isValid();
        } else {
            return false;
        }
    }
    
    /**
     * Revokes a token
     *
     * @throws TokenManagementException if any error occurs
     */
    public String revokeToken(String InputFile) throws TokenManagementException {
        RevocationParser myParser = new RevocationParser();
        HashMap<String, String> items = myParser.parse(InputFile);
        TokenValue tokenValue = new TokenValue(items.get(RevocationParser.TOKEN_VALUE));
        if (!this.verifyToken(tokenValue.getValue())) {
            throw new TokenManagementException("The token received does not exist.");
        }
        
        Token token = new Token();
        String decodedToken = token.decodeTokenValue(tokenValue.getValue());
        token = token.findToken(decodedToken);

        TypeOfRevocation revocationType = new TypeOfRevocation(items.get(RevocationParser.TYPE_OF_REVOCATION));
        RevocationReason revocationReason = new RevocationReason(items.get(RevocationParser.REASON));
        token.setRevoked(revocationType, revocationReason);

        String email = token.getNotificationEmail();
        return email;
    }
    
    /**
     * Check if action can be executed
     *
     * @throws TokenManagementException if any error occurs
     */
    public boolean executeAction(String InputFile) throws TokenManagementException {
        Token token = new Token();
        OperationParser myParser = new OperationParser();
        HashMap<String, String> items = myParser.parse(InputFile);
        TokenValue tokenValue = new TokenValue(items.get(OperationParser.TOKEN_VALUE));
        if (!this.verifyToken(tokenValue.getValue())) {
            throw new TokenManagementException("The token received does not exist or is not valid.");
        }
        String decodedToken = token.decodeTokenValue(tokenValue.getValue());
        if (!token.setDecoded(decodedToken)) {
            return false;
        }
        
        TokenRequest tokenR = token.getTokenRequestEmmision();
        TypeOfOperation opType = new TypeOfOperation(items.get(OperationParser.TYPE_OF_OPERATION));

        if (opType.getValue().equalsIgnoreCase("Check State")
                || opType.getValue().equalsIgnoreCase("Send Information from " + tokenR.getTypeOfDevice())
                || opType.getValue().equalsIgnoreCase("Send Request to " + tokenR.getTypeOfDevice())) {
            return true;
        } else {
            throw new TokenManagementException("The device represented by the token cannot execute the requested operation.");
        }

    }
}