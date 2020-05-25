package Transport4Future.TokenManagement.Data.Attributes;

import Transport4Future.TokenManagement.Exceptions.TokenManagementException;

public class TokenValue extends Attribute {
    public TokenValue (String Value) throws TokenManagementException {
        this.pattern = "^[-A-Za-z0-9+/]+={0,3}$";
        this.errorMessage = "Error: invalid Token value data in JSON structure.";
        this.value = this.validate(Value);
    }
}
