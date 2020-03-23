package Transport4Future.TokenManagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TokenTest {
	@Test
	/* Test case: TM_RF_01_I1 - DONE
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: invalid input data in JSON structure
	*/
	public void TM_RF_01_I1()
	{
		String filePath = "src/resources/Func2/CP-RF1-01.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.TokenRequestGeneration(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: invalid input data in JSON structure.");
		}
	}
}
