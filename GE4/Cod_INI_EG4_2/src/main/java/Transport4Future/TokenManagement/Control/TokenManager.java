package Transport4Future.TokenManagement.Control;

import Transport4Future.TokenManagement.Entity.Token;
import Transport4Future.TokenManagement.Entity.TokenRequest;
import Transport4Future.TokenManagement.Entity.TokensStore;
import Transport4Future.TokenManagement.Utils.TokenManagementException;

public class TokenManager implements ITokenManager {
    
    private static TokenManager tm=null;

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
        Token t = new Token(InputFile);
        return t.getTokenValue();
    }

    /**
     * Generates a token request
     *
     * @throws TokenManagementException if any error occurs
     */
    public String tokenRequestGeneration (String InputFile) throws TokenManagementException{
        TokenRequest tr = new TokenRequest(InputFile);
        //Devolver el hash
        return tr.getHex();
    }
    
    /**
     * Verifies a given token
     *
     * @throws TokenManagementException if any error occurs
     */
    public boolean verifyToken(String Token) throws TokenManagementException{
        TokensStore myStore = TokensStore.getInstance();
        Token tokenFound = myStore.find(Token);
        if (tokenFound!=null) {
            return tokenFound.isValid();
        }
        return false;
    }

}