package Transport4Future.TokenManagement;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
	@Test
	/* Test case: CP_RF1_01
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: Pass 
	*/
	public void CP_RF1_01()
	{
		String filePath = "resources/CP-RF1-01.json";
		TokenManager tm = new TokenManager();
		Assertions.assertThrows(TokenManagementException.class, ()-> tm.readTokenRequestFromJSON(filePath));
		assertNotNull(filePath);
	}
	
	@Test
	/* Test case: CP_RF1_02
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: File not found
	*/
	public void CP_RF1_02()
	{
		String filePath = "src/resources/CP-RF1-01-no.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.TokenRequestGeneration(filePath);
			Assertions.fail("A file not found exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: input file not found.");
		}
		
	}
	
	@Test
	/* Test case: TM_RF_01_I1 - DONE
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: invalid input data in JSON structure
	*/
	public void TM_RF_01_I1()
	{
		String filePath = "src/resources/CP-RF1-02.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.TokenRequestGeneration(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: invalid input data in JSON structure.");
		}
	}
	
	@Test
	/* Test case: TM_RF_01_P1
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: incorrect data received
	*/
	public void TM_RF_01_P1()
	{
		String filePath = "resources/CP-RF1-01.json";
		TokenManager tm = new TokenManager();
		try {
			TokenRequest req = tm.readTokenRequestFromJSON(filePath);
			tm.validateAll(req);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: invalid input data in JSON structure.");
		}
	}
	
	@Test
	/* Test case: TM_RF_01_P2
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: correct data received
	*/
	public void TM_RF_01_P2()
	{
		String filePath = "resources/CP-RF1-01_P2.json";
		TokenManager tm = new TokenManager();
		try {
			TokenRequest req = tm.readTokenRequestFromJSON(filePath);
			tm.validateAll(req);
			String res = tm.TokenRequestGeneration(filePath);
			if (res.isEmpty())
				Assertions.fail("A generated String value was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "?");
		}
	}
	
	@Test
	/* Test case: TM_RF_01_O1
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: invalid input data in JSON structure
	*/
	public void TM_RF_01_O1()
	{
		String filePath = "resources/CP-RF1-01.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.TokenRequestGeneration(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: invalid input data in JSON structure.");
		}
	}
	
	@Test
	/* Test case: TM_RF_01_O2
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: invalid input data in JSON structure
	*/
	public void TM_RF_01_O2()
	{
		String filePath = "resources/CP-RF1-1.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.TokenRequestGeneration(filePath);
			Assertions.fail("An exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
}
