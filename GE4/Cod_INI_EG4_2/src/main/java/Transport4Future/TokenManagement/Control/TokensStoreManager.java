package Transport4Future.TokenManagement.Control;

import Transport4Future.TokenManagement.Entity.Token;
import Transport4Future.TokenManagement.Entity.TokensStore;
import Transport4Future.TokenManagement.Utils.TokenManagementException;

public class TokensStoreManager implements ITokensStoreManager {
    
    private static TokensStoreManager tsm=null;
    
    private TokensStoreManager() {
        
    }
    
    /**
     * TokensStoreManager instantiation for Singleton implementation
     *
     * 
     */
    public static TokensStoreManager getInstance() {
        if (tsm == null) {
            tsm = new TokensStoreManager();
        }
        else {
            System.out.println("Cannot create object tokensStoreManager because an object of class TokensStoreManager already exists");
        }
        return tsm;
    }
    
    @Override
    public TokensStoreManager clone() {
        try {
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException ex) {
            System.out.println("You cannot clone objects of this class.");
        }
        return null;
    }
    
    /**
     * Verifies a given token
     *
     * @throws TokenManagementException if any error occurs
     */
    public boolean verifyToken(String Token) throws TokenManagementException{
        TokensStore myStore = new TokensStore();
        Token tokenFound = myStore.find(Token);

        if (tokenFound!=null) {
            return isValid(tokenFound);
        }
        return false;
    }

    private boolean isValid (Token tokenFound) {
        return ((!tokenFound.getPayload().isExpired()) && (tokenFound.getPayload().isGranted()));
    }
}
