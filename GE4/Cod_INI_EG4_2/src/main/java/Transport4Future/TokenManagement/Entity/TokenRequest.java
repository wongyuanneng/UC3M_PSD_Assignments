package Transport4Future.TokenManagement.Entity;

import Transport4Future.TokenManagement.Boundary.TokenManagementException;

public class TokenRequest {
    private static TokenRequest tr = null;
    
    private String deviceName;
    private String typeOfDevice;
    private String driverVersion;
    private String supportEMail;
    private String serialNumber;
    private String macAddress;

    /**
     * TokenRequest constructor
     *
     * @throws TokenManagementException if any error occurs
     */
    public TokenRequest(String deviceName, String typeOfDevice, String driverVersion, String supportEMail, String serialNumber, String macAddress) {
        this.deviceName = deviceName;
        this.typeOfDevice = typeOfDevice;
        this.driverVersion = driverVersion;
        this.supportEMail = supportEMail;
        this.serialNumber = serialNumber;
        this.macAddress = macAddress;
    }
    
    /**
     * TokenRequest instantiation for Singleton implementation
     *
     * 
     */
    public static TokenRequest getInstance(String deviceName, String typeOfDevice, String driverVersion, String supportEMail, String serialNumber, String macAddress) {
        if (tr == null) {
            tr = new TokenRequest(deviceName, typeOfDevice, driverVersion, supportEMail, serialNumber, macAddress);
        }
        else {
            System.out.println("Cannot create object (" + deviceName + ", " + typeOfDevice + ", " + driverVersion + ", " + supportEMail + ", " + serialNumber + ", " + macAddress + ") because an object of class TokenRequest already exists");
        }
        return tr;
    }
    
    public String getDeviceName() {
        return deviceName;
    }

    public String getTypeOfDevice() {
        return typeOfDevice;
    }

    public String getDriverVersion() {
        return driverVersion;
    }

    public String getSupportEMail() {
        return supportEMail;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getMacAddress() {
        return macAddress;
    }

    @Override
    public String toString() {
        return "TokenRequest [\\n\\Device Name=" + this.deviceName +
                ",\n\t\\Type of Device=" + this.typeOfDevice +
                ",\n\t\\Driver Version=" + this.driverVersion +	
                ",\n\t\\Support e-Mail=" + this.supportEMail +	
                ",\n\t\\Serial Number=" + this.serialNumber +
                ",\n\t\\MAC Address=" + this.macAddress + "\n]";
    }
}
