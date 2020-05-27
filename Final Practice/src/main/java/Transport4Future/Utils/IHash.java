package Transport4Future.Utils;

import Transport4Future.TokenManagement.Exceptions.TokenManagementException;

public interface IHash {
    public String hash(String text) throws TokenManagementException;
}
