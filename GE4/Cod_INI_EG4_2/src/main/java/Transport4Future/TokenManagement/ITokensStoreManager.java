package Transport4Future.TokenManagement;

public interface ITokensStoreManager {
    boolean verifyToken (String Token) throws TokenManagementException;
}
