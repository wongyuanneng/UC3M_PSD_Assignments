package Transport4Future.TokenManagement;

import java.util.HashMap;

import Transport4Future.TokenManagement.Data.Token;
import Transport4Future.TokenManagement.Data.TokenRequest;
import Transport4Future.TokenManagement.Data.Attributes.DeviceName;
import Transport4Future.TokenManagement.Data.Attributes.RevocationReason;
import Transport4Future.TokenManagement.Data.Attributes.TokenValue;
import Transport4Future.TokenManagement.Data.Attributes.TypeOfDevice;
import Transport4Future.TokenManagement.Data.Attributes.TypeOfRevocation;
import Transport4Future.TokenManagement.Data.Attributes.TypeOfOperation;
import Transport4Future.TokenManagement.Exceptions.TokenManagementException;
import Transport4Future.TokenManagement.IO.RevocationParser;
import Transport4Future.TokenManagement.IO.OperationParser;
import Transport4Future.TokenManagement.IO.TokenRequestParser;
import Transport4Future.TokenManagement.Store.TokensStore;

public class TokenManager implements ITokenManagement {
	
	private static TokenManager manager;
	
	private TokenManager () {
		
	}
	
	public static TokenManager getInstance() {
		if (manager == null) {
			manager = new TokenManager();
		}
/*		else {
			System.out.println("There is a Token Manager instance already created");
		}*/
		return manager;
	}
	
	@Override
	public TokenManager clone () {
		try {
			throw new CloneNotSupportedException();
		}
		catch (CloneNotSupportedException ex) {
//			System.out.println("Token Manager Object cannot be cloned");
		}
		return null;
	}

	public String TokenRequestGeneration (String InputFile) throws TokenManagementException{
		TokenRequest req = new TokenRequest(InputFile);
		return req.getHash();
	}
	
	public String RequestToken (String InputFile) throws TokenManagementException{	
		Token myToken = new Token (InputFile);
		return myToken.getTokenValue();
	}
	
	public boolean VerifyToken (String TokenString) throws TokenManagementException{
		Token token = new Token ();
		String decodedValue = token.DecodeTokenValue(TokenString);
		if (token.setDecoded(decodedValue)) {
			return token.isValid();	
		}
		else {
			return false;
		}
	}
	
	public String RevokeToken(String InputFile) throws TokenManagementException{
		String email;
		Token token = new Token ();
		RevocationParser myParser = new RevocationParser();
		HashMap<String, String> items = myParser.Parse(InputFile);
		
		TokenValue tokenValue = new TokenValue(items.get(RevocationParser.TOKEN_VALUE));

		this.VerifyToken(tokenValue.getValue());
		String decodedToken = token.DecodeTokenValue(tokenValue.getValue());
		TokensStore myStore = TokensStore.getInstance();
		Token tokenFound = myStore.Find(decodedToken);
		TypeOfRevocation revocationType = new TypeOfRevocation(items.get(RevocationParser.TYPE_OF_REVOCATION));
		RevocationReason revocationReason = new RevocationReason(items.get(RevocationParser.REASON));
		tokenFound.setRevoked(revocationType, revocationReason);
		email = tokenFound.getNotificationEmail();
		return email;
	}
	
	
	public boolean ExecuteAction(String InputFile) throws TokenManagementException{
		Token token = new Token ();
		OperationParser myParser = new OperationParser();
		HashMap<String, String> items = myParser.Parse(InputFile);
		TokenValue tokenValue = new TokenValue(items.get(OperationParser.TOKEN_VALUE));
		this.VerifyToken(tokenValue.getValue());
		String decodedToken = token.DecodeTokenValue(tokenValue.getValue());
		if (!token.setDecoded(decodedToken)) {
			return false;
		}
		TokenRequest tokenR = token.getTokenRequestEmmision();
		TypeOfOperation opType = new TypeOfOperation(items.get(OperationParser.TYPE_OF_OPERATION));
		
		if (opType.getValue().equalsIgnoreCase("Check State") || opType.getValue().equalsIgnoreCase(tokenR.getTypeOfDevice()) || opType.getValue().equalsIgnoreCase(tokenR.getTypeOfDevice())) {
			return true;
		}
		else {
			throw new TokenManagementException("The device represented by the token cannot execute the requested operation.");
		}

	}
}