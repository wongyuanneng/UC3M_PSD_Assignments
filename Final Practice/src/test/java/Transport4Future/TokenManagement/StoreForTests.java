package Transport4Future.TokenManagement;

import java.io.FileWriter;
import java.io.IOException;

import Transport4Future.TokenManagement.Exceptions.TokenManagementException;

class StoreForTests {
    private TokenManager myManager;
    private String token1;
    private String token2;

    public StoreForTests () throws TokenManagementException{
        myManager = TokenManager.getInstance();
        this.resetTokenStore();
    }

    public void resetTokenStore () throws TokenManagementException {
        String storePath = System.getProperty("user.dir") + "/Store/tokenStore.json";
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(storePath);
            fileWriter.close();
        } catch (IOException e) {
            throw new TokenManagementException("Error: Unable to save a new token in the internal licenses store");
        }		
    }

    public void insertFirstToken () throws TokenManagementException {
        this.resetTokenStore();
        String inputFile = System.getProperty("user.dir") + "/TestData/TokenRequestTest/CorrectTokenRequest.json";
        this.token1 = myManager.requestToken(inputFile);
    }

    public void insertSecondToken () throws TokenManagementException {
        String inputFile = System.getProperty("user.dir") + "/TestData/TokenRequestTest/SecondCorrectTokenRequest.json";
        this.token2 = myManager.requestToken(inputFile);		
    }
    
    public String getFirstToken() {
    	return this.token1;
    }

    public String getSecondToken() {
    	return this.token2;
    }
}
