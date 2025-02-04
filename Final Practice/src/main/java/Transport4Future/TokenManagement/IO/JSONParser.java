package Transport4Future.TokenManagement.IO;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;

import Transport4Future.TokenManagement.Exceptions.TokenManagementException;
import Transport4Future.Utils.TextReader;

public class JSONParser implements ITokenManagementParser {
    /**
     * parses JSON file using inputFile
     *
     * @throws TokenManagementException if any error occurs
     */
    public Object parse(String InputFile) throws TokenManagementException {
        TextReader myReader = new TextReader();
        String fileContents = myReader.getStringFromFile(InputFile);

        return parseJSONFromString(fileContents);
    }
    
    /**
     * parses JSON file using String input
     *
     * @throws TokenManagementException if any error occurs
     */
    public JsonObject parseJSONFromString(String fileContents) throws TokenManagementException {
        JsonObject jsonLicense = null;
        try (StringReader sr = new StringReader(fileContents)) {
            jsonLicense = Json.createReader(sr).readObject();
        } catch (Exception e) {
            throw new TokenManagementException("Error: JSON object cannot be created due to incorrect representation");
        }
        return jsonLicense;
    }
}
