package Transport4Future.TokenManagement.Data;

import java.util.HashMap;

import Transport4Future.TokenManagement.Data.Attributes.TokenValue;
import Transport4Future.TokenManagement.Data.Attributes.TypeOfOperation;
import Transport4Future.TokenManagement.Exceptions.TokenManagementException;
import Transport4Future.TokenManagement.IO.OperationParser;

public class Operation {
    private Token operatingToken;
    private TypeOfOperation operationType;
    
    /**
     * Operation constructor
     * @throws TokenManagementException if error occurs
     */
    public Operation(String FileName) throws TokenManagementException {
        OperationParser myParser = new OperationParser();
        HashMap<String, String> items = myParser.parse(FileName);
        TokenValue tokenValue = new TokenValue(items.get(OperationParser.TOKEN_VALUE));
        
        this.operatingToken = new Token();      
        this.operatingToken.checkTokenExistence(tokenValue.getValue());
        String decodedToken = this.operatingToken.decodeTokenValue(tokenValue.getValue());
        
        this.operatingToken = this.operatingToken.findToken(decodedToken);
        
        this.operationType = new TypeOfOperation(items.get(OperationParser.TYPE_OF_OPERATION));
    }  
    
    /**
     * Checks if the operation is correctly matched
     * @throws TokenManagementException if error occurs
     */
    public boolean checkOperation(String deviceType) throws TokenManagementException {
        if (this.operationType.getValue().equalsIgnoreCase("Check State")
                || this.operationType.getValue().equalsIgnoreCase("Send Information from " + deviceType)
                || this.operationType.getValue().equalsIgnoreCase("Send Request to " + deviceType)) {
            return true;
        } else {
            throw new TokenManagementException("The device represented by the token cannot execute the requested operation.");
        }
    }
    
    public Token getOperatingToken() {
        return operatingToken;
    }

    public TypeOfOperation getOperationType() {
        return operationType;
    }
    
    
}
