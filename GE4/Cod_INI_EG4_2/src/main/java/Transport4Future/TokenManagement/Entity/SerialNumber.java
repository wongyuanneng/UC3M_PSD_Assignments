package Transport4Future.TokenManagement.Entity;

import Transport4Future.TokenManagement.Utils.TokenManagementException;

public class SerialNumber extends Attribute {
    /**
     * SerialNumber constructor with new pattern or errorOutput
     * @throws TokenManagementException 
     *
     * 
     */
    public SerialNumber(String p, String errorOutput, String data) throws TokenManagementException {
        super(p, errorOutput, data);
        super.attributePatternCheck();
    }
    
    /**
     * SerialNumber constructor
     * @throws TokenManagementException 
     *
     * 
     */
    public SerialNumber(String data) throws TokenManagementException {
        super("([A-Za-z0-9-]{1,})","Error: invalid String length for serial number.",data);
        super.attributePatternCheck();
    }
}
