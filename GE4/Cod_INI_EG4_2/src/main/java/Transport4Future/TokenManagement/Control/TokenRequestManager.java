package Transport4Future.TokenManagement.Control;

import java.io.FileWriter;
import java.io.IOException;
import javax.json.JsonObject;

import Transport4Future.TokenManagement.Entity.*;
import Transport4Future.TokenManagement.Utils.GenericHasher;
import Transport4Future.TokenManagement.Utils.MD5Hash;
import Transport4Future.TokenManagement.Utils.TokenManagementException;

public class TokenRequestManager extends FileManager implements ITokenRequestManager {
    
    private static TokenRequestManager trm=null;
    private static TokenRequest tr=null;
    
    private TokenRequestManager() {
        
    }
    
    /**
     * TokenRequestManager instantiation for Singleton implementation
     *
     * 
     */
    public static TokenRequestManager getInstance() {
        if (trm == null) {
            trm = new TokenRequestManager();
        }
        else {
            System.out.println("Cannot create object tokenRequestManager because an object of class TokenRequestManager already exists");
        }
        return trm;
    }
    
    @Override
    public TokenRequestManager clone() {
        try {
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException ex) {
            System.out.println("You cannot clone objects of this class.");
        }
        return null;
    }
    
    /**
     * Generates a token request
     *
     * @throws TokenManagementException if any error occurs
     */
    public String tokenRequestGeneration (String InputFile) throws TokenManagementException{
        String fileContents = inputFileCheck(InputFile);
        JsonObject jsonLicense = createJsonLicense(fileContents);

        checkJsonStruct(jsonLicense);
        checkInformationFormat();
        
        GenericHasher myHash = new MD5Hash("Stardust-");
        String hex = myHash.hash(tr.toString());
        saveTokenReqStore(hex);
        //Devolver el hash
        return hex;
    }

    public void checkInformationFormat() throws TokenManagementException {
        //before to that I have to check that all the fields are correct
        deviceNameLengthCheck(tr.getDeviceName());
        serialNumPatternCheck(tr.getSerialNumber());
        driverVerLengthCheck(tr.getDriverVersion());
        emailPatternCheck(tr.getSupportEMail());
        licenseRequestCheck(tr.getTypeOfDevice());
        macAddressCheck(tr.getMacAddress());
    }

    public void checkJsonStruct(JsonObject jsonLicense) throws TokenManagementException {
        String deviceName = "";
        String typeOfDevice = "";
        String driverVersion = "";
        String supportEMail = "";
        String serialNumber = "";
        String macAddress = "";	
        try {			
            deviceName = jsonLicense.getString("Device Name");
            typeOfDevice = jsonLicense.getString("Type of Device");
            driverVersion = jsonLicense.getString("Driver Version");
            supportEMail = jsonLicense.getString("Support e-mail");
            serialNumber = jsonLicense.getString("Serial Number");
            macAddress = jsonLicense.getString("MAC Address");			
        } catch (Exception pe) {
            throw new TokenManagementException("Error: invalid input data in JSON structure.");
        }
        tr = makeTokenRequest(deviceName, typeOfDevice, driverVersion, supportEMail, serialNumber, macAddress);
    }

    private TokenRequest makeTokenRequest(String deviceName, String typeOfDevice, String driverVersion, String supportEMail, String serialNumber, String macAddress) {
        return new TokenRequest(deviceName, typeOfDevice, driverVersion, supportEMail, serialNumber, macAddress);
    }

    private void saveTokenReqStore(String hex) throws TokenManagementException {
        FileWriter fileWriter;

        //Generar un HashMap para guardar los objetos
        String storePath = System.getProperty("user.dir") + "/Store/tokenRequestsStore.json";

        //Tengo que cargar el almacen de tokens request en memoria y añadir el nuevo si no existe
        String jsonString = createJsonString(tr, hex, storePath);
        try {
            fileWriter = new FileWriter(storePath);
            fileWriter.write(jsonString);
            fileWriter.close();
        } catch (IOException e) {
            throw new TokenManagementException("Error: Unable to save a new token in the internal licenses store");
        }
    }





}
