package Transport4Future.TokenManagement.IO;

import java.util.HashMap;

import javax.json.JsonObject;

import Transport4Future.TokenManagement.Exceptions.TokenManagementException;

public class RevocationParser extends JSONParser implements ITokenManagementParser {

    public static final String TOKEN_VALUE = "Token Value";
    public static final String TYPE_OF_REVOCATION = "Type of revocation";
    public static final String REASON = "Reason";
    
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
            items.put(TYPE_OF_REVOCATION, myJSON.getString(TYPE_OF_REVOCATION));
            items.put(REASON, myJSON.getString(REASON));
        } catch (Exception pe) {
            throw new TokenManagementException(ERROR_INVALID_INPUT_DATA_IN_JSON_STRUCTURE);
        }
        return items;
    }

}
