package Transport4Future.TokenManagement.Boundary;

import Transport4Future.TokenManagement.Utils.TokenManagementException;

public interface ITokenManager {
    String requestToken (String InputFile) throws TokenManagementException;
}
