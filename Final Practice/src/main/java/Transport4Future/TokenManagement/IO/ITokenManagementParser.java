package Transport4Future.TokenManagement.IO;

import Transport4Future.TokenManagement.Exceptions.TokenManagementException;

public interface ITokenManagementParser {
    public Object parse(String FileName) throws TokenManagementException;
}
