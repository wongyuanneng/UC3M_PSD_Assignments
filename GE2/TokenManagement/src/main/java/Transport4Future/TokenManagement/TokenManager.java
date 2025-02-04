package Transport4Future.TokenManagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.json.Json;
import javax.json.JsonObject;


public class TokenManager {

  /**
 * @param path some path
 * @return something?
 * @throws TokenManagementException check exception
 */
  public TokenRequest readTokenRequestFromJSON(String path) throws TokenManagementException {
    TokenRequest req = null;

    String fileContents = "";

    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader(path));
    } catch (FileNotFoundException e) {
      throw new TokenManagementException("Error: input file not found.");
    }
    String line;
    try {
      while ((line = reader.readLine()) != null) {
        fileContents += line;
      }
    } catch (IOException e) {
      throw new TokenManagementException("Error: input file could not be accessed.");
    }
    try {
      reader.close();
    } catch (IOException e) {
      throw new TokenManagementException("Error: input file could not be closed.");
    }

    JsonObject jsonLicense = Json.createReader(new StringReader(fileContents)).readObject();

    DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);

    try {
      String deviceName = jsonLicense.getString("Device Name");
      Date requestDate = df.parse(jsonLicense.getString("Request Date"));
      String serialNumber = jsonLicense.getString("Serial Number");
      String macAddress = jsonLicense.getString("MAC Address");
			
      req = new TokenRequest(deviceName, requestDate, serialNumber, macAddress);
    } catch (ParseException pe) {
      throw new TokenManagementException("Error: invalid input data in JSON structure.");
    }

    return req;
  }
}
