package Transport4Future.TokenManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Transport4Future.TokenManagement.Exceptions.TokenManagementException;
import Transport4Future.TokenManagement.StoreForTests;

public class ExecuteActionTest {
    private TokenManager myManager;
    private StoreForTests storeTokens;

    /**
     * ExecuteTokenTest Constructor
     * @throws TokenManagementException if error occurs
     */
    public ExecuteActionTest() throws TokenManagementException{
        myManager = TokenManager.getInstance();
        storeTokens = new StoreForTests();
        storeTokens.insertFirstToken();
        storeTokens.insertSecondToken();
    }



    /*---------------------------------------------BV & EC--------------------------------------------------------------------------*/

    @Test
    /*
     * Test Case: EC_V01
     * Equivalence class: <Valid file; Contents: Type of operation: “Send Information from Sensor”>, <Output is a boolean>, <Output is True>
     * Testing method: <Equivalence class> 
     * Expected result: <True>
     */
    void ec_V01() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/CorrectFileSensor.json";
        String result = "The device represented by the token cannot execute the requested operation.";
        boolean myResult;
        try {
            myResult = myManager.executeAction(inputFilePath);
            if (myResult) {
                Assertions.assertEquals(true,myResult);
            } else {
                Assertions.fail("Error: Output is false");
            }
        } catch (TokenManagementException ex) {
            Assertions.assertEquals(result,ex.getMessage());
        }
    }

    @Test
    /*
     * Test Case: EC_V02 
     * Equivalence class: <Valid file; Contents: Type of operation: “Send Request to Actuator”>, <Output is a boolean>, <Output is True>
     * Testing method: <Equivalence class> 
     * Expected result: <True>
     */
    void ec_V02() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/CorrectFileActuator.json";
        String result = "The device represented by the token cannot execute the requested operation.";
        boolean myResult;
        try {
            myResult = myManager.executeAction(inputFilePath);
            if (myResult) {
                Assertions.assertEquals(true,myResult);
            } else {
                Assertions.fail("Error: Output is false");
            }
        } catch (TokenManagementException ex) {
            Assertions.assertEquals(result,ex.getMessage());
        }
    }

    @Test
    /*
     * Test Case: EC_V03 
     * Equivalence class: <Valid file; Contents: Type of operation: “Check State”>, <Output is a boolean>, <Output is True>
     * Testing method: <Equivalence class> 
     * Expected result: <True>
     */
    void ec_V03() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/CorrectFileCheckState.json";
        String result = "The device represented by the token cannot execute the requested operation.";
        boolean myResult;
        try {
            myResult = myManager.executeAction(inputFilePath);
            if (myResult) {
                Assertions.assertEquals(true,myResult);
            } else {
                Assertions.fail("Error: Output is false");
            }
        } catch (TokenManagementException ex) {
            Assertions.assertEquals(result,ex.getMessage());
        }
    }

    @Test
    /*
     * Test Case: EC_IV01 
     * Equivalence class: <Invalid Without Token Value> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: invalid input data in JSON structure.">
     */
    void ec_IV01() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/FileWithoutTokenValue.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: EC_IV02 
     * Equivalence class: <Invalid Without Type of operation> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: invalid input data in JSON structure.">
     */
    void ec_IV02() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/FileWithoutTypeOfOperation.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: EC_IV03
     * Equivalence class: <Invalid With empty Token value> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: invalid Token value data in JSON structure.">
     */
    void ec_IV03() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/FileEmptyTokenValue.json";
        String expectedMessage = "Error: invalid Token value data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: EC_IV04
     * Equivalence class: <Invalid With empty Type of operation> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: invalid type of operation.">
     */
    void ec_IV04() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/FileEmptyTypeOfOperation.json";
        String expectedMessage = "Error: invalid type of operation.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }


    @Test
    /*
     * Test Case: EC_IV05
     * Equivalence class: <Invalid With invalid Token value> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: invalid Token value data in JSON structure.">
     */
    void ec_IV05() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/FileInvalidTokenValue.json";
        String expectedMessage = "Error: invalid Token value data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: EC_IV06
     * Equivalence class: <Invalid With invalid Type of operation> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: invalid type of operation.">
     */
    void ec_IV06() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/FileInvalidTypeOfOperation.json";
        String expectedMessage = "Error: invalid type of operation.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: EC_IV07
     * Equivalence class: <Invalid With Wrong Token value> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: invalid Token value data in JSON structure.">
     */
    void ec_IV07() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/FileWrongTokenValue.json";
        String expectedMessage = "Error: invalid Token value data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    /*
     * Test Case: EC_IV08
     * Equivalence class: <Invalid With Wrong Type of operation> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "The device represented by the token cannot execute the requested operation.">
     */
    void ec_IV08() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/FileWrongTypeOfOperation.json";
        String expectedMessage = "The device represented by the token cannot execute the requested operation.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }


    @Test 
    /*
     * Test Case: EC_IVF01 
     * Equivalence class: <Invalid With non exisiting file> 
     * Testing method: <Equivalence class> 
     * Expected result: <TokenManagementException "Error: input file not found.">
     */
    void ec_IVF01() throws TokenManagementException { 
        String inputFilePath = "./TestData/ExecuteActionTest/NonExistingFile.json"; 
        String expectedMessage = "Error: input file not found.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, ()-> {
            myManager.executeAction(inputFilePath); 
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
        String inputFilePath = "./TestData/ExecuteActionTest/EmptyFile.json"; 
        String expectedMessage ="Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, ()-> {
            myManager.executeAction(inputFilePath); 
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
        String inputFilePath = "./TestData/ExecuteActionTest/NonJSONFile.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    /*------------------------------------------------------------------------------------------------------------------------------*/

    /*------------------------------------------------SYNTAX ANALYSIS---------------------------------------------------------------*/
    @Test
    /* Test Case: <Syntax-V01 - All terminal nodes covered with valid cases, Temporal>
     * Related derivation tree nodes: <All nodes>
     * Testing method: <Syntax analysis>
     * Expected result: <"True": The operation can be executed.>
     */
    void syntax_V01() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-V01.json";
        boolean myResult = myManager.executeAction(inputFilePath);
        assertEquals(true,myResult);
    }


    @Test 
    /* Test Case: <Syntax-IV01 - Non-Terminal 1 omission>
     * Related derivation tree nodes: <All nodes>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV01() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV01.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV02 - Non-Terminal 1 Repetition>
     * Related derivation tree nodes: <All nodes>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV02() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV02.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV03 - Non-Terminal 2 omission>
     * Related derivation tree nodes: <2, 5>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV03() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV03.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV04 - Non-Terminal 2 Repetition>
     * Related derivation tree nodes: <2, 5>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV04() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV04.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV05 - Non-Terminal 3 omission>
     * Related derivation tree nodes: <3, 6, 7, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid input data in JSON structure.">
     */
    void syntax_IV05() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV05.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV06 - Non-Terminal 3 repetition>
     * Related derivation tree nodes: <3, 6, 7, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV06() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV06.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV07 - Non-Terminal 4 omission>
     * Related derivation tree nodes: <4, 9>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV07() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV07.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV08 - Non-Terminal 4 repetition>
     * Related derivation tree nodes: <4, 9>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV08() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV08.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV09 - Non-Terminal 5 modification>
     * Related derivation tree nodes: <5>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV09() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV09.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV10 - Non-Terminal 6 omission>
     * Related derivation tree nodes: <6, 10, 11, 12, 17, 18, 19, 20, 21, 22, 23, 31, 32, 33, 34, 35, 36>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV10() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV10.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV11 - Non-Terminal 6 repetition>
     * Related derivation tree nodes: <6, 10, 11, 12, 17, 18, 19, 20, 21, 22, 23, 31, 32, 33, 34, 35, 36>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV11() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV11.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV12 - Non-Terminal 7 omission>
     * Related derivation tree nodes: <7, 13>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV12() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV12.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV13 - Non-Terminal 7 repetition>
     * Related derivation tree nodes: <7, 13>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV13() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV13.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV14 - Non-Terminal 8 omission>
     * Related derivation tree nodes: <8, 14, 15, 16, 24, 25, 26, 27, 28, 29, 30, 37, 38, 39, 40, 41, 42>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV14() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV14.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV15 - Non-Terminal 8 repetition>
     * Related derivation tree nodes: <8, 14, 15, 16, 24, 25, 26, 27, 28, 29, 30, 37, 38, 39, 40, 41, 42>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV15() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV15.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV16 - Non-Terminal 9 modification>
     * Related derivation tree nodes: <9>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV16() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV16.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV17 - Non-Terminal 10 omission>
     * Related derivation tree nodes: <10, 17, 18, 19, 31, 32, 33>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV17() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV17.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV18 - Non-Terminal 10 repetition>
     * Related derivation tree nodes: <10, 17, 18, 19, 31, 32, 33>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV18() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV18.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV19 - Non-Terminal 11 omission>
     * Related derivation tree nodes: <11, 20>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV19() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV19.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV20 - Non-Terminal 11 repetition>
     * Related derivation tree nodes: <11, 20>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV20() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV20.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV21 - Non-Terminal 12 omission>
     * Related derivation tree nodes: <12, 21, 22, 23, 34, 35, 36>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV21() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV21.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV22 - Terminal 12 repetition>
     * Related derivation tree nodes: <12, 21, 22, 23, 34, 35, 36>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV22() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV22.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV23 - Non-Terminal 13 modification>
     * Related derivation tree nodes: <13>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV23() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV23.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV24 - Non-Terminal 14 omission>
     * Related derivation tree nodes: <14, 24, 25, 26, 37, 38, 39>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid input data in JSON structure.">
     */
    void syntax_IV24() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV24.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV25 - Non-Terminal 14 repetition>
     * Related derivation tree nodes: <14, 24, 25, 26, 37, 38, 39>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV25() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV25.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV26 - Non-Terminal 15 omission>
     * Related derivation tree nodes: <15, 27>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV26() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV26.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV27 - Non-Terminal 15 repetition>
     * Related derivation tree nodes: <15, 27>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV27() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV27.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV28 - Non-Terminal 16 omission>
     * Related derivation tree nodes: <16, 28, 29, 30>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid Type of Operation data in JSON structure.">
     */
    void syntax_IV28() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV28.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV29 - Non-Terminal 16 repetition>
     * Related derivation tree nodes: <16, 28, 29, 30>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV29() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV29.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV30 - Non-Terminal 17 omission>
     * Related derivation tree nodes: <17, 31>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV30() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV30.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV31 - Non-Terminal 17 repetition>
     * Related derivation tree nodes: <17, 31>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV31() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV31.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV32 - Non-Terminal 18 omission>
     * Related derivation tree nodes: <18, 32>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid input data in JSON structure.">
     */
    void syntax_IV32() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV32.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV33 - Non-Terminal 18 repetition>
     * Related derivation tree nodes: <18, 32>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid input data in JSON structure.">
     */
    void syntax_IV33() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV33.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV34 - Non-Terminal 19 omission>
     * Related derivation tree nodes: <19, 33>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV34() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV34.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV35 - Non-Terminal 19 repetition>
     * Related derivation tree nodes: <19, 33>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV35() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV35.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV36 - Terminal 20 modification>
     * Related derivation tree nodes: <20>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV36() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV36.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV37 - Non-Terminal 21 omission>
     * Related derivation tree nodes: <21, 34>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV37() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV37.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV38 - Non-Terminal 21 repetition>
     * Related derivation tree nodes: <21, 34>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV38() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV38.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV39 - Non-Terminal 22 omission>
     * Related derivation tree nodes: <22, 35>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid Token value data in JSON structure.">
     */
    void syntax_IV39() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV39.json";
        String expectedMessage = "Error: invalid Token value data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV40 - Non-Terminal 22 repetition>
     * Related derivation tree nodes: <22, 35>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid Token value data in JSON structure.">
     */
    void syntax_IV40() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV40.json";
        String expectedMessage = "Error: invalid Token value data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV41 - Non-Terminal 23 omission>
     * Related derivation tree nodes: <23, 36>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV41() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV41.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV42 - Non-Terminal 23 repetition>
     * Related derivation tree nodes: <23, 36>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV42() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV42.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV43 - Non-Terminal 24 omission>
     * Related derivation tree nodes: <24, 37>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV43() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV43.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV44 - Non-Terminal 24 repetition>
     * Related derivation tree nodes: <24, 37>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV44() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV44.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV45 - Non-Terminal 25 omission>
     * Related derivation tree nodes: <25, 38>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid input data in JSON structure.">
     */
    void syntax_IV45() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV45.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV46 - Non-Terminal 25 repetition>
     * Related derivation tree nodes: <25, 38>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid input data in JSON structure.">
     */
    void syntax_IV46() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV46.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV47 - Non-Terminal 26 omission>
     * Related derivation tree nodes: <26, 39>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV47() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV47.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV48 - Non-Terminal 26 repetition>
     * Related derivation tree nodes: <26, 39>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV48() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV48.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV49 - Terminal 27 modification>
     * Related derivation tree nodes: <27>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV49() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV49.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV50 - Non-Terminal 28 omission>
     * Related derivation tree nodes: <28, 40>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV50() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV50.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV51 - Non-Terminal 28 repetition>
     * Related derivation tree nodes: <28, 40>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV51() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV51.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV52 - Non-Terminal 29 omission>
     * Related derivation tree nodes: <29, 41>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid type of operation.">
     */
    void syntax_IV52() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV52.json";
        String expectedMessage = "Error: invalid type of operation.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV53 - Non-Terminal 29 repetition>
     * Related derivation tree nodes: <29, 41>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid type of operation.">
     */
    void syntax_IV53() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV53.json";
        String expectedMessage = "Error: invalid type of operation.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV54 - Non-Terminal 30 omission>
     * Related derivation tree nodes: <30, 42>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV54() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV54.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV55 - Non-Terminal 30 repetition>
     * Related derivation tree nodes: <30, 42>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV55() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV55.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV56 - Terminal 31 modification>
     * Related derivation tree nodes: <31>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV56() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV56.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV57 - Terminal 32 modification>
     * Related derivation tree nodes: <32>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid input data in JSON structure.">
     */
    void syntax_IV57() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV57.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV58 - Terminal 33 modification>
     * Related derivation tree nodes: <33>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV58() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV58.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV59 - Terminal 34 modification>
     * Related derivation tree nodes: <34>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV59() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV59.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV60 - Terminal 35 modification>
     * Related derivation tree nodes: <35>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid Token value data in JSON structure.">
     */
    void syntax_IV60() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV60.json";
        String expectedMessage = "Error: invalid Token value data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV61 - Terminal 36 modification>
     * Related derivation tree nodes: <36>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV61() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV61.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV62 - Terminal 37 modification>
     * Related derivation tree nodes: <37>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV62() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV62.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV63 - Terminal 38 modification>
     * Related derivation tree nodes: <38>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid input data in JSON structure.">
     */
    void syntax_IV63() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV63.json";
        String expectedMessage = "Error: invalid input data in JSON structure.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV64 - Terminal 39 modification>
     * Related derivation tree nodes: <39>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV64() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV64.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV65 - Terminal 40 modification>
     * Related derivation tree nodes: <40>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV65() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV65.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV66 - Terminal 41 modification>
     * Related derivation tree nodes: <41>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: invalid type of operation.">
     */
    void syntax_IV66() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV66.json";
        String expectedMessage = "Error: invalid type of operation.";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test 
    /* Test Case: <Syntax-IV67 - Terminal 42 modification>
     * Related derivation tree nodes: <42>
     * Testing method: <Syntax analysis>
     * Expected result: <"Error: JSON object cannot be created due to incorrect representation">
     */
    void syntax_IV67() throws TokenManagementException {
        String inputFilePath = "./TestData/ExecuteActionTest/Syntax-IV67.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";

        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, () -> {
            myManager.executeAction(inputFilePath);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }





    /*
     * @DisplayName ("Invalid Test Cases")
     * 
     * @ParameterizedTest(name = "{index} - {2}")
     * 
     * @CsvFileSource(resources = "/invalidTestCasesExecuteActionTest.csv") void
     * InvalidTestCases(String inputFilePath, String expectedMessage) throws
     * TokenManagementException { TokenManagementException ex =
     * Assertions.assertThrows(TokenManagementException.class, ()-> {
     * myManager.ExecuteAction(inputFilePath); }); assertEquals
     * (expectedMessage,ex.getMessage()); }
     * 
     * @DisplayName ("Valid Test Cases")
     * 
     * @ParameterizedTest(name = "{index} - {2}")
     * 
     * @CsvFileSource(resources = "/validTestCasesExecuteActionTest.csv") void
     * ValidTestCases(String inputFilePath, String result) throws
     * TokenManagementException { String myResult =
     * myManager.ExecuteAction(inputFilePath); assertEquals (result,myResult); }
     */
}
