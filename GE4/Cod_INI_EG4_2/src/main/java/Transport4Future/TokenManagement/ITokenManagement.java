package Transport4Future.TokenManagement;

public interface ITokenManagement {
	
  String tokenRequestGeneration (String InputFile) throws TokenManagementException;

  String requestToken (String InputFile) throws TokenManagementException;

  boolean verifyToken (String Token) throws TokenManagementException;


}
