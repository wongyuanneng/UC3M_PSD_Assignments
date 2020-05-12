package Transport4Future.TokenManagement.Entity;

import Transport4Future.TokenManagement.Utils.TokenManagementException;

public class DeviceName extends Attribute {
    
    /**
     * DeviceName constructor with new errorOutput
     * @throws TokenManagementException 
     *
     * 
     */
    public DeviceName(String errorOutput, String data) throws TokenManagementException {
        super(null, errorOutput, data);
        super.attributeLengthCheck(1, 20);
    }
    
    /**
     * DeviceName constructor
     * @throws TokenManagementException 
     *
     * 
     */
    public DeviceName(String data) throws TokenManagementException {
        super(null,"Error: invalid String length for device name.",data);
        super.attributeLengthCheck(1, 20);
    }
 
}
