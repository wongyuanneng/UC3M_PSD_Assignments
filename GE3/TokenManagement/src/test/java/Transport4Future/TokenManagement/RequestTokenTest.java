package Transport4Future.TokenManagement;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RequestTokenTest {
	private TokenManager myMgr;
	private String jsonFilesFolder;
	
	public RequestTokenTest() {
		jsonFilesFolder = System.getProperty("user.dir") + "/JSONFiles/RequestToken/";
		myMgr = new TokenManager();
	}
	
	@DisplayName("Correct Token Request")
	@Test
	void CorrectRequestTokenTest() throws TokenManagementException {
		String FilePath = this.jsonFilesFolder + "Correct.json";
		String expectedToken = "??";
		String obtainedToken = myMgr.RequestToken(FilePath);
		assertEquals (expectedToken, obtainedToken);
	}
}
