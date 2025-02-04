package Transport4Future.TokenManagement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import Transport4Future.TokenManagement.Exceptions.TokenManagementException;

public class TokenRequestGenerationTest {
    private TokenManager myManager;

    public TokenRequestGenerationTest () {
        myManager = TokenManager.getInstance();
    }

    @DisplayName ("Invalid Test Cases")
    @ParameterizedTest(name = "{index} - {2}")
    @CsvFileSource(resources = "/invalidTestCasesRequestGenerationTest.csv")
    void invalidTestCases(String InputFilePath, String expectedMessage) {
        TokenManagementException ex = Assertions.assertThrows(TokenManagementException.class, ()-> {
            myManager.tokenRequestGeneration(InputFilePath);
        });
        assertEquals (expectedMessage,ex.getMessage());
    }

    @DisplayName ("Valid Test Cases")
    @ParameterizedTest(name = "{index} - {2}")
    @CsvFileSource(resources = "/validTestCasesRequestGenerationTest.csv")
    void validTestCases(String InputFilePath, String Result) throws TokenManagementException {
        String myResult = myManager.tokenRequestGeneration(InputFilePath);
        assertEquals (Result,myResult);
    }
}

