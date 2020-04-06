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
	private String fileDir;
	
	public TokensStore() {
		super();
		this.fileDir = "src/resources/Store/tokenStore.json";
	}
	
	public TokensStore(String fileDir) {
		super();
		this.fileDir = fileDir;
	}

	public List<Token> getTokensList() {
		return tokensList;
	}

	private void Load() {
		try {
			JsonReader reader = new JsonReader(new FileReader(this.fileDir));
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
		if (Find(newToken.getSignature())==null) {
			tokensList.add(newToken);
			this.Save();
		}
	}
	
	private void Save() throws TokenManagementException {
		Gson gson = new Gson();
		String jsonString = gson.toJson(this.tokensList);
		FileWriter fw;
		try {
			fw = new FileWriter(this.fileDir);
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
			if (token.getSignature().equals(tokenToFind)) {
				result = token;
			}
		}
		return result;
	}
	
}
