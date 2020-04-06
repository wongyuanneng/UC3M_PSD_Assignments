package Transport4Future.TokenManagement;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyTokenTest {
	@Test
	/* Test case: CP_RF1_01
	* Equivalence class or boundary value considered: <CE-RF1-V-01>
	* Testing technique: Equivalence Class
	* Expected value: Pass 
	*/
	public void TM_RF_03_I1()
	{
		String filePath = "resources/Func1/CP-RF1-01.json";
		TokenManager tm = new TokenManager();
		Assertions.assertThrows(TokenManagementException.class, ()-> tm.readTokenRequestFromJSON(filePath));
		assertNotNull(filePath);
	}
	
	
	/* Test case: Token is not found
	* Testing technique: Structural analysis - <Basic paths – Loop tests>
	* Expected value: Error message indicating the token couldnt be processed
	*/
	public void CP_RF2_01() throws TokenManagementException
	{
		TokenManager tm = new TokenManager();
		String t = tm.RequestToken(InputFile);
		try {
			boolean verified = tm.VerifyToken(t);
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: input string does not contain a token that can be processed.", e.message);
		}
	}
	
	/* Test case: Token is found, expiration date < current time
	* Testing technique: Structural analysis - <Basic paths – Loop tests>
	* Expected value: Error message indicating the token couldnt be processed
	*/
	public void CP_RF2_02() throws TokenManagementException
	{
		TokenManager tm = new TokenManager();
		String t = tm.RequestToken(InputFile);
		try {
			boolean verified = tm.VerifyToken(t);
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: input string does not contain a token that can be processed.", e.message);
		}
	}
}
