package Transport4Future.TokenManagement.Entity;

import Transport4Future.TokenManagement.Utils.TokenManagementException;

public class MacAddress extends Attribute {
    /**
     * MacAddress constructor with new pattern or errorOutput
     * @throws TokenManagementException 
     *
     * 
     */
    
    public MacAddress(String p, String errorOutput, String data) throws TokenManagementException {
        super(p, errorOutput, data);
        super.attributePatternCheck();
    }
         
    /**
     * MacAddress constructor
     * @throws TokenManagementException 
     *
     * 
     */
    public MacAddress(String data) throws TokenManagementException {
        super("([a-fA-F0-9]{2}[:-]){5}[a-fA-F0-9]{2}$","Error: invalid MAC Address data in JSON structure.",data);
        super.attributePatternCheck();
    }
}
