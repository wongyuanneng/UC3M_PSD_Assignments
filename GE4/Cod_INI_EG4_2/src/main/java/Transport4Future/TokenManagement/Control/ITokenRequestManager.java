package Transport4Future.TokenManagement.Control;

import Transport4Future.TokenManagement.Boundary.TokenManagementException;

public interface ITokenRequestManager {
    String tokenRequestGeneration (String InputFile) throws TokenManagementException;
}
