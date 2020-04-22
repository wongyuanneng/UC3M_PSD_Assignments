package Transport4Future.TokenManagement;

public interface ITokenStoreManager {
    boolean verifyToken (String Token) throws TokenManagementException;
}
