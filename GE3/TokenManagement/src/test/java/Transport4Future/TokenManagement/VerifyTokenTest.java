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
		TokensStore ts = new TokensStore();
		TokenManager tm = new TokenManager();
		
		try {
			boolean result = tm.VerifyToken("N2IyNGI3YmNjNGM0OGE5ZmUxNDNmYTkwNmYzNDU0N2NjNzI0MTIzZjBjZGIyMjUxMTQ0NjEwNjM5YmEwNGI3MQ==");
			Assertions.assertTrue(result);
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.fail("An exception was not expected.");
		}
		
	}
	
	
	/* Test case: Token is not found
	* Testing technique: Structural analysis - Basic paths 
	* Expected value: Error message indicating the token couldnt be processed
	*/
	public void CP_RF3_01() throws TokenManagementException
	{
		TokenManager tm = new TokenManager();
		try {
			boolean verified = tm.VerifyToken("X2IyNGI3YmNjNGM0OGE5ZmUxNDNmYTkwNmYzNDU0N2NjNzI0MTIzZjBjZGIyMjUxMTQ0NjEwNjM5YmEwNGI3MQ==");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: token to be verified is not registered.", e.message);
		}
	}
	
	/* Test case: Token is found, expiration date < current time, issued at < current time
	* Testing technique: Structural analysis - Basic paths
	* Expected value: return false
	*/
	public void CP_RF3_02() throws TokenManagementException
	{
		TokenManager tm = new TokenManager();
		boolean verified = tm.VerifyToken();
		Assertions.assertFalse(verified);
	}
	
	
	/* Test case: Token is found, expiration date < current time, issued at > current time
	* Testing technique: Structural analysis - Basic paths
	* Expected value: return false
	*/
	public void CP_RF3_03() throws TokenManagementException
	{
		TokenManager tm = new TokenManager();
		String t = tm.RequestToken(InputFile);
		boolean verified = tm.VerifyToken(t);
		Assertions.assertFalse(verified);
	}
	
	/* Test case: Token is found, expiration date > current time, issued at < current time
	* Testing technique: Structural analysis - Basic paths
	* Expected value: return true
	*/
	public void CP_RF3_04() throws TokenManagementException
	{
		TokenManager tm = new TokenManager();
		String t = tm.RequestToken(InputFile);
		boolean verified = tm.VerifyToken(t);
		Assertions.assertTrue(verified);
	}
	
	/* Test case: Token is found, expiration date > current time, issued at > current time
	* Testing technique: Structural analysis - Basic paths
	* Expected value: return false
	*/
	public void CP_RF3_05() throws TokenManagementException
	{
		TokenManager tm = new TokenManager();
		String t = tm.RequestToken(InputFile);
		boolean verified = tm.VerifyToken(t);
		Assertions.assertFalse(verified);
	}
	
	
	/* Test case: Find method loop (skip loop), token store is empty
	* Testing technique: Structural analysis - Loop tests
	* Expected value: token is not found, so return null
	*/
	public void CP_RF3_06() throws TokenManagementException
	{
		TokensStore ts = new TokensStore();
		Token t = ts.Find(tokenToFind);
		Assertions.assertNull(t);
	}
	
	
	
	/* Test case: Find() method loop (loop once), search for the first token in the token store
	* Testing technique: Structural analysis - Loop tests
	* Expected value: return first token in token store
	*/
	public void CP_RF3_07() throws TokenManagementException
	{
		TokensStore ts = new TokensStore();
		Token t = ts.Find(tokenToFind);
		Assertions.assertEquals(tokenToFind, t.getSignature());
	}
	
	
	
	/* Test case: Find() method loop (loop twice), search for the first token in the token store
	* Testing technique: Structural analysis - Loop tests
	* Expected value: return second token in token store
	*/
	public void CP_RF3_08() throws TokenManagementException
	{
		TokensStore ts = new TokensStore();
		Token t = ts.Find(tokenToFind);
		Assertions.assertEquals(tokenToFind, t.getSignature());
	}
	
	
	/* Test case: Find() method loop (loop to last element), search for the last token in the token store
	* Testing technique: Structural analysis - Loop tests
	* Expected value: return last token in token store
	*/
	public void CP_RF3_09() throws TokenManagementException
	{
		TokensStore ts = new TokensStore();
		Token t = ts.Find(tokenToFind);
		Assertions.assertEquals(tokenToFind, t.getSignature());
	}
	
	/* Test case: Find() method loop (loop through every element), search for a token not found in the token store
	* Testing technique: Structural analysis - Loop tests
	* Expected value: return null
	*/
	public void CP_RF3_10() throws TokenManagementException
	{
		TokensStore ts = new TokensStore();
		Token t = ts.Find(tokenToFind);
		Assertions.assertNull(t);
	}
}
