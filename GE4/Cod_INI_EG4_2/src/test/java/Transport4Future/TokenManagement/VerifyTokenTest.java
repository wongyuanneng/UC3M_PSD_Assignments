package Transport4Future.TokenManagement;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Transport4Future.TokenManagement.Control.TokenManager;
import Transport4Future.TokenManagement.Utils.TokenManagementException;

class VerifyTokenTest {
    private TokenManager tokenManager;

    public VerifyTokenTest () {
        tokenManager = TokenManager.getInstance();
    }

    private void resetTokenStore () throws TokenManagementException {
        String storePath = System.getProperty("user.dir") + "/Store/tokenStore.json";
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(storePath);
            fileWriter.close();
        } catch (IOException e) {
            throw new TokenManagementException("Error: Unable to save a new token in the internal licenses store");
        }		
    }

    private void insertFirstToken () throws TokenManagementException {
        this.resetTokenStore();
        String inputFile = System.getProperty("user.dir") + "/TestData/TokenRequestTest/CorrectTokenRequest.json";
        tokenManager.requestToken(inputFile);
    }

    private void insertSecondToken () throws TokenManagementException {
        String inputFile = System.getProperty("user.dir") + "/TestData/TokenRequestTest/SecondCorrectTokenRequest.json";
        tokenManager.requestToken(inputFile);		
    }

    @Test
    @DisplayName("RF03 - TC01 - Buscar un token en un almacén de tokens vacío")
    void verifyTokenEmptyTokenStore() throws TokenManagementException {
        this.resetTokenStore();
        String tokenToVerify = "ABxnPUhTMjU2XG4gVHlwPVBEU1xuRGV2PTI3OGU3ZTI3NzMyYzRlNTM5NDZjZjIwMDU4YWQ4MTM4XG4gaWF0PTE4LTAzLTIwMjAgMTA6MjI6MjBcbiBleHA9MjUtMDMtMjAyMCAxMDoyMjoyMGIzYWMwYjRkNjQyOTE1OGRhMTI4NzYxZTk4Y2U4MzE3ZmE5MjhkNDJjNzEwYTlkMDZmNjRjOTY2N2JkZDM3MWM=\"";
        boolean result = tokenManager.verifyToken(tokenToVerify);
        assertEquals (false,result);
    }

    @Test
    @DisplayName("RF03 - TC02 - Buscar un token que no existe en un almacén de registros que contiene un elemento")
    void verifyTokenNonExistingToken() throws TokenManagementException {
        this.insertFirstToken();
        String tokenToVerify = "ABxnPUhTMjU2XG4gVHlwPVBEU1xuRGV2PTI3OGU3ZTI3NzMyYzRlNTM5NDZjZjIwMDU4YWQ4MTM4XG4gaWF0PTE4LTAzLTIwMjAgMTA6MjI6MjBcbiBleHA9MjUtMDMtMjAyMCAxMDoyMjoyMGIzYWMwYjRkNjQyOTE1OGRhMTI4NzYxZTk4Y2U4MzE3ZmE5MjhkNDJjNzEwYTlkMDZmNjRjOTY2N2JkZDM3MWM=\"";
        boolean result = tokenManager.verifyToken(tokenToVerify);
        assertEquals (false,result);
    }

    @Test
    @DisplayName("RF03 - TC03 - Buscar un token que existe en almacén con registros")
    void verifyTokenCorrectTest() throws TokenManagementException {
        this.insertFirstToken();
        String tokenToVerify = "QWxnPUhTMjU2XG4gVHlwPVBEU1xuRGV2PTI3OGU3ZTI3NzMyYzRlNTM5NDZjZjIwMDU4YWQ4MTM4XG4gaWF0PTE4LTAzLTIwMjAgMTA6MjI6MjBcbiBleHA9MjUtMDMtMjAyMCAxMDoyMjoyMGIzYWMwYjRkNjQyOTE1OGRhMTI4NzYxZTk4Y2U4MzE3ZmE5MjhkNDJjNzEwYTlkMDZmNjRjOTY2N2JkZDM3MWM=\"";
        boolean result = tokenManager.verifyToken(tokenToVerify);
        assertEquals (false,result);
    }

    @Test
    @DisplayName("RF03 - TC04 - Buscar un token cuando el almacén no existe")
    void verifyTokenNonExitingTokenStore() throws TokenManagementException {
        String storePath = System.getProperty("user.dir") + "/Store/tokenStore.json";
        File file = new File(storePath);
        file.delete();
        String tokenToVerify = "ABxnPUhTMjU2XG4gVHlwPVBEU1xuRGV2PTI3OGU3ZTI3NzMyYzRlNTM5NDZjZjIwMDU4YWQ4MTM4XG4gaWF0PTE4LTAzLTIwMjAgMTA6MjI6MjBcbiBleHA9MjUtMDMtMjAyMCAxMDoyMjoyMGIzYWMwYjRkNjQyOTE1OGRhMTI4NzYxZTk4Y2U4MzE3ZmE5MjhkNDJjNzEwYTlkMDZmNjRjOTY2N2JkZDM3MWM=";
        boolean result = tokenManager.verifyToken(tokenToVerify);
        assertEquals (false,result);
    }

    @Test
    @DisplayName("RF03 - TC05 - Buscar un token válido")
    void verifyValidToken() throws TokenManagementException {
        this.insertFirstToken();
        this.insertSecondToken();
        String tokenToVerify = "QWxnPUhTMjU2XG4gVHlwPVBEU1xuRGV2PTU3NjU5YmIwOTc4ZDQxMGIzYjc4YTg5MmM2MDRjY2I0XG4gaWF0PTE4LTAzLTIwMjAgMTc6MjI6MjBcbiBleHA9MTYtMDItMjAyMiAxNzoyMjoyMDdlNjY3Mzg2ZDNlNWMzOGIyZDY3NTNlYWI3MDM2ZTBlYmE1ZGViMTExNTQzMWM4Y2MyZjdmYmE3MTFkOTk3MjA=";
        boolean result = tokenManager.verifyToken(tokenToVerify);
        assertEquals (true,result);
    }
}
