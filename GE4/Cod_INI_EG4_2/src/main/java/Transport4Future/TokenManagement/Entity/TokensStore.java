package Transport4Future.TokenManagement.Entity;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import Transport4Future.TokenManagement.Entity.Token;
import Transport4Future.TokenManagement.Utils.TokenManagementException;

public class TokensStore {
    private static TokensStore ts=null;
    
    private List<Token> tokensList=null;
    
    private TokensStore() {

    }
    
    /**
     * TokensStoreManager instantiation for Singleton implementation
     *
     * 
     */
    public static TokensStore getInstance() {
        if (ts == null) {
            ts = new TokensStore();
        }
        else {
            System.out.println("Cannot create object tokensStore because an object of class TokensStore already exists");
        }
        return ts;
    }
    
    @Override
    public TokensStore clone() {
        try {
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException ex) {
            System.out.println("You cannot clone objects of this class.");
        }
        return null;
    }
    
    //public String getStorePath() {
    //    return storePath;
    //}
    
    private void load() {
        try {
            JsonReader reader = new JsonReader(new FileReader(System.getProperty("user.dir") + "/Store/tokenStore.json"));
            Gson gson = new Gson();
            Token [] myArray = gson.fromJson(reader, Token[].class);
            this.tokensList = new ArrayList<Token>();
            for (Token token: myArray) {
                this.tokensList.add(token);
            }
        }
        catch (Exception ex) {		
            this.tokensList = new ArrayList<Token>();
        }	
    }

    /**
     * Add new token to Token Store
     *
     * @throws TokenManagementException if any error occurs
     */
    public void add(Token newToken) throws TokenManagementException {
        this.load();
        if (find(newToken.getTokenValue())==null) {
            tokensList.add(newToken);
            this.save();
        }
    }

    private void save() throws TokenManagementException {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String jsonString = gson.toJson(this.tokensList);
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(System.getProperty("user.dir") + "/Store/tokenStore.json");
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
    public Token find(String tokenToFind) {
        Token result = null;
        this.load();
        for (Token token : this.tokensList) {
            if (token.getTokenValue().equals(tokenToFind)) {
                result = token;
            }
        }
        return result;
    }

}
