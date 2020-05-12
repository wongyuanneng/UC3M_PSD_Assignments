package Transport4Future.TokenManagement.Entity;

import Transport4Future.TokenManagement.Utils.TokenManagementException;

public class Device extends Attribute {
    
    /**
     * Device constructor with new pattern or errorOutput
     * @throws TokenManagementException 
     *
     * 
     */
    public Device(String pattern, String errorOutput, String data) throws TokenManagementException {
        super(pattern, errorOutput, data);
        super.attributePatternCheck();
        super.attributeLengthCheck(1, 32);
    }
    
    /**
     * Device constructor
     * @throws TokenManagementException 
     *
     * 
     */
    public Device(String data) throws TokenManagementException {
        super("([A-Fa-f0-9]{32})","Error: invalid Device in token request.",data);
        super.attributePatternCheck();
        super.attributeLengthCheck(1, 32);
    }
    
}
