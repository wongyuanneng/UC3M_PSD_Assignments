package Transport4Future.TokenManagement.Store;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import Transport4Future.TokenManagement.Data.Token;
import Transport4Future.TokenManagement.Exceptions.TokenManagementException;

public class TokensStore {
    private static TokensStore store;
    private List<Token> tokensList;
    

    private TokensStore() {
        this.load();
    }
    
    /**
     * TokensStoreManager instantiation for Singleton implementation
     *
     * 
     */
    public static TokensStore getInstance() {
        if (store == null) {
            store = new TokensStore();
        } else {
//			System.out.println("There a Token Store object already created");
        }
        return store;
    }

    @Override
    public TokensStore clone() {
        try {
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException ex) {
//			System.out.println("Token Store Object cannot be cloned");
        }
        return null;
    }

    private void load() {
        try {
            JsonReader reader = new JsonReader(
                    new FileReader(System.getProperty("user.dir") + "/Store/tokenStore.json"));
            Gson gson = new Gson();
            Token[] myArray = gson.fromJson(reader, Token[].class);
            this.tokensList = new ArrayList<Token>();
            for (Token token : myArray) {
                this.tokensList.add(token);
            }
        } catch (Exception ex) {
            this.tokensList = new ArrayList<Token>();
        }
    }
    
    /**
     * Add new token to Token Store
     *
     * @throws TokenManagementException if any error occurs
     */
    public void add(Token newToken) throws TokenManagementException {
        if (find(newToken.getHeader() + newToken.getPayload() + newToken.getSignature()) == null) {
            tokensList.add(newToken);
            this.save();
        }
    }
    
    /**
     * Removes a token from Token Store
     *
     * @throws TokenManagementException if any error occurs
     */
    public void remove(Token token) throws TokenManagementException {
        if (find(token.getHeader() + token.getPayload() + token.getSignature()) != null) {
            tokensList.remove(token);
            this.save();
        }
    }
    

    private void save() throws TokenManagementException {
        Gson gson = new Gson();
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
        for (Token token : this.tokensList) {
            if (tokenToFind.equals(token.getHeader() + token.getPayload() + token.getSignature())) {
                return token;
            }
        }
        return result;
    }
}
