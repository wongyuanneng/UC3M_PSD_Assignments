package Transport4Future.TokenManagement;

import Transport4Future.TokenManagement.Exceptions.TokenManagementException;

public interface ITokenManagement {

    String tokenRequestGeneration (String InputFile) throws TokenManagementException;

    String requestToken (String InputFile) throws TokenManagementException;

    boolean verifyToken (String Token) throws TokenManagementException;

    String revokeToken(String InputFile) throws TokenManagementException;

    boolean executeAction(String InputFile) throws TokenManagementException;


}
