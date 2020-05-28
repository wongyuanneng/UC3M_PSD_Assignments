package Transport4Future.TokenManagement;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import Transport4Future.TokenManagement.StoreForTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Transport4Future.TokenManagement.Exceptions.TokenManagementException;

class VerifyTokenTest {
    private TokenManager myManager;
    private StoreForTests storeTokens;

    public VerifyTokenTest () throws TokenManagementException{
        myManager = TokenManager.getInstance();
        storeTokens = new StoreForTests();
    }

    @Test
    @DisplayName("RF03 - TC01 - Buscar un token en un almacén de tokens vacío")
    void verifyTokenEmptyTokenStore() throws TokenManagementException {
    	storeTokens.resetTokenStore();
        String tokenToVerify = "ABxnPUhTMjU2XG4gVHlwPVBEU1xuRGV2PTI3OGU3ZTI3NzMyYzRlNTM5NDZjZjIwMDU4YWQ4MTM4XG4gaWF0PTE4LTAzLTIwMjAgMTA6MjI6MjBcbiBleHA9MjUtMDMtMjAyMCAxMDoyMjoyMGIzYWMwYjRkNjQyOTE1OGRhMTI4NzYxZTk4Y2U4MzE3ZmE5MjhkNDJjNzEwYTlkMDZmNjRjOTY2N2JkZDM3MWM=";
        boolean result = myManager.verifyToken(tokenToVerify);
        assertEquals (false,result);
    }

    @Test
    @DisplayName("RF03 - TC02 - Buscar un token que no existe en un almacén de registros que contiene un elemento")
    void verifyTokenNonExistingToken() throws TokenManagementException {
    	storeTokens.insertFirstToken();
        String tokenToVerify = "ABxnPUhTMjU2XG4gVHlwPVBEU1xuRGV2PTI3OGU3ZTI3NzMyYzRlNTM5NDZjZjIwMDU4YWQ4MTM4XG4gaWF0PTE4LTAzLTIwMjAgMTA6MjI6MjBcbiBleHA9MjUtMDMtMjAyMCAxMDoyMjoyMGIzYWMwYjRkNjQyOTE1OGRhMTI4NzYxZTk4Y2U4MzE3ZmE5MjhkNDJjNzEwYTlkMDZmNjRjOTY2N2JkZDM3MWM=";
        boolean result = myManager.verifyToken(tokenToVerify);
        assertEquals (false,result);
    }

    @Test
    @DisplayName("RF03 - TC03 - Buscar un token que existe en almacén con registros")
    void verifyTokenCorrectTest() throws TokenManagementException {
    	storeTokens.insertFirstToken();
        String tokenToVerify = "QWxnPUhTMjU2XG4gVHlwPVBEU1xuRGV2PTI3OGU3ZTI3NzMyYzRlNTM5NDZjZjIwMDU4YWQ4MTM4XG4gaWF0PTE4LTAzLTIwMjAgMTA6MjI6MjBcbiBleHA9MjUtMDMtMjAyMCAxMDoyMjoyMGIzYWMwYjRkNjQyOTE1OGRhMTI4NzYxZTk4Y2U4MzE3ZmE5MjhkNDJjNzEwYTlkMDZmNjRjOTY2N2JkZDM3MWM=";
        boolean result = myManager.verifyToken(tokenToVerify);
        assertEquals (false,result);
    }

    @Test
    @DisplayName("RF03 - TC04 - Buscar un token cuando el almacén no existe")
    void verifyTokenNonExitingTokenStore() throws TokenManagementException {
        String storePath = System.getProperty("user.dir") + "/Store/tokenStore.json";
        File file = new File(storePath);
        file.delete();
        String tokenToVerify = "ABxnPUhTMjU2XG4gVHlwPVBEU1xuRGV2PTI3OGU3ZTI3NzMyYzRlNTM5NDZjZjIwMDU4YWQ4MTM4XG4gaWF0PTE4LTAzLTIwMjAgMTA6MjI6MjBcbiBleHA9MjUtMDMtMjAyMCAxMDoyMjoyMGIzYWMwYjRkNjQyOTE1OGRhMTI4NzYxZTk4Y2U4MzE3ZmE5MjhkNDJjNzEwYTlkMDZmNjRjOTY2N2JkZDM3MWM=";
        boolean result = myManager.verifyToken(tokenToVerify);
        assertEquals (false,result);
    }

    @Test
    @DisplayName("RF03 - TC05 - Buscar un token válido")
    void verifyValidToken() throws TokenManagementException {
    	storeTokens.insertFirstToken();
    	storeTokens.insertSecondToken();
        String tokenToVerify = "QWxnPUhTMjU2XG4gVHlwPVBEU1xuRGV2PWY0ZDNmYmY0NDc4ZjJmNTZjNmU2Yzk4M2ZkOTQwYjRjXG4gaWF0PTE4LTAzLTIwMjAgMTA6MjI6MjBcbiBleHA9MTYtMDQtMjAyMiAxODo1NTo0MGYxNjg2MjQ5MDdjYTM2ZTc2N2ZiYzFjM2NiMjM5ODNhNjdkMTlkNWRhMjVmYzJmZGUyOWJhNTlmNzE2MDdiYmM=";
        boolean result = myManager.verifyToken(tokenToVerify);
        assertEquals (true,result);
    }
}
