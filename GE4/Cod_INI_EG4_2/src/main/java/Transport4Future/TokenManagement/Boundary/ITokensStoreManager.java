package Transport4Future.TokenManagement.Boundary;

import Transport4Future.TokenManagement.Utils.TokenManagementException;

public interface ITokensStoreManager {
    boolean verifyToken (String Token) throws TokenManagementException;
}
