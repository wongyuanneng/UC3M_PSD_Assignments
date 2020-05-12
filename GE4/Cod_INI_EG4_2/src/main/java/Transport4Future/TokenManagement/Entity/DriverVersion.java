package Transport4Future.TokenManagement.Entity;

import Transport4Future.TokenManagement.Utils.TokenManagementException;

public class DriverVersion extends Attribute {
    /**
     * DriverVersion constructor with new pattern or errorOutput
     * @throws TokenManagementException 
     *
     * 
     */
    public DriverVersion(String p, String errorOutput, String data) throws TokenManagementException {
        super(p, errorOutput, data);
        super.attributePatternCheck();
        super.attributeLengthCheck(1, 25);
    }
    
    /**
     * DriverVersion constructor
     * @throws TokenManagementException 
     *
     * 
     */
    public DriverVersion(String data) throws TokenManagementException {
        super("([a-zA-Z0-9]{1}[A-Za-z0-9\\\\.]{0,24})","Error: invalid String length for driver version.",data);
        super.attributePatternCheck();
        super.attributeLengthCheck(1, 25);
    }
    
}
