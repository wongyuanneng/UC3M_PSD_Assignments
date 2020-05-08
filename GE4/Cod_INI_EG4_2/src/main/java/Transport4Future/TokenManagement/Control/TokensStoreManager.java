package Transport4Future.TokenManagement.Control;

import Transport4Future.TokenManagement.Boundary.TokenManagementException;
import Transport4Future.TokenManagement.Entity.Token;
import Transport4Future.TokenManagement.Entity.TokensStore;

public class TokensStoreManager implements ITokensStoreManager {
    
    private static TokensStoreManager tsm=null;
    
    /**
     * FileManager instantiation for Singleton implementation
     *
     * 
     */
    public static TokensStoreManager getTokensStoreManagerInstance() {
        if (tsm == null) {
            tsm = new TokensStoreManager();
        }
        else {
            System.out.println("Cannot create object tokensStoreManager because an object of class TokensStoreManager already exists");
        }
        return tsm;
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
