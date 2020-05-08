package Transport4Future.TokenManagement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import Transport4Future.TokenManagement.Control.TokenManager;
import Transport4Future.TokenManagement.Utils.TokenManagementException;

class TokenRequestTest {

    private TokenManager myManager;

    public TokenRequestTest () {
        myManager = TokenManager.getInstance();
    }

    @DisplayName ("Caso de prueba - Eliminación de Llave Inicial")
    @Test
    void inicio ()
    {
        String inputFilePath = "./TestData/TokenRequestTest/WithoutInitialBrace.json";
        String expectedMessage = "Error: JSON object cannot be created due to incorrect representation";
        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, ()-> {
            myManager.requestToken(inputFilePath);
        });
        assertEquals (expectedMessage,ex.getMessage());
    }

    @DisplayName ("Invalid Test Cases")
    @ParameterizedTest(name = "{index} -with the input ''{0}'' error expected is ''{1}''") 
    @CsvFileSource(resources = "/invalidTestCasesRequestTokenTestReduced.csv")
    void invalidTestCases(String InputFilePath, String expectedMessage) {
        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, ()-> {
            myManager.requestToken(InputFilePath);
        });
        assertEquals (expectedMessage,ex.getMessage());
    }

    @DisplayName ("Valid Test Cases")
    @ParameterizedTest(name = "{index} -with the input ''{0}'' output expected is ''{1}''")
    @CsvFileSource(resources = "/validTestCasesRequestTokenTest.csv")
    void validTestCases(String InputFilePath, String Result) throws TokenManagementException {
        String myResult = myManager.requestToken(InputFilePath);
        assertEquals (Result,myResult);
    }
}
