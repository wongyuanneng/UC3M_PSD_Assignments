package Transport4Future.TokenManagement.Entity;

import Transport4Future.TokenManagement.Utils.TokenManagementException;

public class TypeOfDevice extends Attribute {
    /**
     * TypeOfDevice constructor with new errorOutput
     * @throws TokenManagementException 
     *
     * 
     */
    public TypeOfDevice(String errorOutput, String data) throws TokenManagementException {
        super(null, errorOutput, data);
        super.attributePatternCheck();
    }
    
    /**
     * TypeOfDevice constructor
     * @throws TokenManagementException 
     *
     * 
     */
    public TypeOfDevice(String data) throws TokenManagementException {
        super("Sensor|Actuator","Error: invalid type of sensor.",data);
        super.attributePatternCheck();
    }
}
