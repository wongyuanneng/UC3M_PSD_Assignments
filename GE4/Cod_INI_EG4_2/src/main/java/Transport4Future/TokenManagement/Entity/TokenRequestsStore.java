package Transport4Future.TokenManagement.Entity;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Transport4Future.TokenManagement.Entity.TokenRequest;
import Transport4Future.TokenManagement.Utils.MD5Hash;
import Transport4Future.TokenManagement.Utils.TokenManagementException;

public class TokenRequestsStore {
    private static TokenRequestsStore ts=null;
    
    private Gson gson = new Gson();
    private HashMap<String, TokenRequest> clonedMap=null;
    private String storePath = System.getProperty("user.dir") + "/Store/tokenRequestsStore.json";
    
    
    //private String storePath;
    
    private TokenRequestsStore() {
        
    }
    
    /**
     * TokensStoreManager instantiation for Singleton implementation
     *
     * 
     */
    public static TokenRequestsStore getInstance() {
        if (ts == null) {
            ts = new TokenRequestsStore();
        }
        else {
            System.out.println("Cannot create object tokensStore because an object of class TokenRequestsStore already exists");
        }
        return ts;
    }
    
    @Override
    public TokenRequestsStore clone() {
        try {
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException ex) {
            System.out.println("You cannot clone objects of this class.");
        }
        return null;
    }
    
    /**
     * Returns clonedMap or make a new one if null
     * @throws TokenManagementException 
     *
     * 
     */
    public HashMap<String, TokenRequest> getClonedMap() throws TokenManagementException {
        if (clonedMap!=null) {
            return clonedMap;
        }
        else {
            return makeClonedMap();
        }
    }

    public String getStorePath() {
        return storePath;
    }

    public void setStorePath(String storePath) {
        this.storePath = storePath;
    }

    /**
     * Hashes a new tokenRequest then adds it to the clonedMap and saves it to storePath
     * @throws TokenManagementException 
     *
     * 
     */
    public void add(TokenRequest tr) throws TokenManagementException {
        MD5Hash myHash = new MD5Hash("Stardust-");
        tr.setHex(myHash.hash(tr.toString()));

        //Tengo que cargar el almacen de tokens request en memoria y añadir el nuevo si no existe
        String jsonString = createJsonString(tr, tr.getHex());
        
        this.save(jsonString);
    }
    
    private void save(String jsonString) throws TokenManagementException {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(this.storePath);
            fileWriter.write(jsonString);
            fileWriter.close();
        } catch (IOException e) {
            throw new TokenManagementException("Error: Unable to save a new token in the internal licenses store");
        }
    }
    
    /**
     * Creates a json string.
     *
     * @throws TokenManagementException if any error occurs
     */
    private String createJsonString(TokenRequest tr, String hex) throws TokenManagementException {
        this.clonedMap = makeClonedMap();
        if (clonedMap==null) {
            clonedMap = new HashMap();
            clonedMap.put (hex, tr);               
        }
        else if (!clonedMap.containsKey(hex)){
            clonedMap.put (hex, tr);
        }
        return gson.toJson(clonedMap);
    }
    
    /**
     * Creates a cloned map from the token store.
     *
     * @throws TokenManagementException if any error occurs
     */
    public HashMap<String, TokenRequest> makeClonedMap() throws TokenManagementException {
        String jsonString;
        this.clonedMap=null;
        try {
            Object object = gson.fromJson(new FileReader(this.storePath), Object.class);
            jsonString = gson.toJson(object);
            Type type = new TypeToken<HashMap<String, TokenRequest>>(){}.getType();
            clonedMap = gson.fromJson(jsonString, type);
        } catch (Exception e) {
            clonedMap=null;
            System.out.println(e);
            throw new TokenManagementException("Error: unable to recover Token Requests Store.");
        }
        return clonedMap;
    }
    
    
}
