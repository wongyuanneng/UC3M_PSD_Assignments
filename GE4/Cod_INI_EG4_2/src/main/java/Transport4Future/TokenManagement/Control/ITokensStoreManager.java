package Transport4Future.TokenManagement.Control;

import Transport4Future.TokenManagement.Utils.TokenManagementException;

public interface ITokensStoreManager {
    boolean verifyToken (String Token) throws TokenManagementException;
}
