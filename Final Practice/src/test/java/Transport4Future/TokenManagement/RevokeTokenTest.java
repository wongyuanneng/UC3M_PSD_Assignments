package Transport4Future.TokenManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Transport4Future.TokenManagement.Exceptions.TokenManagementException;
import Transport4Future.TokenManagement.StoreForTests;

public class RevokeTokenTest {
    private TokenManager myManager;
    private StoreForTests storeTokens;

    public RevokeTokenTest() throws TokenManagementException {
        myManager = TokenManager.getInstance();
        this.resetDeactivatedTokenStore();
        storeTokens = new StoreForTests();
        storeTokens.insertFirstToken();
        storeTokens.insertSecondToken();
    }
    
    public void resetDeactivatedTokenStore () throws TokenManagementException {
        String storePath = System.getProperty("user.dir") + "/Store/deactivatedTokenStore.json";
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(storePath);
            fileWriter.close();
        } catch (IOException e) {
            throw new TokenManagementException("Error: Unable to save a new token in the deactivated licenses store");
        }		
    }

    
    /*---------------------------------------------BV & EC--------------------------------------------------------------------------*/

    @Test
    /*
     * Test Case: EC_V01
     * Equivalence class: <Valid Temporal>, <Output is a String>, <Output is an email>
     * Testing method: <Equivalence class> 
     * Expected result: <NotificationEmail "autonomous@vehicle.com">
     */
    void ec_V01() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/CorrectFileTemporal.json";
        String expected = "autonomous1@vehicle.com";
        String myResult = myManager.revokeToken(inputFilePath);
        if (myResult instanceof String) {
            String p = "(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*:(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)(?:,\\s*(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*))*)?;\\s*)";
            Pattern pattern = Pattern.compile(p);
            if (!pattern.matcher(myResult).matches()) {
                Assertions.fail("Error: Output is not an email");
            }
        } else {
            Assertions.fail("Error: Output is not a string");
        }
        Assertions.assertEquals(expected,myResult);
    }

    @Test
    /*
     * Test Case: EC_V02 
     * Equivalence class: <Valid Final>, <Output is a String>, <Output is an email> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: Token previously revoked by this method.">
     */
    void ec_V02() throws TokenManagementException {
        myManager.tokenRequestGeneration(System.getProperty("user.dir") + "/TestData/RevokeTokenTest/CorrectFileRequest2.json");
        myManager.requestToken(System.getProperty("user.dir") + "/TestData/RevokeTokenTest/CorrectTokenRequest2.json");
        
        String inputFilePath = "./TestData/RevokeTokenTest/CorrectFileFinal.json";
        String expected = "autonomous2@vehicle.com";
        String myResult = myManager.revokeToken(inputFilePath);
        if (myResult instanceof String) {
            String p = "(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*:(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)(?:,\\s*(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*))*)?;\\s*)";
            Pattern pattern = Pattern.compile(p);
            if (!pattern.matcher(myResult).matches()) {
                Assertions.fail("Error: Output is not an email");
            }
        } else {
            Assertions.fail("Error: Output is not a string");
        }
        Assertions.assertEquals(expected,myResult);
    }

    @Test
    /*
     * Test Case: EC_IV01 
     * Equivalence class: <Invalid Without Token Value> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: invalid input data in JSON structure.">
     */
    void ec_IV01() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/FileWithoutTokenValue.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: EC_IV02 
     * Equivalence class: <Invalid Without Type of revocation> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: invalid input data in JSON structure.">
     */
    void ec_IV02() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/FileWithoutTypeOfRevocation.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: EC_IV03 
     * Equivalence class: <Invalid Without Reason> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: invalid input data in JSON structure.">
     */
    void ec_IV03() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/FileWithoutReason.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: EC_IV04 
     * Equivalence class: <Invalid With empty Token value> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: invalid Token value data in JSON structure.">
     */
    void ec_IV04() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/FileEmptyTokenValue.json";
        String expectedMessage = "Error: invalid Token value data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: EC_IV05 
     * Equivalence class: <Invalid With empty Type of revocation> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: invalid Type of revocation data in JSON structure.">
     */
    void ec_IV05() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/FileEmptyTypeOfRevocation.json";
        String expectedMessage = "Error: invalid Type of revocation data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: EC_IV06 
     * Equivalence class: <Invalid With empty Reason> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: invalid String length for Reason.">
     */
    void ec_IV06() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/FileEmptyReason.json";
        String expectedMessage = "Error: invalid String length for Reason.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: EC_IV07 
     * Equivalence class: <Invalid With invalid Token value> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: invalid Token value data in JSON structure.">
     */
    void ec_IV07() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/FileInvalidTokenValue.json";
        String expectedMessage = "Error: invalid Token value data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: EC_IV08 
     * Equivalence class: <Invalid With invalid Type of revocation> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: invalid Type of revocation data in JSON structure.">
     */
    void ec_IV08() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/FileInvalidTypeOfRevocation.json";
        String expectedMessage = "Error: invalid Type of revocation data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: EC_IV09 
     * Equivalence class: <Invalid With Large Reason> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: invalid String length for Reason.">
     */
    void ec_IV09() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/FileLargeReason.json";
        String expectedMessage = "Error: invalid String length for Reason.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: EC_IV10 
     * Equivalence class: <Invalid With Wrong Token value> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: invalid input data in JSON structure.">
     */
    void ec_IV10() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/FileWrongTokenValue.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: EC_IV11 
     * Equivalence class: <Invalid With Wrong Type of revocation> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: invalid input data in JSON structure.">
     */
    void ec_IV11() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/FileWrongTypeOfRevocation.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: EC_IV12 
     * Equivalence class: <Invalid With Wrong Reason>
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: invalid input data in JSON structure.">
     */
    void ec_IV12() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/FileWrongReason.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /*
     * Test Case: EC_IVF01 
     * Equivalence class: <Invalid With Large Reason> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: input file not found.">
     */
    void ec_IVF01() throws TokenManagementException { 
        String inputFilePath = "./TestData/RevokeTokenTest/NonExistingFile.json"; 
        String expectedMessage = "Error: input file not found.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, ()-> {
            myManager.revokeToken(inputFilePath); 
        }); 
        assertEquals(expectedMessage,ex.getMessage()); 
    }

    @Test 
    /* 
     * Test Case: EC_IVF02 
     * Equivalence class: <Invalid With Empty file> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: JSON object cannot be created due to incorrect representation">
     */
    void ec_IVF02() throws TokenManagementException { 
        String inputFilePath = "./TestData/RevokeTokenTest/EmptyFile.json"; 
        String expectedMessage ="Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, ()-> {
            myManager.revokeToken(inputFilePath); 
        }); 
        assertEquals(expectedMessage,ex.getMessage()); 
    }

    @Test 
    /* 
     * Test Case: EC_IVF03 
     * Equivalence class: <Invalid With Non JSON file> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: JSON object cannot be created due to incorrect representation">
     */
    void ec_IVF03() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/NonJSONFile.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }
    
    @Test 
    /* 
     * Test Case: EC_IVO01 
     * Equivalence class: <Invalid With already revoked token> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: Token previously revoked by this method.">
     */
    void ec_IVO01() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/CorrectFileTemporal.json";
        String expected = "The token received does not exist.";
        myManager.revokeToken(inputFilePath);
        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expected, ex.getMessage());
    }

    /*------------------------------------------------------------------------------------------------------------------------------*/

    /*------------------------------------------------SYNTAX ANALYSIS---------------------------------------------------------------*/
    @Test
    /* Test Case: <Syntax_V01 - All terminal nodes covered with valid cases, Temporal>
     * Related derivation tree nodes: <5, 11, 15, 19, 26, 33, 40, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61>
     * Testing method: <Syntax analysis>
     * Expected result: <"autonomous@vehicle.com" OR "Error: Token previously revoked by this method.">
     */
    void syntax_V01() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_V01.json";
        String expected = "autonomous1@vehicle.com";
        String myResult = myManager.revokeToken(inputFilePath);
        if (myResult instanceof String) {
            String p = "(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*:(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)(?:,\\s*(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*))*)?;\\s*)";
            Pattern pattern = Pattern.compile(p);
            if (!pattern.matcher(myResult).matches()) {
                Assertions.fail("Error: Output is not an email");
            }
        } else {
            Assertions.fail("Error: Output is not a string");
        }
        Assertions.assertEquals(expected,myResult);
    }

    @Test
    /* Test Case: <Syntax_V02 - All terminal nodes covered with valid cases, Final>
     * Related derivation tree nodes: <5, 11, 15, 19, 26, 33, 40, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61>
     * Testing method: <Syntax analysis>
     * Expected result: <"autonomous@vehicle.com" OR "Error: Token previously revoked by this method.">
     */
    void syntax_V02() throws TokenManagementException {
        myManager.tokenRequestGeneration(System.getProperty("user.dir") + "/TestData/RevokeTokenTest/CorrectFileRequest3.json");
        myManager.requestToken(System.getProperty("user.dir") + "/TestData/RevokeTokenTest/CorrectTokenRequest3.json");
        
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_V02.json";
        String expected = "autonomous1@vehicle.com";
        String myResult = myManager.revokeToken(inputFilePath);
        if (myResult instanceof String) {
            String p = "(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*:(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)(?:,\\s*(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*))*)?;\\s*)";
            Pattern pattern = Pattern.compile(p);
            if (!pattern.matcher(myResult).matches()) {
                Assertions.fail("Error: Output is not an email");
            }
        } else {
            Assertions.fail("Error: Output is not a string");
        }
        Assertions.assertEquals(expected,myResult);
    }

    @Test 
    /* Test Case: <Syntax_IV01 - Non-Terminal 1 omission>
     * Related derivation tree nodes: <1-61>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV01() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV01.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV02 - Non-Terminal 2 omission>
     * Related derivation tree nodes: <2, 5>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV02() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV02.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV03 - Non-Terminal 2 repetition>
     * Related derivation tree nodes: <2, 5>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV03() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV03.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV04 - Non-Terminal 3 omission>
     * Related derivation tree nodes: <6, 7, 8, 9, 10, 12, 13, 14, 16, 17, 18, 20, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32, 34, 35, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 54, 57, 60>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid input data in JSON structure.">
     */
    void syntax_IV04() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV04.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV05 - Non-Terminal 3 repetition>
     * Related derivation tree nodes: <6, 7, 8, 9, 10, 12, 13, 14, 16, 17, 18, 20, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32, 34, 35, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 54, 57, 60>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV05() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV05.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV06 - Non-Terminal 6 omission>
     * Related derivation tree nodes: <6, 12, 13, 14, 23, 24, 25, 26, 27, 28, 29, 44, 45, 46, 47, 48, 49>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV06() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV06.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV07 - Non-Terminal 6 repetition>
     * Related derivation tree nodes: <6, 12, 13, 14, 23, 24, 25, 26, 27, 28, 29, 44, 45, 46, 47, 48, 49>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV07() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV07.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV08 - Non-Terminal 7 omission>
     * Related derivation tree nodes: <7, 15>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV08() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV08.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV09 - Non-Terminal 7 repetition>
     * Related derivation tree nodes: <7, 15>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV09() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV09.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV10 - Non-Terminal 12 omission>
     * Related derivation tree nodes: <12, 23, 24, 25, 44, 45, 46>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV10() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV10.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV11 - Non-Terminal 12 repetition>
     * Related derivation tree nodes: <12, 23, 24, 25, 44, 45, 46>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV11() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV11.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV12 - Non-Terminal 13 omission>
     * Related derivation tree nodes: <13, 26>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV12() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV12.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV13 - Non-Terminal 13 repetition>
     * Related derivation tree nodes: <13, 26>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV13() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV13.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV14 - Non-Terminal 14 omission>
     * Related derivation tree nodes: <14, 27, 28, 29, 47, 48, 49>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV14() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV14.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV15 - Non-Terminal 14 repetition>
     * Related derivation tree nodes: <14, 27, 28, 29, 47, 48, 49>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV15() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV15.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV16 - Non-Terminal 23 omission>
     * Related derivation tree nodes: <23, 44>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV16() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV16.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV17 - Non-Terminal 23 repetition>
     * Related derivation tree nodes: <23, 44>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV17() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV17.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV18 - Non-Terminal 24 omission>
     * Related derivation tree nodes: <24, 45>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid input data in JSON structure.">
     */
    void syntax_IV18() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV18.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV19 - Non-Terminal 24 repetition>
     * Related derivation tree nodes: <24, 45>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid input data in JSON structure.">
     */
    void syntax_IV19() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV19.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV20 - Non-Terminal 25 omission>
     * Related derivation tree nodes: <25, 46>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV20() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV20.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV21 - Non-Terminal 25 repetition>
     * Related derivation tree nodes: <25, 46>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV21() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV21.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV22 - Terminal 26 modification>
     * Related derivation tree nodes: <26>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV22() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV22.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV23 - Non-Terminal 27 omission>
     * Related derivation tree nodes: <27, 47>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV23() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV23.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV24 - Non-Terminal 27 repetition>
     * Related derivation tree nodes: <27, 47>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV24() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV24.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV25 - Non-Terminal 28 omission>
     * Related derivation tree nodes: <28, 48>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid Token value data in JSON structure.">
     */
    void syntax_IV25() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV25.json";
        String expectedMessage = "Error: invalid Token value data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV26 - Non-Terminal 29 omission>
     * Related derivation tree nodes: <29, 49>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV26() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV26.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV27 - Non-Terminal 29 repetition>
     * Related derivation tree nodes: <29, 49>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV27() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV27.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV28 - Non-Terminal 35 omission>
     * Related derivation tree nodes: <35, 54>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid Type of revocation data in JSON structure.">
     */
    void syntax_IV28() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV28.json";
        String expectedMessage = "Error: invalid Type of revocation data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV29 - Non-Terminal 35 repetition>
     * Related derivation tree nodes: <35, 54>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid Type of revocation data in JSON structure.">
     */
    void syntax_IV29() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV29.json";
        String expectedMessage = "Error: invalid Type of revocation data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }
    
    @Test 
    /* Test Case: <Syntax_IV30 - Non-Terminal 42 omission>
     * Related derivation tree nodes: <42, 60>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid String length for Reason.">
     */
    void syntax_IV30() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV30.json";
        String expectedMessage = "Error: invalid String length for Reason.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV31 - Non-Terminal 42 repetition>
     * Related derivation tree nodes: <42, 60>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid String length for Reason.">
     */
    void syntax_IV31() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV31.json";
        String expectedMessage = "Error: invalid String length for Reason.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV32 - Terminal 5 modification>
     * Related derivation tree nodes: <5>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV32() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV32.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV33 - Terminal 11 modification>
     * Related derivation tree nodes: <11>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV33() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV33.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV34 - Terminal 15 modification>
     * Related derivation tree nodes: <15>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV34() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV34.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV35 - Terminal 44 modification>
     * Related derivation tree nodes: <44>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV35() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV35.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV36 - Terminal 45 modification>
     * Related derivation tree nodes: <45>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid input data in JSON structure.">
     */
    void syntax_IV36() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV36.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV37 - Terminal 46 modification>
     * Related derivation tree nodes: <46>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV37() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV37.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV38 - Terminal 47 modification>
     * Related derivation tree nodes: <47>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV38() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV38.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV39 - Terminal 48 modification>
     * Related derivation tree nodes: <48>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid Token value data in JSON structure.">
     */
    void syntax_IV39() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV39.json";
        String expectedMessage = "Error: invalid Token value data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV40 - Terminal 49 modification>
     * Related derivation tree nodes: <49>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV40() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV40.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV41 - Terminal 51 modification>
     * Related derivation tree nodes: <51>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid input data in JSON structure.">
     */
    void syntax_IV41() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV41.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV42 - Terminal 54 modification>
     * Related derivation tree nodes: <54>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid Type of revocation data in JSON structure.">
     */
    void syntax_IV42() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV42.json";
        String expectedMessage = "Error: invalid Type of revocation data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV43 - Terminal 57 modification>
     * Related derivation tree nodes: <57>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid input data in JSON structure.">
     */
    void syntax_IV43() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV43.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax_IV44 - Terminal 60 modification>
     * Related derivation tree nodes: <60>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid Reason data in JSON structure.">
     */
    void syntax_IV44() throws TokenManagementException {
        String inputFilePath = "./TestData/RevokeTokenTest/Syntax_IV44.json";
        String expectedMessage = "Error: invalid Reason data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.revokeToken(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }


    /*
     * @DisplayName ("Invalid Test Cases")
     * 
     * @ParameterizedTest(name = "{index} - {2}")
     * 
     * @CsvFileSource(resources = "/invalidTestCasesRevokeTokenTest.csv") void
     * InvalidTestCases(String inputFilePath, String expectedMessage) throws
     * TokenManagementException { TokenManagementException ex =
     * Assertions.assertThrows(TokenManagementException.class, ()-> {
     * myManager.RevokeToken(inputFilePath); }); assertEquals
     * (expectedMessage,ex.getMessage()); }
     * 
     * @DisplayName ("Valid Test Cases")
     * 
     * @ParameterizedTest(name = "{index} - {2}")
     * 
     * @CsvFileSource(resources = "/validTestCasesRevokeTokenTest.csv") void
     * ValidTestCases(String inputFilePath, String Result) throws
     * TokenManagementException { String myResult =
     * myManager.RevokeToken(inputFilePath); assertEquals (Result,myResult); }
     */
}
