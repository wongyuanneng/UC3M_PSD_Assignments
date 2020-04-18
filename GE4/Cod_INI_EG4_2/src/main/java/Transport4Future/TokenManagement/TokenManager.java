package Transport4Future.TokenManagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.json.Json;
import javax.json.JsonObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;


public class TokenManager implements ITokenManagement {

  private void checkInitialTokenInformationFormat(TokenRequest Request) throws TokenManagementException {
    //before to that I have to check that all the fields are correct
    deviceNameLengthCheck(Request.getDeviceName());
    serialNumLengthCheck(Request.getSerialNumber());
    driverVerLengthCheck(Request.getDriverVersion());
    emailPatternCheck(Request.getSupportEMail());
    licenseRequestCheck(Request.getTypeOfDevice());
    macAddressCheck(Request.getMacAddress());
  }	
  
  private void deviceNameLengthCheck(String deviceName) throws TokenManagementException {
    if (deviceName.length() < 1 || deviceName.length() > 20) {
      throw new TokenManagementException("Error: invalid String length for device name.");	
    }
  }
	
  private void serialNumLengthCheck(String serialNumber) throws TokenManagementException {
    Pattern serialNumberPattern = Pattern.compile("([A-Za-z0-9-]{1,})");
    if  (!serialNumberPattern.matcher(serialNumber).matches()) {
      throw new TokenManagementException("Error: invalid String length for serial number.");	
    }
  }
	
  private void driverVerLengthCheck(String driverVersion) throws TokenManagementException {
    Pattern driverPattern = Pattern.compile("([a-zA-Z0-9]{1}[A-Za-z0-9\\.]{0,24})");
    if ((driverVersion.length() < 1) || (driverVersion.length() > 25) || (!driverPattern.matcher(driverVersion).matches())) {
      throw new TokenManagementException("Error: invalid String length for driver version.");	
    }
  }
	
  private void emailPatternCheck(String email) throws TokenManagementException {
    Pattern mailPattern = Pattern.compile("(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*:(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)(?:,\\s*(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*))*)?;\\s*)");
    if (!mailPattern.matcher(email).matches()) {
      throw new TokenManagementException("Error: invalid E-mail data in JSON structure.");	
    }
  }
	
  private void licenseRequestCheck(String licenseRequest) throws TokenManagementException {
    if (!(licenseRequest.equalsIgnoreCase("Sensor") || licenseRequest.equalsIgnoreCase("Actuator"))) {
      throw new TokenManagementException("Error: invalid type of sensor.");	
    }
  }
	
  private void macAddressCheck(String macAddress) throws TokenManagementException {
    Pattern macPattern = Pattern.compile("([a-fA-F0-9]{2}[:-]){5}[a-fA-F0-9]{2}$");
    if (!macPattern.matcher(macAddress).matches()) {
      throw new TokenManagementException("Error: invalid MAC Address data in JSON structure.");	
    }
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
	
  private String inputFileCheck(String InputFile) throws TokenManagementException {
    String fileContents = "";
    BufferedReader reader = readFile(InputFile);
    fileContents = readFileContents(reader);
    closeFile(reader);
    return fileContents;
  }
	
  private BufferedReader readFile(String InputFile) throws TokenManagementException {
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader(InputFile));
    } catch (FileNotFoundException e) {
      throw new TokenManagementException("Error: input file not found.");
    }
    return reader;
  }
	
  private String readFileContents(BufferedReader reader) throws TokenManagementException {
    String fileContents = "";
    String line;
    try {
      while ((line = reader.readLine()) != null) {
        fileContents += line;
      }
    } catch (IOException e) {
      throw new TokenManagementException("Error: input file could not be accessed.");
    }
    return fileContents;
  }
	
  private void closeFile(BufferedReader reader) throws TokenManagementException {
    try {
      reader.close();
    } catch (IOException e) {
      throw new TokenManagementException("Error: input file could not be closed.");
    }
  }
	
  private JsonObject createJsonLicense(String fileContents) throws TokenManagementException {
    JsonObject jsonLicense = null;
    try(StringReader sr = new StringReader(fileContents)) {
      jsonLicense = Json.createReader(sr).readObject();
    } catch(Exception e) {
      throw new TokenManagementException("Error: JSON object cannot be created due to incorrect representation");
    }
    return jsonLicense;
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
	
  private String hashEncoding(String input, String algo) throws TokenManagementException {
    MessageDigest md = getHashAlgo(algo);
				
    md.update(input.getBytes(StandardCharsets.UTF_8));
    byte[] digest = md.digest();

    // Beware the hex length. If MD5 -> 32:"%032x", but for instance, in SHA-256 it should be "%064x" 
    String hex=null;
    if (algo.equals("MD5")) {
      hex= String.format("%32x", new BigInteger(1, digest));
    }
    else if (algo.equals("SHA-256")){
      hex= String.format("%64x", new BigInteger(1, digest));
    }
		
    return hex;
  }
	
  private MessageDigest getHashAlgo(String algo) throws TokenManagementException {
    MessageDigest md;
    try {
      md = MessageDigest.getInstance(algo);
    } catch (NoSuchAlgorithmException e) {
      throw new TokenManagementException("Error: no such hashing algorithm.");
    }
    return md;
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
	
  private String createJsonString(TokenRequest req, String hex, String storePath) throws TokenManagementException {
    Gson gson = new Gson();
    HashMap<String, TokenRequest> clonedMap = makeClonedMap(gson, storePath);
		
    if (clonedMap==null) {
      clonedMap = new HashMap();
      clonedMap.put (hex, req);	        	
    }
    else if (!clonedMap.containsKey(hex)){
      clonedMap.put (hex, req);
    }
    return gson.toJson(clonedMap);
  }
	
  private HashMap<String, TokenRequest> makeClonedMap(Gson gson, String storePath) throws TokenManagementException {
    String jsonString;
    HashMap<String, TokenRequest> clonedMap;
    try {
      Object object = gson.fromJson(new FileReader(storePath), Object.class);
      jsonString = gson.toJson(object);	
      Type type = new TypeToken<HashMap<String, TokenRequest>>(){}.getType();
      clonedMap = gson.fromJson(jsonString, type);
    } catch (Exception e) {
      clonedMap=null;
      throw new TokenManagementException("Error: unable to recover Token Requests Store.");
    }
    return clonedMap;
  }
	
  private void devicePatternCheck(String device) throws TokenManagementException {
    // Length check for device 
    Pattern devicePattern = Pattern.compile("([A-Fa-f0-9]{32})");
    if  (!devicePattern.matcher(device).matches()) {
      throw new TokenManagementException("Error: invalid Device in token request.");	
    }
  }
	
  private void datePatternCheck(String requestDate) throws TokenManagementException {
    Pattern datePattern = Pattern.compile("(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-[0-9]{4}\\s(2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]");
    if (!datePattern.matcher(requestDate).matches()) {
      throw new TokenManagementException("Error: invalid date data in JSON structure.");	
    }
  }
	
  private void checkTokenRequestInformationFormat(Token TokenToVerify) throws TokenManagementException {
    devicePatternCheck(TokenToVerify.getPayload().getDevice());
    datePatternCheck(TokenToVerify.getRequestDate());
    emailPatternCheck(TokenToVerify.getNotificationEmail());
		
	//Generar un HashMap para guardar los objetos
    Gson gson = new Gson();
    String storePath = System.getProperty("user.dir") + "/Store/tokenRequestsStore.json";

	//Cargar el almacen de tokens request en memoria y añadir el nuevo si no existe
    HashMap<String, TokenRequest> clonedMap = makeClonedMap(gson, storePath);
    if (clonedMap==null || !clonedMap.containsKey(TokenToVerify.getPayload().getDevice())) {
      throw new TokenManagementException("Error: Token Request Not Previously Registered");	        	
    }
  }

  /**
   * Request for a token
   *
   * @throws TokenManagementException if any error occurs
   */
  public String requestToken (String InputFile) throws TokenManagementException{
    Token myToken = null;
		
    String fileContents = inputFileCheck(InputFile);
		
	// Transform the String with the file contents into a JSON object (in memory).
    JsonObject jsonLicense = createJsonLicense(fileContents);
    myToken = checkJsonStruct2(jsonLicense);
		
    checkTokenRequestInformationFormat(myToken);
		
    insertTokenSignature(myToken);
    insertTokenValue(myToken);
		
    TokensStore myStore = new TokensStore();
    myStore.add(myToken);
		
    return myToken.getTokenValue();
  }
	
  private Token checkJsonStruct2(JsonObject jsonLicense) throws TokenManagementException {
    String tokenRquest = "";
    String email = "";
    String date = "";	
    try {			
      tokenRquest = jsonLicense.getString("Token Request");
      email = jsonLicense.getString("Notification e-mail");
      date = jsonLicense.getString("Request Date");					
    } catch (Exception pe) {
      throw new TokenManagementException("Error: invalid input data in JSON structure.");
    }
    return makeToken(tokenRquest, date, email);
  }
	
  private Token makeToken(String tokenRquest, String date, String email) {
    return new Token(tokenRquest, date, email);
  }
	
  private void insertTokenSignature(Token myToken) throws TokenManagementException {
    String input = myToken.headerToString() + myToken.payloadToString();
    String signature = hashEncoding(input, "SHA-256");
    myToken.setSignature(signature);
  }
	
  private void insertTokenValue(Token myToken) {
    String stringToEncode = myToken.headerToString() + myToken.payloadToString() + myToken.getSignature();
    String encodedString = Base64.getUrlEncoder().encodeToString(stringToEncode.getBytes());
    myToken.setTokenValue(encodedString);
  }

  private boolean isValid (Token tokenFound) {
    return ((!tokenFound.getPayload().isExpired()) && (tokenFound.getPayload().isGranted()));
  }
  
  /**
   * Verifies a given token
   *
   * @throws TokenManagementException if any error occurs
   */
  public boolean verifyToken(String Token) throws TokenManagementException{
    TokensStore myStore = new TokensStore();
    Token tokenFound = myStore.find(Token);

    if (tokenFound!=null) {
      return isValid(tokenFound);
    }
    return false;
  }
}