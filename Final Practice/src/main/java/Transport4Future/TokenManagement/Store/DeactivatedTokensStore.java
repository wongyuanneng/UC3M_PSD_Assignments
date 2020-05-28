package Transport4Future.TokenManagement.Store;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import Transport4Future.TokenManagement.Data.DeactivatedToken;
import Transport4Future.TokenManagement.Exceptions.TokenManagementException;

public class DeactivatedTokensStore {
    private static DeactivatedTokensStore store;
    private List<DeactivatedToken> revokedTokensList;


    private DeactivatedTokensStore() {
        this.load();
    }

    /**
     * TokensStoreManager instantiation for Singleton implementation
     *
     * 
     */
    public static DeactivatedTokensStore getInstance() {
        if (store == null) {
            store = new DeactivatedTokensStore();
        } else {
            //			System.out.println("There a Token Store object already created");
        }
        return store;
    }

    @Override
    public DeactivatedTokensStore clone() {
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
                    new FileReader(System.getProperty("user.dir") + "/Store/deactivatedTokenStore.json"));
            Gson gson = new Gson();
            DeactivatedToken[] myArray = gson.fromJson(reader, DeactivatedToken[].class);
            this.revokedTokensList = new ArrayList<DeactivatedToken>();
            for (DeactivatedToken token : myArray) {
                this.revokedTokensList.add(token);
            }
        } catch (Exception ex) {
            this.revokedTokensList = new ArrayList<DeactivatedToken>();
        }
    }

    /**
     * Add new deactivated token to Token Store
     *
     * @throws TokenManagementException if any error occurs
     */
    public void add(DeactivatedToken newToken) throws TokenManagementException {
        if (find(newToken.getRevokedToken().getHeader() + newToken.getRevokedToken().getPayload() + newToken.getRevokedToken().getSignature()) == null) {
            revokedTokensList.add(newToken);
            this.save();
        }
    }

    private void save() throws TokenManagementException {
        Gson gson = new Gson();
        String jsonString = gson.toJson(this.revokedTokensList);
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(System.getProperty("user.dir") + "/Store/deactivatedTokenStore.json");
            fileWriter.write(jsonString);
            fileWriter.close();
        } catch (IOException e) {
            throw new TokenManagementException("Error: Unable to save a new token in the internal deactivated licenses store");
        }
    }

    /**
     * Find a token request
     *
     * @throws TokenManagementException if any error occurs
     */
    public DeactivatedToken find(String tokenToFind) {
        DeactivatedToken result = null;
        for (DeactivatedToken token : this.revokedTokensList) {
            if (tokenToFind.equals(token.getRevokedToken().getHeader() + token.getRevokedToken().getPayload() + token.getRevokedToken().getSignature())) {
                return token;
            }
        }
        return result;
    }
}
