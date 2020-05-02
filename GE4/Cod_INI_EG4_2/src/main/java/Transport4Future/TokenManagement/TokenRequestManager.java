package Transport4Future.TokenManagement;

import java.io.FileWriter;
import java.io.IOException;
import javax.json.JsonObject;

public class TokenRequestManager extends FileManager implements ITokenRequestManager {
    
    private static TokenRequestManager trm=null;
    
    /**
     * FileManager instantiation for Singleton implementation
     *
     * 
     */
    public static TokenRequestManager getTokenRequestManagerInstance() {
        if (trm == null) {
            trm = new TokenRequestManager();
        }
        else {
            System.out.println("Cannot create object tokenRequestManager because an object of class TokenRequestManager already exists");
        }
        return trm;
    }
    
    /**
     * Generates a token request
     *
     * @throws TokenManagementException if any error occurs
     */
    public String tokenRequestGeneration (String InputFile) throws TokenManagementException{
        String fileContents = inputFileCheck(InputFile);
        JsonObject jsonLicense = createJsonLicense(fileContents);

        TokenRequest req = null;
        req = checkJsonStruct(jsonLicense);

        checkInitialTokenInformationFormat(req);
        String input =  "Stardust" + "-" + req.toString();
        String hex = hashEncoding(input, "MD5");
        saveTokenReqStore(req, hex);
        //Devolver el hash
        return hex;
    }

    private void checkInitialTokenInformationFormat(TokenRequest Request) throws TokenManagementException {
        //before to that I have to check that all the fields are correct
        deviceNameLengthCheck(Request.getDeviceName());
        serialNumPatternCheck(Request.getSerialNumber());
        driverVerLengthCheck(Request.getDriverVersion());
        emailPatternCheck(Request.getSupportEMail());
        licenseRequestCheck(Request.getTypeOfDevice());
        macAddressCheck(Request.getMacAddress());
    }

    private TokenRequest checkJsonStruct(JsonObject jsonLicense) throws TokenManagementException {
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
        return makeTokenRequest(deviceName, typeOfDevice, driverVersion, supportEMail, serialNumber, macAddress);
    }

    private TokenRequest makeTokenRequest(String deviceName, String typeOfDevice, String driverVersion, String supportEMail, String serialNumber, String macAddress) {
        return new TokenRequest(deviceName, typeOfDevice, driverVersion, supportEMail, serialNumber, macAddress);
    }

    private void saveTokenReqStore(TokenRequest req, String hex) throws TokenManagementException {
        FileWriter fileWriter;

        //Generar un HashMap para guardar los objetos
        String storePath = System.getProperty("user.dir") + "/Store/tokenRequestsStore.json";

        //Tengo que cargar el almacen de tokens request en memoria y añadir el nuevo si no existe
        String jsonString = createJsonString(req, hex, storePath);
        try {
            fileWriter = new FileWriter(storePath);
            fileWriter.write(jsonString);
            fileWriter.close();
        } catch (IOException e) {
            throw new TokenManagementException("Error: Unable to save a new token in the internal licenses store");
        }
    }





}
