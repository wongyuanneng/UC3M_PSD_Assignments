package Transport4Future.TokenManagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyTokenTest {
	
	@Test
	/* Test case: Token is not found
	* Testing technique: Structural analysis - Basic paths 
	* Expected value: Error message indicating the token couldnt be processed
	*/
	public void CP_RF3_01(){
		TokenManager tm = new TokenManager();
		try {
			boolean verified = tm.VerifyToken("tokenNotFound==");
			Assertions.fail("A token to be verified is not registered exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: token to be verified is not registered.", e.message);
		}
	}
	
	@Test
	/* Test case: Token is found, expiration date < current time, issued at < current time
	* Testing technique: Structural analysis - Basic paths
	* Expected value: return false
	*/
	public void CP_RF3_02(){
		TokenManager tm = new TokenManager();
		boolean verified;
		try {
			verified = tm.VerifyToken("MzFkMzI1MTA3ZTY4NTQ4ODQwYTIwNWFhMzYyYjI2ZTc3NTMyNGI4YTAxMWQ4ZjJiYTM2ZTJlNTBlZDI5ZjlkZQ==");
			Assertions.assertFalse(verified);
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.fail("An exception was not expected.");
		}
		
	}
	
	@Test
	/* Test case: Token is found, expiration date < current time, issued at > current time
	* Testing technique: Structural analysis - Basic paths
	* Expected value: return false
	*/
	public void CP_RF3_03(){
		TokenManager tm = new TokenManager();
		boolean verified;
		try {
			verified = tm.VerifyToken("NWE5ZmE0ZjMzZWE2YWU4OTAwZjk2NjZlMjZmNzVmYmNhMDczOTczN2JmYjQwMzlmMGMxMmMyZWJiYmFlNjMwYg==");
			Assertions.assertFalse(verified);
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.fail("An exception was not expected.");
		}
		
	}
	
	@Test
	/* Test case: Token is found, expiration date > current time, issued at < current time
	* Testing technique: Structural analysis - Basic paths
	* Expected value: return true
	*/
	public void CP_RF3_04(){
		TokenManager tm = new TokenManager();
		boolean verified;
		try {
			verified = tm.VerifyToken("MjgyYjAxNzEzOThlM2E5MDQ3NjU0YTIyMjAxYzk0MjU3MzI2MTAzYTkwMjkyODRkZmY4NTM4OTRlYjA0OTE1OA==");
			Assertions.assertTrue(verified);
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.fail("An exception was not expected.");
		}
		
	}
	
	@Test
	/* Test case: Token is found, expiration date > current time, issued at > current time
	* Testing technique: Structural analysis - Basic paths
	* Expected value: return false
	*/
	public void CP_RF3_05(){
		TokenManager tm = new TokenManager();
		boolean verified;
		try {
			verified = tm.VerifyToken("NmM1OTkyYTJkNjAyN2JiNTk5MmMxZmZmYTEzZTFjMmNhODIxYjBiNGRhZjNhZTNjZGI1OTUyNGZlMTYwN2VlNw==");
			Assertions.assertFalse(verified);
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.fail("An exception was not expected.");
		}
	}
	
	@Test
	/* Test case: Find method loop (skip loop), token store is empty
	* Testing technique: Structural analysis - Loop tests
	* Expected value: token is not found, so return null
	*/
	public void CP_RF3_06(){
		TokensStore ts = new TokensStore("src/resources/Store/emptyTokenStore.json");
		String tokenToFind = "N2IyNGI3YmNjNGM0OGE5ZmUxNDNmYTkwNmYzNDU0N2NjNzI0MTIzZjBjZGIyMjUxMTQ0NjEwNjM5YmEwNGI3MQ=="; //first token
		Token t = ts.Find(tokenToFind);
		Assertions.assertNull(t);
	}
	
	
	
	/* Test case: Find() method loop (loop once), search for the first token in the token store
	* Testing technique: Structural analysis - Loop tests
	* Expected value: return first token in token store
	*/
	public void CP_RF3_07() throws TokenManagementException{
		TokensStore ts = new TokensStore();
		String tokenToFind = "N2IyNGI3YmNjNGM0OGE5ZmUxNDNmYTkwNmYzNDU0N2NjNzI0MTIzZjBjZGIyMjUxMTQ0NjEwNjM5YmEwNGI3MQ=="; //first token
		Token t = ts.Find(tokenToFind);
		Assertions.assertEquals(t, ts.getTokensList().get(0));
	}
	
	@Test
	/* Test case: Find() method loop (loop twice), search for the first token in the token store
	* Testing technique: Structural analysis - Loop tests
	* Expected value: return second token in token store
	*/
	public void CP_RF3_08() throws TokenManagementException{
		TokensStore ts = new TokensStore();
		String tokenToFind = "MjgyYjAxNzEzOThlM2E5MDQ3NjU0YTIyMjAxYzk0MjU3MzI2MTAzYTkwMjkyODRkZmY4NTM4OTRlYjA0OTE1OA=="; //second token
		Token t = ts.Find(tokenToFind);
		Assertions.assertEquals(t, ts.getTokensList().get(1));
	}
	
	@Test
	/* Test case: Find() method loop (loop twice), search for the first token in the token store
	* Testing technique: Structural analysis - Loop tests
	* Expected value: return second last token in token store
	*/
	public void CP_RF3_09() throws TokenManagementException{
		TokensStore ts = new TokensStore();
		String tokenToFind = "NWE5ZmE0ZjMzZWE2YWU4OTAwZjk2NjZlMjZmNzVmYmNhMDczOTczN2JmYjQwMzlmMGMxMmMyZWJiYmFlNjMwYg=="; //second last token
		Token t = ts.Find(tokenToFind);
		Assertions.assertEquals(t, ts.getTokensList().get(ts.getTokensList().size()-2));
	}
	
	@Test
	/* Test case: Find() method loop (loop to last element), search for the last token in the token store
	* Testing technique: Structural analysis - Loop tests
	* Expected value: return last token in token store
	*/
	public void CP_RF3_10() throws TokenManagementException{
		TokensStore ts = new TokensStore();
		String tokenToFind = "NmM1OTkyYTJkNjAyN2JiNTk5MmMxZmZmYTEzZTFjMmNhODIxYjBiNGRhZjNhZTNjZGI1OTUyNGZlMTYwN2VlNw=="; //last token
		Token t = ts.Find(tokenToFind);
		Assertions.assertEquals(t, ts.getTokensList().get(ts.getTokensList().size()-1));
	}
	
	@Test
	/* Test case: Find() method loop (loop through every element), search for a token not found in the token store
	* Testing technique: Structural analysis - Loop tests
	* Expected value: return null
	*/
	public void CP_RF3_11() throws TokenManagementException{
		TokensStore ts = new TokensStore();
		Token t = ts.Find("tokenNotFound==");
		Assertions.assertNull(t);
	}
}
