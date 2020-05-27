package Transport4Future.TokenManagement.Store;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Transport4Future.TokenManagement.Data.TokenRequest;
import Transport4Future.TokenManagement.Exceptions.TokenManagementException;

public class TokensRequestStore {
    private static final String STOREPATH = System.getProperty("user.dir") + "/Store/tokenRequestsStore.json";

    private static TokensRequestStore store;

    private TokensRequestStore() {

    }
    
    /**
     * TokensStoreManager instantiation for Singleton implementation
     *
     * 
     */
    public static TokensRequestStore getInstance() {
        if (store == null) {
            store = new TokensRequestStore();
        }
        /*
         * else { System.out.println("There a Token Store object already created"); }
         */
        return store;
    }

    @Override
    public TokensRequestStore clone() {
        try {
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException ex) {
//			System.out.println("Token Store Object cannot be cloned");
        }
        return null;
    }

    /**
     * saves token request
     * @throws TokenManagementException 
     *
     * 
     */
    public void saveTokenRequest(TokenRequest req, String hex) throws TokenManagementException {
        HashMap<String, TokenRequest> clonedMap = this.loadTokenRequestsRepository();
        // Guardar el Tokens Requests Store actualizado
        if (clonedMap == null) {
            clonedMap = new HashMap<String, TokenRequest>();
            clonedMap.put(hex, req);
        } else if (!clonedMap.containsKey(hex)) {
            clonedMap.put(hex, req);
        }
        saveStore(clonedMap);
    }

    private void saveStore(HashMap<String, TokenRequest> clonedMap) throws TokenManagementException {
        Gson gson = new Gson();
        String jsonString = gson.toJson(clonedMap);
        FileWriter fileWriter;
        String storePath = STOREPATH;
        try {
            fileWriter = new FileWriter(storePath);
            fileWriter.write(jsonString);
            fileWriter.close();
        } catch (IOException e) {
            throw new TokenManagementException("Error: Unable to save a new token in the internal licenses store");
        }
    }
    
    /**
     * Find a token request
     *
     * @throws TokenManagementException if any error occurs
     */
    public boolean find(String device) throws TokenManagementException {
        TokensRequestStore requestStore = new TokensRequestStore();
        HashMap<String, TokenRequest> clonedMap = requestStore.loadTokenRequestsRepository();
        if (clonedMap == null) {
            return false;
        } else if (!clonedMap.containsKey(device)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Get a token request
     *
     * @throws TokenManagementException if any error occurs
     */
    public TokenRequest getRequest(String device) throws TokenManagementException {
        TokensRequestStore requestStore = new TokensRequestStore();
        HashMap<String, TokenRequest> clonedMap = requestStore.loadTokenRequestsRepository();
        return clonedMap.get(device);
    }

    private HashMap<String, TokenRequest> loadTokenRequestsRepository() {
        // Generar un HashMap para guardar los objetos
        // Tengo que cargar el almacen de tokens request en memoria y añadir el nuevo si
        // no existe
        HashMap<String, TokenRequest> clonedMap = null;
        try {
            Gson gson = new Gson();
            String jsonString;
            String storePath = STOREPATH;

            Object object = gson.fromJson(new FileReader(storePath), Object.class);
            jsonString = gson.toJson(object);
            Type type = new TypeToken<HashMap<String, TokenRequest>>() {
            }.getType();
            clonedMap = gson.fromJson(jsonString, type);
        } catch (Exception e) {
            clonedMap = null;
        }
        return clonedMap;
    }

}
