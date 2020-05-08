package Transport4Future.TokenManagement.Control;

import Transport4Future.TokenManagement.Boundary.TokenManagementException;

public interface ITokenManager {
    String requestToken (String InputFile) throws TokenManagementException;
}
