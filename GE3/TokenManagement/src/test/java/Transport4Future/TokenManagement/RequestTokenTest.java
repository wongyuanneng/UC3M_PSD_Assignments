package Transport4Future.TokenManagement;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RequestTokenTest {

	@Test
	/* Test case: AS-FR2-V-000 - DONE
	* Derivation Tree Node: 5, 11, 15, 19, 26, 33, 40, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 60, 61, 62, 63, 64, 75, 76, 77, 78, 79, 80, 83, 86, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106
	* Type of case: Regular Value
	* Testing technique: Syntax Analysis
	* Expected value: Pass 
	*/
	public void TM_RF_02_RI0() throws TokenManagementException
	{
		String filePath = "src/resources/Func2/AS-FR2-V-000.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			assertNotNull(filePath);
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.fail("An exception was not expected.");
		}
	
		
	}
	
	@Test
	/* Test case: AS-FR2-NV-000 - DONE
	* Derivation Tree Node: All terminals + non-terminals
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: File not found
	*/
	public void TM_RF_02_I0()
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
	/* Test case: AS-FR2-NV-001 - DONE
	* Derivation Tree Node: 2, 5
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I1()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-001.json";
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
	/* Test case: AS-FR2-NV-002 - DONE
	* Derivation Tree Node: 2, 5
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I2()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-002.json";
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
	/* Test case: AS-FR2-NV-003 - DONE
	* Derivation Tree Node: 6, 7, 8, 9, 10, 12, 13, 14, 16, 17, 18, 20, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32, 34, 35, 36, 37, 38, 39, 41, 42, 43, 44, 55, 56, 57, 58, 59, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 81, 82, 84, 85, 87, 88, 89, 90, 15, 19, 26, 33, 40, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 60, 61, 62, 63, 64, 75, 76, 77, 78, 79, 80, 83, 86, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid input data in JSON structure.
	*/
	public void TM_RF_02_I3()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-003.json";
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
	/* Test case: AS-FR2-NV-004 - DONE
	* Derivation Tree Node: 6, 7, 8, 9, 10, 12, 13, 14, 16, 17, 18, 20, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32, 34, 35, 36, 37, 38, 39, 41, 42, 43, 44, 55, 56, 57, 58, 59, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 81, 82, 84, 85, 87, 88, 89, 90, 15, 19, 26, 33, 40, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 60, 61, 62, 63, 64, 75, 76, 77, 78, 79, 80, 83, 86, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I4()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-004.json";
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
	/* Test case: AS-FR2-NV-005 - DONE
	* Derivation Tree Node: 6, 12, 13, 14, 23, 24, 25, 26, 27, 28, 29, 45, 46, 47, 48, 49, 50
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I5()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-005.json";
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
	/* Test case: AS-FR2-NV-006 - DONE
	* Derivation Tree Node: 6, 12, 13, 14, 23, 24, 25, 26, 27, 28, 29, 45, 46, 47, 48, 49, 50
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I6()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-006.json";
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
	/* Test case: AS-FR2-NV-007 - DONE
	* Derivation Tree Node: 7, 15
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I7()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-007.json";
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
	/* Test case: AS-FR2-NV-008 - DONE
	* Derivation Tree Node: 7, 15
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I8()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-008.json";
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
	/* Test case: AS-FR2-NV-009 - DONE
	* Derivation Tree Node: 12, 23, 24, 25, 45, 46, 47
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid object names in JSON structure.
	*/
	public void TM_RF_02_I9()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-009.json";
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
	/* Test case: AS-FR2-NV-010 - DONE
	* Derivation Tree Node: 12, 23, 24, 25, 45, 46, 47
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I10()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-010.json";
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
	/* Test case: AS-FR2-NV-011 - DONE
	* Derivation Tree Node: 13, 26
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I11()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-011.json";
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
	/* Test case: AS-FR2-NV-012 - DONE
	* Derivation Tree Node: 13, 26
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I12()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-012.json";
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
	/* Test case: AS-FR2-NV-013 - DONE
	* Derivation Tree Node: 14, 27, 28, 29, 48, 49, 50
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I13()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-013.json";
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
	/* Test case: AS-FR2-NV-014 - DONE
	* Derivation Tree Node: 14, 27, 28, 29, 48, 49, 50
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I14()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-014.json";
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
	/* Test case: AS-FR2-NV-015 - DONE
	* Derivation Tree Node: 23, 45
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I15()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-015.json";
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
	/* Test case: AS-FR2-NV-016 - DONE
	* Derivation Tree Node: 23, 45
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I16()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-016.json";
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
	/* Test case: AS-FR2-NV-017 - DONE
	* Derivation Tree Node: 24, 46
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid object names in JSON structure.
	*/
	public void TM_RF_02_I17()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-017.json";
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
	/* Test case: AS-FR2-NV-018 - DONE
	* Derivation Tree Node: 24, 46
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: invalid object names in JSON structure.
	*/
	public void TM_RF_02_I18()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-018.json";
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
	/* Test case: AS-FR2-NV-019 - DONE
	* Derivation Tree Node: 26
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I19()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-019.json";
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
	/* Test case: AS-FR2-NV-020 - DONE
	* Derivation Tree Node: 29, 49
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid Token Request String data in JSON structure.
	*/
	public void TM_RF_02_I20()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-020.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Token Request String data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-021 - DONE
	* Derivation Tree Node: 35, 55, 56, 57, 58, 59, 76, 77, 78, 79, 80
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid Notification E-mail data in JSON structure.
	*/
	public void TM_RF_02_I21()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-021.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Notification E-mail data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-022 - DONE
	* Derivation Tree Node: 35, 55, 56, 57, 58, 59, 76, 77, 78, 79, 80
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: invalid Notification E-mail data in JSON structure.
	*/
	public void TM_RF_02_I22()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-022.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Notification E-mail data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-023 - DONE
	* Derivation Tree Node: 42, 65, 66, 67, 68, 69, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I23()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-023.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-024 - DONE
	* Derivation Tree Node: 42, 65, 66, 67, 68, 69, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I24()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-024.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-025 - DONE
	* Derivation Tree Node: 43, 70, 71, 72, 73, 74, 91, 92, 93, 94, 95, 96, 97, 98
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I25()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-025.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-026 - DONE
	* Derivation Tree Node: 43, 70, 71, 72, 73, 74, 91, 92, 93, 94, 95, 96, 97, 98
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I26()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-026.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-027 - DONE
	* Derivation Tree Node: 45
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: input file does not contain data or the data is not in the expected format.
	*/
	public void TM_RF_02_I27()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-027.json";
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
	/* Test case: AS-FR2-NV-028 - DONE
	* Derivation Tree Node: 46
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: invalid object names in JSON structure.
	*/
	public void TM_RF_02_I28()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-028.json";
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
	/* Test case: AS-FR2-NV-029 - DONE
	* Derivation Tree Node: 49
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: invalid Token Request String data in JSON structure.
	*/
	public void TM_RF_02_I29()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-029.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Token Request String data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-030 - DONE
	* Derivation Tree Node: 52
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: invalid object names in JSON structure.
	*/
	public void TM_RF_02_I30()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-030.json";
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
	/* Test case: AS-FR2-NV-031 - DONE
	* Derivation Tree Node: 55, 76
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid Notification E-mail data in JSON structure.
	*/
	public void TM_RF_02_I31()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-031.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Notification E-mail data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-032 - DONE
	* Derivation Tree Node: 56, 77
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid Notification E-mail data in JSON structure.
	*/
	public void TM_RF_02_I32()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-032.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Notification E-mail data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-033 - DONE
	* Derivation Tree Node: 56, 77
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: invalid Notification E-mail data in JSON structure.
	*/
	public void TM_RF_02_I33()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-033.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Notification E-mail data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-034 - DONE
	* Derivation Tree Node: 57, 78
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid Notification E-mail data in JSON structure.
	*/
	public void TM_RF_02_I34()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-034.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Notification E-mail data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-035 - DONE
	* Derivation Tree Node: 58, 79
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid Notification E-mail data in JSON structure.
	*/
	public void TM_RF_02_I35()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-035.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Notification E-mail data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-036 - DONE
	* Derivation Tree Node: 58, 79
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: invalid Notification E-mail data in JSON structure.
	*/
	public void TM_RF_02_I36()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-036.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Notification E-mail data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-037 - DONE
	* Derivation Tree Node: 59, 80
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid Notification E-mail data in JSON structure.
	*/
	public void TM_RF_02_I37()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-037.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Notification E-mail data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-038 - DONE
	* Derivation Tree Node: 59, 80
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: invalid Notification E-mail data in JSON structure.
	*/
	public void TM_RF_02_I38()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-038.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Notification E-mail data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-039 - DONE
	* Derivation Tree Node: 62
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: invalid object names in JSON structure.
	*/
	public void TM_RF_02_I39()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-039.json";
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
	/* Test case: AS-FR2-NV-040 - DONE
	* Derivation Tree Node: 65, 81, 82, 99, 100
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I40()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-040.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-041 - DONE
	* Derivation Tree Node: 65, 81, 82, 99, 100
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I41()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-041.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-042 - DONE
	* Derivation Tree Node: 66, 83
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I42()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-042.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-043 - DONE
	* Derivation Tree Node: 66, 83
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I43()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-043.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-044 - DONE
	* Derivation Tree Node: 67, 84, 85, 101, 102
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I44()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-044.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-045 - DONE
	* Derivation Tree Node: 67, 84, 85, 101, 102
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I45()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-045.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-046 - DONE
	* Derivation Tree Node: 69, 87, 88, 89, 90, 103, 104, 105, 106
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I46()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-046.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-047 - DONE
	* Derivation Tree Node: 69, 87, 88, 89, 90, 103, 104, 105, 106
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I47()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-047.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-048 - DONE
	* Derivation Tree Node: 70, 91, 92
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I48()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-048.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-049 - DONE
	* Derivation Tree Node: 70, 91, 92
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I49()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-049.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-050 - DONE
	* Derivation Tree Node: 71, 93
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I50()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-050.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-051 - DONE
	* Derivation Tree Node: 71, 93
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I51()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-051.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-052 - DONE
	* Derivation Tree Node: 72, 94, 95
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I52()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-052.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-053 - DONE
	* Derivation Tree Node: 72, 94, 95
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I53()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-053.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-054 - DONE
	* Derivation Tree Node: 74, 97, 98
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I54()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-054.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-055 - DONE
	* Derivation Tree Node: 74, 97, 98
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I55()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-055.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-056 - DONE
	* Derivation Tree Node: 76
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: invalid object names in JSON structure.
	*/
	public void TM_RF_02_I56()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-056.json";
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
	/* Test case: AS-FR2-NV-057 - DONE
	* Derivation Tree Node: 77
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: invalid Notification E-mail data in JSON structure.
	*/
	public void TM_RF_02_I57()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-057.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Notification E-mail data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-058 - DONE
	* Derivation Tree Node: 78
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: invalid object names in JSON structure.
	*/
	public void TM_RF_02_I58()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-058.json";
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
	/* Test case: AS-FR2-NV-059 - DONE
	* Derivation Tree Node: 79
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: invalid Notification E-mail data in JSON structure.
	*/
	public void TM_RF_02_I59()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-059.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Notification E-mail data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-060 - DONE
	* Derivation Tree Node: 80
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: invalid object names in JSON structure.
	*/
	public void TM_RF_02_I60()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-060.json";
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
	/* Test case: AS-FR2-NV-061 - DONE
	* Derivation Tree Node: 81, 99
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I61()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-061.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-062 - DONE
	* Derivation Tree Node: 81, 99
	* Type of case: Repetition
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I62()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-062.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-063 - DONE
	* Derivation Tree Node: 83
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I63()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-063.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-064 - DONE
	* Derivation Tree Node: 91
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I64()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-064.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-065 - DONE
	* Derivation Tree Node: 92
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I65()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-065.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-066 - DONE
	* Derivation Tree Node: 93
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I66()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-066.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-067 - DONE
	* Derivation Tree Node: 94
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I67()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-067.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-068 - DONE
	* Derivation Tree Node: 99
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I68()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-068.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-069 - DONE
	* Derivation Tree Node: 100
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I69()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-069.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-NV-070 - DONE
	* Derivation Tree Node: 101
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: invalid Requested Date data in JSON structure.
	*/
	public void TM_RF_02_I70()
	{
		String filePath = "src/resources/Func2/AS-FR2-NV-070.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			Assertions.fail("A invalid input data in JSON structure exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: invalid Requested Date data in JSON structure.", e.message);
		}
	}
	
	
	
	@Test
	/* Test case: AS-FR2-O1-01 - DONE
	* Derivation Tree Node:
	* Type of case: 
	* Testing technique: Syntax Analysis
	* Expected value: string value corresponding to the encoded Token
	*/
	public void TM_RF_02_O1_01() throws TokenManagementException {
	
		String filePath = "src/resources/Func2/AS-FR2-V-000.json";
		TokenManager tm = new TokenManager();
		String res = tm.RequestToken(filePath);
		Assertions.assertEquals("N2IyNGI3YmNjNGM0OGE5ZmUxNDNmYTkwNmYzNDU0N2NjNzI0MTIzZjBjZGIyMjUxMTQ0NjEwNjM5YmEwNGI3MQ==", res);
		
	}
	
	@Test
	/* Test case: AS-FR2-O1-02 - DONE
	* Derivation Tree Node: 
	* Type of case: 
	* Testing technique: Syntax Analysis
	* Expected value: string value does not correspond to the generated Token
	*/
	public void TM_RF_02_O1_02()
	{
		String filePath = "src/resources/Func2/AS-FR2-V-000.json";
		TokenManager tm = new TokenManager();
		try {
			String res = tm.RequestToken(filePath);
			tm.tokenTester(res, "N2IyNGI3YmNjNGM0OGE5ZmUxNDNmYTkwNmYzNDU0N2NjNzI0MTIzZjBjZGIyMjUxMTQ0NjEwNjM5YmEwNGI3MQ=+");
			
			Assertions.fail("An encoded string value does not correspond to expected string value of the Token exception was expected.");
		} catch (TokenManagementException e) {
			// TODO Auto-generated catch block
			Assertions.assertEquals("Error: encoded string value does not correspond to expected string value of the Token.", e.message);
		}
	}
	
	@Test
	/* Test case: AS-FR2-O2-01 - DONE
	* Derivation Tree Node: 
	* Type of case: 
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
	/* Test case: AS-FR2-O2-02 - DONE
	* Derivation Tree Node:
	* Type of case: 
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
	

}
