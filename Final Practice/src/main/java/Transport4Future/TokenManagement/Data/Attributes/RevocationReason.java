package Transport4Future.TokenManagement.Data.Attributes;

import Transport4Future.TokenManagement.Exceptions.TokenManagementException;

public class RevocationReason extends Attribute {
	public RevocationReason (String Value) throws TokenManagementException{
		this.pattern = "([A-Za-z0-9\\s]{1,100})";
		this.errorMessage = "Error: invalid String length for Reason.";
		this.value = validate(Value);
	}
	
}
