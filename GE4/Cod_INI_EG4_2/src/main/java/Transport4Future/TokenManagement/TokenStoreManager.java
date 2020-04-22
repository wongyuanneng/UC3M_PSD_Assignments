package Transport4Future.TokenManagement;

public class TokenStoreManager implements ITokenStoreManager {
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
