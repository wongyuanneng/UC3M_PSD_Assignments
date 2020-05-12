package Transport4Future.TokenManagement.Control;

import Transport4Future.TokenManagement.Utils.TokenManagementException;

public interface ITokenManager {
    String requestToken (String InputFile) throws TokenManagementException;
    String tokenRequestGeneration (String InputFile) throws TokenManagementException;
    boolean verifyToken (String Token) throws TokenManagementException;
}
