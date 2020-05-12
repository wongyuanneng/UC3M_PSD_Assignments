package Transport4Future.TokenManagement.Entity;

import Transport4Future.TokenManagement.Utils.TokenManagementException;

public class RequestDate extends Attribute {
    /**
     * RequestDate constructor with new pattern or errorOutput
     * @throws TokenManagementException 
     *
     * 
     */
    public RequestDate(String p, String errorOutput, String data) throws TokenManagementException {
        super(p, errorOutput, data);
        super.attributePatternCheck();
    }
    
    /**
     * RequestDate constructor
     * @throws TokenManagementException 
     *
     * 
     */
    public RequestDate(String data) throws TokenManagementException {
        super("(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-[0-9]{4}\\s(2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]","Error: invalid date data in JSON structure.",data);
        super.attributePatternCheck();
    }
}
