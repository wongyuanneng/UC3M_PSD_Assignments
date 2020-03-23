package Transport4Future.TokenManagement;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RequestTokenTest {
	private TokenManager myMgr;
	
	public RequestTokenTest() {
		myMgr = new TokenManager();
	}
	
	@DisplayName("Correct Token Request")
	@Test
	void CorrectRequestTokenTest() throws TokenManagementException {
		String FilePath = "src/resources/Func2/CP-RF1-01.json";
		String expectedToken = "N2VjYWE3YjJhMDg0NWMxZjk2YTk4ZGMxZTQwMDU2MDhjMjBhZjc1YjgyZjc3MDc1M2VmNDI2NGJjNDJmYzJiYw==";
		String obtainedToken = myMgr.RequestToken(FilePath);
		assertEquals (expectedToken, obtainedToken);
	}
	
	@Test
	/* Test case: TM_RF_02_I1 - DONE
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: invalid input data in JSON structure
	*/
	public void TM_RF_02_I1()
	{
		String filePath = "src/resources/Func2/CP-RF1-TM-RF-02-I1.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: invalid input data in JSON structure.");
		}
	}
	
	@Test
	/* Test case: TM_RF_02_P1_01 - DONE
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: incorrect Token Request String received
	*/
	public void TM_RF_02_P1_01()
	{
		String filePath = "src/resources/Func2/CP-RF1-TM-RF-02-P1-01.json";
		TokenManager tm = new TokenManager();
		try {
			Token t = tm.readTokenFromJSON(filePath);
			tm.validateTokenReq(t);
			Assertions.fail("An invalid Token Request String data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: invalid Token Request String data in JSON structure.");
		}
	}
	
	@Test
	/* Test case: TM_RF_02_P1_02 - DONE
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: incorrect E-mail received
	*/
	public void TM_RF_02_P1_02()
	{
		String filePath = "src/resources/Func2/CP-RF1-TM-RF-02-P1-02.json";
		TokenManager tm = new TokenManager();
		try {
			Token t = tm.readTokenFromJSON(filePath);
			tm.validateEmail(t);
			Assertions.fail("An invalid Notification E-mail data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: invalid Notification E-mail data in JSON structure.");
		}
	}
	
	@Test
	/* Test case: TM_RF_02_P1_03 - DONE
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: incorrect Requested Date received
	*/
	public void TM_RF_02_P1_03()
	{
		String filePath = "src/resources/Func2/CP-RF1-TM-RF-02-P1-03.json";
		TokenManager tm = new TokenManager();
		try {
			Token t = tm.readTokenFromJSON(filePath);
			tm.validateReqDate(t);
			Assertions.fail("An invalid Requested Date data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: invalid Requested Date data in JSON structure.");
		}
	}
	
	@Test
	/* Test case: TM_RF_02_P2_01
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: incorrect Requested Date received
	*/
	public void TM_RF_02_P2_01()
	{
		String filePath = "src/resources/Func2/CP-RF1-TM-RF-02-P1-03.json";
		TokenManager tm = new TokenManager();
		try {
			Token t = tm.readTokenFromJSON(filePath);
			tm.validateReqDate(t);
			Assertions.fail("An invalid Requested Date data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: invalid Requested Date data in JSON structure.");
		}
	}
	
	@Test
	/* Test case: TM_RF_02_O1_01
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: string value corresponding to the encoded Token
	*/
	public void TM_RF_02_O1_01()
	{
		String filePath = "src/resources/Func2/CP-RF1-01.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			tm.tokenTester(res, "N2VjYWE3YjJhMDg0NWMxZjk2YTk4ZGMxZTQwMDU2MDhjMjBhZjc1YjgyZjc3MDc1M2VmNDI2NGJjNDJmYzJiYw==");
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
	* Expected value: string value does not correspond to the generated Token
	*/
	public void TM_RF_02_O1_02()
	{
		String filePath = "src/resources/Func2/CP-RF1-01.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			tm.tokenTester(res, "N2VjYWE3YjJhMDg0NWMxZjk2YTk4ZGMxZTQwMDU2MDhjMjBhZjc1YjgyZjc3MDc1M2VmNDI2NGJjNDJmYzJiYw=+");
			
			Assertions.fail("An encoded string value does not correspond to expected string value of the Token exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: encoded string value does not correspond to expected string value of the Token.");
		}
	}
	
	@Test
	/* Test case: TM_RF_02_O2_01 - DONE
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: input data file not found
	*/
	public void TM_RF_02_O2_01()
	{
		String filePath = "src/resources/Func2/no_file_found.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("An input data file not found exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: input data file not found.");
		}
	}
	
	@Test
	/* Test case: TM_RF_02_O2_02 - DONE
	* Equivalence class or boundary value considered: <CE-RF1-V-01
	* Testing technique: Equivalence Class
	* Expected value: input file does not contain data or the data is not in the expected format
	*/
	public void TM_RF_02_O2_02()
	{
		String filePath = "src/resources/Func2/not_json_file.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("An input file does not contain data or the data is not in the expected format exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: input file does not contain data or the data is not in the expected format.");
		}
	}
}
