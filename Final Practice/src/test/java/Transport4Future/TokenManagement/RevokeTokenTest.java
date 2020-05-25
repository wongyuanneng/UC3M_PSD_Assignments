package Transport4Future.TokenManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import Transport4Future.TokenManagement.Exceptions.TokenManagementException;
import Transport4Future.TokenManagement.Store.TokensStore;

public class RevokeTokenTest {
    private TokenManager myManager;

    public RevokeTokenTest() {
        myManager = TokenManager.getInstance();
    }

    @Test
    /*
     * Test Case: RevokeToken_EC_V01 Equivalence class: <Valid Temporal> Testing
     * method: <Equivalence class> Expected result: <NotificationEmail
     * "autonomous@vehicle.com">
     */
    void RevokeToken_EC_V01() throws TokenManagementException {
        String InputFilePath = "./TestData/RevokeTokenTest/CorrectFileTemporal.json";
        String Result = "autonomous@vehicle.com";

        String myResult = myManager.RevokeToken(InputFilePath);
        assertEquals(Result, myResult);
    }

    @Test
    /*
     * Test Case: RevokeToken_EC_V02 Equivalence class: <Valid Final> Testing
     * method: <Equivalence class> Expected result: <TokenManagementException
     * "Error: Token previously revoked by this method.">
     */
    void RevokeToken_EC_V02() throws TokenManagementException {
        String InputFilePath = "./TestData/RevokeTokenTest/CorrectFileFinal.json";
        String Result = "Error: Token previously revoked by this method.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.RevokeToken(InputFilePath);
        });
        assertEquals(Result, ex.getMessage());
    }

    @Test
    /*
     * Test Case: RevokeToken_EC_IV01 Equivalence class: <Invalid Without Token
     * Value> Testing method: <Equivalence class> Expected result:
     * <TokenManagementException "Error: invalid input data in JSON structure.">
     */
    void RevokeToken_EC_IV01() throws TokenManagementException {
        String InputFilePath = "./TestData/RevokeTokenTest/FileWithoutTokenValue.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.RevokeToken(InputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: RevokeToken_EC_IV02 Equivalence class: <Invalid Without Type of
     * revocation> Testing method: <Equivalence class> Expected result:
     * <TokenManagementException "Error: invalid input data in JSON structure.">
     */
    void RevokeToken_EC_IV02() throws TokenManagementException {
        String InputFilePath = "./TestData/RevokeTokenTest/FileWithoutTypeOfRevocation.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.RevokeToken(InputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: RevokeToken_EC_IV03 Equivalence class: <Invalid Without Reason>
     * Testing method: <Equivalence class> Expected result:
     * <TokenManagementException "Error: invalid input data in JSON structure.">
     */
    void RevokeToken_EC_IV03() throws TokenManagementException {
        String InputFilePath = "./TestData/RevokeTokenTest/FileWithoutReason.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.RevokeToken(InputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: RevokeToken_EC_IV04 Equivalence class: <Invalid With empty Token
     * value> Testing method: <Equivalence class> Expected result:
     * <TokenManagementException
     * "Error: invalid Token value data in JSON structure.">
     */
    void RevokeToken_EC_IV04() throws TokenManagementException {
        String InputFilePath = "./TestData/RevokeTokenTest/FileEmptyTokenValue.json";
        String expectedMessage = "Error: invalid Token value data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.RevokeToken(InputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: RevokeToken_EC_IV05 Equivalence class: <Invalid With empty Type of
     * revocation> Testing method: <Equivalence class> Expected result:
     * <TokenManagementException
     * "Error: invalid Type of revocation data in JSON structure.">
     */
    void RevokeToken_EC_IV05() throws TokenManagementException {
        String InputFilePath = "./TestData/RevokeTokenTest/FileEmptyTypeOfRevocation.json";
        String expectedMessage = "Error: invalid Type of revocation data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.RevokeToken(InputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: RevokeToken_EC_IV06 Equivalence class: <Invalid With empty Reason>
     * Testing method: <Equivalence class> Expected result:
     * <TokenManagementException "Error: invalid String length for Reason.">
     */
    void RevokeToken_EC_IV06() throws TokenManagementException {
        String InputFilePath = "./TestData/RevokeTokenTest/FileEmptyReason.json";
        String expectedMessage = "Error: invalid String length for Reason.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.RevokeToken(InputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: RevokeToken_EC_IV07 Equivalence class: <Invalid With invalid Token
     * value> Testing method: <Equivalence class> Expected result:
     * <TokenManagementException
     * "Error: invalid Token value data in JSON structure.">
     */
    void RevokeToken_EC_IV07() throws TokenManagementException {
        String InputFilePath = "./TestData/RevokeTokenTest/FileInvalidTokenValue.json";
        String expectedMessage = "Error: invalid Token value data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.RevokeToken(InputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: RevokeToken_EC_IV08 Equivalence class: <Invalid With invalid Type
     * of revocation> Testing method: <Equivalence class> Expected result:
     * <TokenManagementException
     * "Error: invalid Type of revocation data in JSON structure.">
     */
    void RevokeToken_EC_IV08() throws TokenManagementException {
        String InputFilePath = "./TestData/RevokeTokenTest/FileInvalidTypeOfRevocation.json";
        String expectedMessage = "Error: invalid Type of revocation data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.RevokeToken(InputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: RevokeToken_EC_IV09 Equivalence class: <Invalid With Large Reason>
     * Testing method: <Equivalence class> Expected result:
     * <TokenManagementException "Error: invalid String length for Reason.">
     */
    void RevokeToken_EC_IV09() throws TokenManagementException {
        String InputFilePath = "./TestData/RevokeTokenTest/FileLargeReason.json";
        String expectedMessage = "Error: invalid String length for Reason.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.RevokeToken(InputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: RevokeToken_EC_IV10 Equivalence class: <Invalid With Wrong Token
     * value> Testing method: <Equivalence class> Expected result:
     * <TokenManagementException "Error: invalid input data in JSON structure.">
     */
    void RevokeToken_EC_IV10() throws TokenManagementException {
        String InputFilePath = "./TestData/RevokeTokenTest/FileWrongTokenValue.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.RevokeToken(InputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: RevokeToken_EC_IV11 Equivalence class: <Invalid With Wrong Type of
     * revocation> Testing method: <Equivalence class> Expected result:
     * <TokenManagementException "Error: invalid input data in JSON structure.">
     */
    void RevokeToken_EC_IV11() throws TokenManagementException {
        String InputFilePath = "./TestData/RevokeTokenTest/FileWrongTypeOfRevocation.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.RevokeToken(InputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: RevokeToken_EC_IV12 Equivalence class: <Invalid With Wrong Reason>
     * Testing method: <Equivalence class> Expected result:
     * <TokenManagementException "Error: invalid input data in JSON structure.">
     */
    void RevokeToken_EC_IV12() throws TokenManagementException {
        String InputFilePath = "./TestData/RevokeTokenTest/FileWrongReason.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.RevokeToken(InputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    /*
     * @Test Test Case: RevokeToken_EC_IV13 Equivalence class: <Invalid With Non
     * existent token> Testing method: <Equivalence class> Expected result:
     * <TokenManagementException "Error: The token received does not exist.">
     * 
     * void RevokeToken_EC_IV13() throws TokenManagementException { String
     * InputFilePath = "./TestData/RevokeTokenTest/FileNoExistToken.json"; String
     * expectedMessage = "Error: The token received does not exist.";
     * 
     * TokenManagementException ex =
     * Assertions.assertThrows(TokenManagementException.class, ()-> {
     * myManager.RevokeToken(InputFilePath); }); assertEquals
     * (expectedMessage,ex.getMessage()); }
     * 
     * @Test Test Case: RevokeToken_EC_IV14 Equivalence class: <Invalid With Expired
     * Token> Testing method: <Equivalence class> Expected result:
     * <TokenManagementException "Error: The token received has expired.">
     * 
     * void RevokeToken_EC_IV14() throws TokenManagementException { String
     * InputFilePath = "./TestData/RevokeTokenTest/FileTokenExpired.json"; String
     * expectedMessage = "Error: The token received has expired.";
     * 
     * TokenManagementException ex =
     * Assertions.assertThrows(TokenManagementException.class, ()-> {
     * myManager.RevokeToken(InputFilePath); }); assertEquals
     * (expectedMessage,ex.getMessage()); }
     * 
     * @Test Test Case: RevokeToken_EC_IV15 Equivalence class: <Invalid With Wrong
     * File format> Testing method: <Equivalence class> Expected result:
     * <TokenManagementException
     * "Error: The input file has any problem related to its format or to its access."
     * >
     * 
     * void RevokeToken_EC_IV15() throws TokenManagementException { String
     * InputFilePath = "./TestData/RevokeTokenTest/FileWrongFormat.txt"; String
     * expectedMessage =
     * "Error: The input file has any problem related to its format or to its access."
     * ;
     * 
     * TokenManagementException ex =
     * Assertions.assertThrows(TokenManagementException.class, ()-> {
     * myManager.RevokeToken(InputFilePath); }); assertEquals
     * (expectedMessage,ex.getMessage()); }
     * 
     * @Test Test Case: RevokeToken_EC_IVF01 Equivalence class: <Invalid With Large
     * Reason> Testing method: <Equivalence class> Expected result:
     * <TokenManagementException "Error: input file not found.">
     * 
     * void RevokeToken_EC_IVF01() throws TokenManagementException { String
     * InputFilePath = "./TestData/RevokeTokenTest/NonExistingFile.json"; String
     * expectedMessage = "Error: input file not found.";
     * 
     * TokenManagementException ex =
     * Assertions.assertThrows(TokenManagementException.class, ()-> {
     * myManager.RevokeToken(InputFilePath); }); assertEquals
     * (expectedMessage,ex.getMessage()); }
     * 
     * @Test Test Case: RevokeToken_EC_IVF02 Equivalence class: <Invalid With Empty
     * file> Testing method: <Equivalence class> Expected result:
     * <TokenManagementException
     * "Error: JSON object cannot be created due to incorrect representation">
     * 
     * void RevokeToken_EC_IVF02() throws TokenManagementException { String
     * InputFilePath = "./TestData/RevokeTokenTest/EmptyFile.json"; String
     * expectedMessage =
     * "Error: JSON object cannot be created due to incorrect representation";
     * 
     * TokenManagementException ex =
     * Assertions.assertThrows(TokenManagementException.class, ()-> {
     * myManager.RevokeToken(InputFilePath); }); assertEquals
     * (expectedMessage,ex.getMessage()); }
     * 
     * @Test Test Case: RevokeToken_EC_IVF03 Equivalence class: <Invalid With Non
     * JSON file> Testing method: <Equivalence class> Expected result:
     * <TokenManagementException
     * "Error: JSON object cannot be created due to incorrect representation">
     * 
     * void RevokeToken_EC_IVF03() throws TokenManagementException { String
     * InputFilePath = "./TestData/RevokeTokenTest/NonJSONFile.json"; String
     * expectedMessage =
     * "Error: JSON object cannot be created due to incorrect representation";
     * 
     * TokenManagementException ex =
     * Assertions.assertThrows(TokenManagementException.class, ()-> {
     * myManager.RevokeToken(InputFilePath); }); assertEquals
     * (expectedMessage,ex.getMessage()); }
     */

    /*
     * @DisplayName ("Invalid Test Cases")
     * 
     * @ParameterizedTest(name = "{index} - {2}")
     * 
     * @CsvFileSource(resources = "/invalidTestCasesRevokeTokenTest.csv") void
     * InvalidTestCases(String InputFilePath, String expectedMessage) throws
     * TokenManagementException { TokenManagementException ex =
     * Assertions.assertThrows(TokenManagementException.class, ()-> {
     * myManager.RevokeToken(InputFilePath); }); assertEquals
     * (expectedMessage,ex.getMessage()); }
     * 
     * @DisplayName ("Valid Test Cases")
     * 
     * @ParameterizedTest(name = "{index} - {2}")
     * 
     * @CsvFileSource(resources = "/validTestCasesRevokeTokenTest.csv") void
     * ValidTestCases(String InputFilePath, String Result) throws
     * TokenManagementException { String myResult =
     * myManager.RevokeToken(InputFilePath); assertEquals (Result,myResult); }
     */
}
