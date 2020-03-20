package Transport4Future.TokenManagement;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class TokensStore {
	
	private List<Token> tokensList;
	
	private void Load() {
		try {
			JsonReader reader = new JsonReader(new FileReader(System.getProperty("user.dir")+"/Store/tokenStore.json"));
			Gson gson = new Gson();
			Token [] myArray = gson.fromJson(reader, Token[].class);
			this.tokensList = new ArrayList<Token>();
			for (Token token: myArray) {
				this.tokensList.add(token);
			}
		} catch (Exception e) {
			this.tokensList = new ArrayList<Token>();
		}
	}
	
	public void Add(Token newToken) throws TokenManagementException {
		this.Load();
		if (Find(newToken.toString())==null) {
			tokensList.add(newToken);
			this.Save();
		}
	}
	
	private void Save() throws TokenManagementException {
		Gson gson = new Gson();
		String jsonString = gson.toJson(this.tokensList);
		FileWriter fw;
		try {
			fw = new FileWriter(System.getProperty("user.dir")+"/Store/tokenStore.json");
			fw.write(jsonString);
			fw.close();
		} catch (IOException e) {
			throw new TokenManagementException("Error: Unable to save a new token in the internal licenses store");
		}
	}
	
	public Token Find(String tokenToFind) {
		Token result = null;
		this.Load();
		for (Token token: this.tokensList) {
			if (token.toString().equals(tokenToFind)) {
				result = token;
			}
		}
		return result;
	}
	
}
