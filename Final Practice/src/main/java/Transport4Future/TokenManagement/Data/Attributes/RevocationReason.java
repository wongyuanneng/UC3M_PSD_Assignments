package Transport4Future.TokenManagement.Data.Attributes;

import Transport4Future.TokenManagement.Exceptions.TokenManagementException;

public class RevocationReason extends Attribute {
	public RevocationReason (String Value) throws TokenManagementException{
		this.pattern = "([A-Za-z0-9\\s]{1,100})";
		this.errorMessage = "Error: invalid Reason data in JSON structure.";
		this.value = validate(Value);
	}
	
	protected String validate (String Value) throws TokenManagementException{
        if (Value.length()<1 || Value.length()>100) {
            this.errorMessage = "Error: invalid String length for Reason.";
            throw new TokenManagementException(this.errorMessage);  
        } 
        else {
            super.validate(Value);
        }
        return Value;
    }
	
}
