package Transport4Future.TokenManagement.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;

public class JsonFileParser {
   
    /**
     * Creates a json license from using the contents of the json file read.
     *
     * @throws TokenManagementException if any error occurs
     */
    public JsonObject createJsonLicense(String inputFile) throws TokenManagementException {
        String fileContents = this.inputFileCheck(inputFile);
        JsonObject jsonLicense = null;
        try(StringReader sr = new StringReader(fileContents)) {
            jsonLicense = Json.createReader(sr).readObject();
        } catch(Exception e) {
            throw new TokenManagementException("Error: JSON object cannot be created due to incorrect representation");
        }
        return jsonLicense;
    }
    
    /**
     * Checks for input file - existence, readability, accessibility, writable, closable
     *
     * @throws TokenManagementException if any error occurs
     */
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




    
}
