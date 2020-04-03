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
	
	
	
	
}
