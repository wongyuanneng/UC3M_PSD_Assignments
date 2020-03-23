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
			Assertions.assertEquals(e.message, "Error: input data file not found.");
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
		String filePath = "src/resources/CP-RF1-TM-RF-01-I1.json";
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
	/* Test case: TM_RF_01_P1_01 - DONE
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: incorrect Device Name received
	*/
	public void TM_RF_01_P1_01()
	{
		String filePath = "src/resources/CP-RF1-TM-RF-01-P1-01.json";
		TokenManager tm = new TokenManager();
		try {
			TokenRequest req = tm.readTokenRequestFromJSON(filePath);
			tm.validateDeviceName(req);
			Assertions.fail("An invalid Device Name data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: invalid Device Name data in JSON structure.");
		}
	}
	
	@Test
	/* Test case: TM_RF_01_P1_02 - DONE
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: incorrect  Driver Version received
	*/
	public void TM_RF_01_P1_02()
	{
		String filePath = "src/resources/CP-RF1-TM-RF-01-P1-02.json";
		TokenManager tm = new TokenManager();
		try {
			TokenRequest req = tm.readTokenRequestFromJSON(filePath);
			tm.validateDriverVer(req);
			Assertions.fail("An invalid Driver Version data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: invalid Driver Version data in JSON structure.");
		}
	}
	
	@Test
	/* Test case: TM_RF_01_P1_03 - DONE
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: incorrect E-mail received
	*/
	public void TM_RF_01_P1_03()
	{
		String filePath = "src/resources/CP-RF1-TM-RF-01-P1-03.json";
		TokenManager tm = new TokenManager();
		try {
			TokenRequest req = tm.readTokenRequestFromJSON(filePath);
			tm.validateEmail(req);
			Assertions.fail("An invalid E-mail data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: invalid E-mail data in JSON structure.");
		}
	}
	
	@Test
	/* Test case: TM_RF_01_P1_04 - DONE
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: incorrect MAC Address received
	*/
	public void TM_RF_01_P1_04()
	{
		String filePath = "src/resources/CP-RF1-TM-RF-01-P1-04.json";
		TokenManager tm = new TokenManager();
		try {
			TokenRequest req = tm.readTokenRequestFromJSON(filePath);
			tm.validateMac(req);
			Assertions.fail("An invalid MAC Address data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: invalid MAC Address data in JSON structure.");
		}
	}
	
	@Test
	/* Test case: TM_RF_01_P1_05 - DONE
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: incorrect Serial Number received
	*/
	public void TM_RF_01_P1_05()
	{
		String filePath = "src/resources/CP-RF1-TM-RF-01-P1-05.json";
		TokenManager tm = new TokenManager();
		try {
			TokenRequest req = tm.readTokenRequestFromJSON(filePath);
			tm.validateSN(req);
			Assertions.fail("An invalid Serial Number data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: invalid Serial Number data in JSON structure.");
		}
	}
	
	@Test
	/* Test case: TM_RF_01_P1_06 - DONE
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: incorrect Device Type received
	*/
	public void TM_RF_01_P1_06()
	{
		String filePath = "src/resources/CP-RF1-TM-RF-01-P1-06.json";
		TokenManager tm = new TokenManager();
		try {
			TokenRequest req = tm.readTokenRequestFromJSON(filePath);
			tm.validateType(req);
			Assertions.fail("An invalid Device Type data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: invalid Device Type data in JSON structure.");
		}
	}
	
	@Test
	/* Test case: TM_RF_01_P2 - DONE
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: correct data received and the value generated is a String
	*/
	public void TM_RF_01_P2()
	{
		String filePath = "src/resources/CP-RF1-01.json";
		TokenManager tm = new TokenManager();
		try {
			TokenRequest req = tm.readTokenRequestFromJSON(filePath);
			tm.validateAll_01(req);
			if (!(tm.TokenRequestGeneration(filePath) instanceof String)) {
				Assertions.fail("A generated String value was expected.");
			}
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: invalid input data in JSON structure");
		}
	}
	
	@Test
	/* Test case: TM_RF_01_O1_01 - DONE
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: string value corresponding to the generated Token Request
	*/
	public void TM_RF_01_O1_01()
	{
		String filePath = "src/resources/CP-RF1-01.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.TokenRequestGeneration(filePath);
			tm.tokenRequestTester(res, "437af2f417fb67604686f7df3e9ca4bc");
			System.out.println(res);
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.fail("An exception was not expected.");
		}
	}
	
	@Test
	/* Test case: TM_RF_01_O1_02 - DONE
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: string value does no correspond to the generated Token Request
	*/
	public void TM_RF_01_O1_02()
	{
		String filePath = "src/resources/CP-RF1-01.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.TokenRequestGeneration(filePath);
			tm.tokenRequestTester(res, "437af2f417fb67604686f7df3e9ca4bd");
			
			Assertions.fail("A generated string value does not correspond to expected string value of the TokenRequest exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: generated string value does not correspond to expected string value of the TokenRequest.");
		}
	}
	
	@Test
	/* Test case: TM_RF_01_O2_01 - DONE
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: input data file not found
	*/
	public void TM_RF_01_O2_01()
	{
		String filePath = "src/resources/no_file_found.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.TokenRequestGeneration(filePath);
			Assertions.fail("An input data file not found exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: input data file not found.");
		}
	}
	
	@Test
	/* Test case: TM_RF_01_O2_02 - DONE
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: input file does not contain data or the data is not in the expected format
	*/
	public void TM_RF_01_O2_02()
	{
		String filePath = "src/resources/not_json_file.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.TokenRequestGeneration(filePath);
			Assertions.fail("An input file does not contain data or the data is not in the expected format exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: input file does not contain data or the data is not in the expected format.");
		}
	}
	
	@Test
	/* Test case: TM_RF_01_O2_03 ???
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: input file does not contain data or the data is not in the expected format
	*/
	public void TM_RF_01_O2_03()
	{
		String filePath = "src/resources/internal_processing_error.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.TokenRequestGeneration(filePath);
			Assertions.fail("An internal processing error when obtaining the Token Request exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: internal processing error when obtaining the Token Request.");
		}
	}
}
