package Transport4Future.TokenManagement.IO;

import java.util.HashMap;

import javax.json.JsonObject;

import Transport4Future.TokenManagement.Exceptions.TokenManagementException;

public class OperationParser extends JSONParser implements ITokenManagementParser {
    
    public static final String TOKEN_VALUE = "Token Value";
    public static final String TYPE_OF_OPERATION = "Type of Operation";
    
    private static final String ERROR_INVALID_INPUT_DATA_IN_JSON_STRUCTURE = "Error: invalid input data in JSON structure.";
    
    /**
     * parses JSON file using inputFile
     *
     * @throws TokenManagementException if any error occurs
     */
    public HashMap<String, String> parse(String FileName) throws TokenManagementException {
        JsonObject myJSON = (JsonObject) super.parse(FileName);
        HashMap<String, String> items = new HashMap<String, String>();

        try {
            items.put(TOKEN_VALUE, myJSON.getString(TOKEN_VALUE));
            items.put(TYPE_OF_OPERATION, myJSON.getString(TYPE_OF_OPERATION));
        } catch (Exception pe) {
            throw new TokenManagementException(ERROR_INVALID_INPUT_DATA_IN_JSON_STRUCTURE);
        }
        return items;
    }

}
