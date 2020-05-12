package Transport4Future.TokenManagement.Entity;

import javax.json.JsonObject;

import Transport4Future.TokenManagement.Utils.JsonFileParser;
import Transport4Future.TokenManagement.Utils.TokenManagementException;

public class TokenRequest {
    private DeviceName deviceName;
    private TypeOfDevice typeOfDevice;
    private DriverVersion driverVersion;
    private Email supportEmail;
    private SerialNumber serialNumber;
    private MacAddress macAddress;
    
    private String hex;

    
    /**
     * TokenRequest constructor with attributes provided explicitly.
     *
     * @throws TokenManagementException if any error occurs
     */
    public TokenRequest(String inputFile) throws TokenManagementException {
        this.hex=null;
        this.checkJsonStruct(inputFile);
        this.saveTokenRequest();
    }
    
    public String getHex() {
        return this.hex;
    }
    
    public void setHex(String hex) {
        this.hex = hex;
    }
    
    @Override
    public String toString() {
        return "TokenRequest [\\n\\Device Name=" + this.deviceName +
                ",\n\t\\Type of Device=" + this.typeOfDevice+
                ",\n\t\\Driver Version=" + this.driverVersion + 
                ",\n\t\\Support e-Mail=" + this.supportEmail +  
                ",\n\t\\Serial Number=" + this.serialNumber +
                ",\n\t\\MAC Address=" + this.macAddress + "\n]";
    }
    
    /**
     * Check tokenRequest structure and data of JSON file in the inputFile path
     * @throws TokenManagementException 
     *
     * 
     */
    public void checkJsonStruct(String inputFile) throws TokenManagementException {
        JsonFileParser jfp = new JsonFileParser();
        JsonObject jsonLicense = jfp.createJsonLicense(inputFile);
        
        String deviceName = "";
        String typeOfDevice = "";
        String driverVersion = "";
        String supportEmail = "";
        String serialNumber = "";
        String macAddress = "";
        try {           
            deviceName = jsonLicense.getString("Device Name");
            typeOfDevice = jsonLicense.getString("Type of Device");
            driverVersion = jsonLicense.getString("Driver Version");
            supportEmail = jsonLicense.getString("Support e-mail");
            serialNumber = jsonLicense.getString("Serial Number");
            macAddress = jsonLicense.getString("MAC Address");          
        } catch (Exception pe) {
            throw new TokenManagementException("Error: invalid input data in JSON structure.");
        }
        this.deviceName = new DeviceName(deviceName);
        this.typeOfDevice = new TypeOfDevice(typeOfDevice);
        this.driverVersion = new DriverVersion(driverVersion);
        this.supportEmail = new Email(supportEmail);
        this.serialNumber = new SerialNumber(serialNumber);
        this.macAddress = new MacAddress(macAddress);
    }
    
    private void saveTokenRequest() throws TokenManagementException {
        TokenRequestsStore trs = TokenRequestsStore.getInstance();
        trs.add(this);
    }
    
    
}
