package Transport4Future.TokenManagement;

public interface ITokenManager {
    String requestToken (String InputFile) throws TokenManagementException;
}
