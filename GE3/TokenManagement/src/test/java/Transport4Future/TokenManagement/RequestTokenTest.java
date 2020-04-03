package Transport4Future.TokenManagement;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RequestTokenTest {

	@Test
	/* Test case: AS-FR2-V-01 - DONE
	* Derivation Tree Node: 1
	* Type of case: Regular Value
	* Testing technique: Syntax Analysis
	* Expected value: Pass 
	*/
	public void CP_RF2_01() throws TokenManagementException
	{
		String filePath = "src/resources/Func2/AS-FR2-V-01.json";
		TokenManager tm = new TokenManager();
		try {
			Token res = tm.readTokenFromJSON(filePath);
			assertNotNull(filePath);
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.fail("An exception was not expected.");
		}
	
		
	}
	
	@Test
	/* Test case: AS-FR2-NV-00 - DONE
	* Derivation Tree Node: 1
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: File not found
	*/
	public void CP_RF2_02()
	{
		String filePath = "src/resources/Func2/file_not_found.json";
		TokenManager tm = new TokenManager();
		try {
			Token res = tm.readTokenFromJSON(filePath);
			Assertions.fail("A file not found exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: input data file not found.", e.message);
		}
		
	}
	
	@Test
	/* Test case: AS-FR2-NV-01 - DONE
	* Derivation Tree Node: 2
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I1()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-01.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: input file does not contain data or the data is not in the expected format.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-02 - DONE
	* Derivation Tree Node: 2
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I2()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-02.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: input file does not contain data or the data is not in the expected format.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-03 - DONE
	* Derivation Tree Node: 3
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I3()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-03.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid input data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-04 - DONE
	* Derivation Tree Node: 3
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I4()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-04.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: input file does not contain data or the data is not in the expected format.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-05 - DONE
	* Derivation Tree Node: 6
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I5()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-05.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: input file does not contain data or the data is not in the expected format.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-06 - DONE
	* Derivation Tree Node: 6
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I6()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-06.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: input file does not contain data or the data is not in the expected format.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-07 - DONE
	* Derivation Tree Node: 7
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I7()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-07.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: input file does not contain data or the data is not in the expected format.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-08 - DONE
	* Derivation Tree Node: 7
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I8()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-08.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: input file does not contain data or the data is not in the expected format.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-09 - DONE
	* Derivation Tree Node: 12
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I9()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-09.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid object names in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-10 - DONE
	* Derivation Tree Node: 12
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I10()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-10.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: input file does not contain data or the data is not in the expected format.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-11 - DONE
	* Derivation Tree Node: 13
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I11()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-11.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: input file does not contain data or the data is not in the expected format.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-12 - DONE
	* Derivation Tree Node: 13
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I12()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-12.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: input file does not contain data or the data is not in the expected format.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-13 - DONE
	* Derivation Tree Node: 14
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I13()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-13.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: input file does not contain data or the data is not in the expected format.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-14 - DONE
	* Derivation Tree Node: 14
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I14()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-14.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: input file does not contain data or the data is not in the expected format.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-09 - DONE
	* Derivation Tree Node: 23
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I15()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-15.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid object names in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-V-01 - DONE
	* Derivation Tree Node: 1
	* Type of case: Delete
	* Testing technique: Syntax Analysis
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
	/* Test case: AS-FR2-V-01 - DONE
	* Derivation Tree Node: 1
	* Type of case: Delete
	* Testing technique: Syntax Analysis
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
	/* Test case: AS-FR2-V-01 - DONE
	* Derivation Tree Node: 1
	* Type of case: Delete
	* Testing technique: Syntax Analysis
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
	/* Test case: AS-FR2-V-01 - DONE
	* Derivation Tree Node: 1
	* Type of case: Delete
	* Testing technique: Syntax Analysis
	* Expected value: verify further access requests without storing ALL the tokens generated
	*/
	public void TM_RF_02_P2_01()
	{
		String filePath = "src/resources/Func2/CP-RF1-TM-RF-02-P2-01.json";
		TokenManager tm = new TokenManager();
		try {
			Token t = tm.readTokenFromJSON(filePath);
			TokensStore ts = new TokensStore();
			ts.Find(t.toString());
			Assertions.fail("An invalid ??? exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: invalid ???.");
		}
	}
	
	@Test
	/* Test case: AS-FR2-V-01 - DONE
	* Derivation Tree Node: 1
	* Type of case: Delete
	* Testing technique: Syntax Analysis
	* Expected value: verify further access requests after storing ALL the tokens generated
	*/
	public void TM_RF_02_P2_02()
	{
		String filePath = "src/resources/Func2/CP-RF1-TM-RF-02-P2-02.json";
		TokenManager tm = new TokenManager();
		try {
			Token t = tm.readTokenFromJSON(filePath);
			TokensStore ts = new TokensStore();
			ts.Find(t.toString());
			Assertions.fail("An invalid ??? exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals(e.message, "Error: invalid ???.");
		}
	}
	
	@Test
	/* Test case: AS-FR2-V-01 - DONE
	* Derivation Tree Node: 1
	* Type of case: Regular Value
	* Testing technique: Syntax Analysis
	* Expected value: string value corresponding to the encoded Token
	*/
	public void TM_RF_02_O1_01() throws TokenManagementException {
	
		String filePath = "src/resources/Func2/CP-RF1-01.json";
		TokenManager tm = new TokenManager();

		String res = tm.RequestToken(filePath);
		Assertions.assertEquals("IGNjYjJlY2NjYmFlOGE2MGVmNTAyMjdiNzEyYjY1Y2MwZjgwMGE0MzRiYTkwYzAwMmQ0ZGQxZGM4OTI0MTI2MA==", res);
		
	}
	
	@Test
	/* Test case: AS-FR2-V-01 - DONE
	* Derivation Tree Node: 1
	* Type of case: Delete
	* Testing technique: Syntax Analysis
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
	/* Test case: AS-FR2-V-01 - DONE
	* Derivation Tree Node: 1
	* Type of case: Delete
	* Testing technique: Syntax Analysis
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
	/* Test case: AS-FR2-V-01 - DONE
	* Derivation Tree Node: 1
	* Type of case: Delete
	* Testing technique: Syntax Analysis
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
	
	@Test
	/* Test case: AS-FR2-V-01 - DONE
	* Derivation Tree Node: 1
	* Type of case: Delete
	* Testing technique: Syntax Analysis
	* Expected value: Internal processing error when generating the Token.
	*/
	public void TM_RF_02_O2_03()
	{
		
	}
	
	@Test
	/* Test case: AS-FR2-V-01 - DONE
	* Derivation Tree Node: 1
	* Type of case: Delete
	* Testing technique: Syntax Analysis
	* Expected value: Internal error when saving the token.
	*/
	public void TM_RF_02_O2_04()
	{
		
	}
	
	@Test
	/* Test case: AS-FR2-V-01 - DONE
	* Derivation Tree Node: 1
	* Type of case: Delete
	* Testing technique: Syntax Analysis
	* Expected value: Internal error when encoding the token
	*/
	public void TM_RF_02_O2_05()
	{
		
	}
}
