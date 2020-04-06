package Transport4Future.TokenManagement;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
  @Test
  /* Test case: CP_RF1_01
  * Equivalence class or boundary value considered: <CE-RF1-V-01>
  * Testing technique: Equivalence Class
  * Expected value: Pass 
  */
  public void cp_RF1_01() {
    String filePath = "resources/Func1/CP-RF1-01.json";
    TokenManager tm = new TokenManager();
    Assertions.assertThrows(TokenManagementException.class, () -> tm.readTokenRequestFromJSON(filePath));
    assertNotNull(filePath);
  }

  @Test
  /* Test case: CP_RF1_02
  * Equivalence class or boundary value considered: <CE-RF1-IV-02>
  * Testing technique: Equivalence Class
  * Expected value: File not found
  */
  public void cp_RF1_02() {
    String filePath = "src/resources/Func1/file_not_found.json";
    TokenManager tm = new TokenManager();
    try {
      String res = tm.TokenRequestGeneration(filePath, "MD5");
      Assertions.fail("A file not found exception was expected.");
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: input data file not found.");
    }
  }

  @Test
  /* Test case: TM_RF_01_I1 - DONE
  * Equivalence class or boundary value considered: 
  * <CE-RF1-IV-04>
  * <CE-RF1-IV-05>, <CE-RF1-IV-09>, <CE-RF1-IV-12>, <CE-RF1-IV-16>, <CE-RF1-IV-19>, <CE-RF1-IV-23>
  * Testing technique: Equivalence Class
  * Expected value: invalid input data in JSON structure
  */
  public void tm_RF_01_I1() {
    TokenManager tm = new TokenManager();
    String filePath;
    
    filePath = "src/resources/Func1/CP-RF1-I1_1.json";
    try {
      String res = tm.TokenRequestGeneration(filePath, "MD5");
      Assertions.fail("A invalid input data in JSON structure exception was expected.");
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: invalid input data in JSON structure.");
    }

    filePath = "src/resources/Func1/CP-RF1-I1_2.json";
    try {
      String res = tm.TokenRequestGeneration(filePath, "MD5");
      Assertions.fail("A invalid input data in JSON structure exception was expected.");
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: invalid input data in JSON structure.");
    }

    filePath = "src/resources/Func1/CP-RF1-I1_3.json";
    try {
      String res = tm.TokenRequestGeneration(filePath, "MD5");
      Assertions.fail("A invalid input data in JSON structure exception was expected.");
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: invalid input data in JSON structure.");
    }

    filePath = "src/resources/Func1/CP-RF1-I1_4.json";
    try {
      String res = tm.TokenRequestGeneration(filePath, "MD5");
      Assertions.fail("A invalid input data in JSON structure exception was expected.");
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: invalid input data in JSON structure.");
    }

    filePath = "src/resources/Func1/CP-RF1-I1_5.json";
    try {
      String res = tm.TokenRequestGeneration(filePath, "MD5");
      Assertions.fail("A invalid input data in JSON structure exception was expected.");
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: invalid input data in JSON structure.");
    }

    filePath = "src/resources/Func1/CP-RF1-I1_6.json";
    try {
      String res = tm.TokenRequestGeneration(filePath, "MD5");
      Assertions.fail("A invalid input data in JSON structure exception was expected.");
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: invalid input data in JSON structure.");
    }
  }

  @Test
  /* Test case: TM_RF_01_P1 - DONE
  * Equivalence class or boundary value considered: 
  * <CE-RF1-IV-07>, <CE-RF1-IV-10>, <CE-RF1-IV-14>, <CE-RF1-IV-17>, <CE-RF1-IV-21>, <CE-RF1-IV-25>
  * <CE-RF1-IV-13>
  * <CE-RF1-IV-20>
  * <CE-RF1-IV-24>
  * Testing technique: Equivalence Class
  * Expected values: 
  * incorrect Device Name received
  * incorrect Driver Version received
  * incorrect E-mail received 
  * incorrect Serial Number received
  * incorrect Device Type received
  */
  public void tm_RF_01_P1() {
    TokenManager tm = new TokenManager();
    String filePath;

    filePath = "src/resources/Func1/CP-RF1-P1_1a.json";
    try {
      TokenRequest req = tm.readTokenRequestFromJSON(filePath);
      Assertions.fail("An invalid Device Name data in JSON structure exception was expected.");
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: invalid Device Name data in JSON structure.");
    }

    filePath = "src/resources/Func1/CP-RF1-P1_1b.json";
    try {
      TokenRequest req = tm.readTokenRequestFromJSON(filePath);
      Assertions.fail("An invalid Device Type data in JSON structure exception was expected.");
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: invalid Device Type data in JSON structure.");
    }

    filePath = "src/resources/Func1/CP-RF1-P1_1c.json";
    try {
      TokenRequest req = tm.readTokenRequestFromJSON(filePath);
      Assertions.fail("An invalid Driver Version data in JSON structure exception was expected.");
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: invalid Driver Version data in JSON structure.");
    }

    filePath = "src/resources/Func1/CP-RF1-P1_1d.json";
    try {
      TokenRequest req = tm.readTokenRequestFromJSON(filePath);
      Assertions.fail("An invalid E-mail data in JSON structure exception was expected.");
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: invalid E-mail data in JSON structure.");
    }

    filePath = "src/resources/Func1/CP-RF1-P1_1e.json";
    try {
      TokenRequest req = tm.readTokenRequestFromJSON(filePath);
      Assertions.fail("An invalid Serial Number data in JSON structure exception was expected.");
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: invalid Serial Number data in JSON structure.");
    }

    filePath = "src/resources/Func1/CP-RF1-P1_1f.json";
    try {
      TokenRequest req = tm.readTokenRequestFromJSON(filePath);
      Assertions.fail("An invalid MAC Address data in JSON structure exception was expected.");
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: invalid MAC Address data in JSON structure.");
    }

    filePath = "src/resources/Func1/CP-RF1-P1_2.json";
    try {
      TokenRequest req = tm.readTokenRequestFromJSON(filePath);
      tm.validateDriverVer(req);
      Assertions.fail("An invalid Driver Version data in JSON structure exception was expected.");
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: invalid Driver Version data in JSON structure.");
    }

    filePath = "src/resources/Func1/CP-RF1-P1_3.json";
    try {
      TokenRequest req = tm.readTokenRequestFromJSON(filePath);
      tm.validateSN(req);
      Assertions.fail("An invalid Serial Number data in JSON structure exception was expected.");
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: invalid Serial Number data in JSON structure.");
    }

    filePath = "src/resources/Func1/CP-RF1-P1_4.json";
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
  /* Test case: TM_RF_01_P2 - DONE
  * Equivalence class or boundary value considered: 
  * <CE-RF1-V-03>, <CE-RF1-V-08>, <CE-RF1-V-11>, <CE-RF1-V-15>, <CE-RF1-V-18>, <CE-RF1-V-22>, <CE-RF1-V-26>
  * <CE-RF1-IV-27>, <CE-RF1-V-28>
  * Testing technique: Equivalence Class
  * Expected value: correct data received and the value generated is a String
  */
  public void tm_RF_01_P2() {
    String filePath = "src/resources/Func1/CP-RF1-C1.json";
    TokenManager tm = new TokenManager();
    try {
      TokenRequest req = tm.readTokenRequestFromJSON(filePath);
      tm.validateAll(req);
      if (!(tm.TokenRequestGeneration(filePath, "MD5") instanceof String)) {
        Assertions.fail("A generated String value was expected.");
      }
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: A generated String value was expected.");
    }
  }

  @Test
  /* Test case: TM_RF_01_O1 - DONE
  * Equivalence class or boundary value considered: 
  * <CE-RF1-IV-29>
  * <CE-RF1-V-30>
  * Testing technique: Equivalence Class
  * Expected value: 
  * string value corresponding to the generated Token Request
  * string value does no correspond to the generated Token Request
  */
  public void tm_RF_01_O1() {
    String filePath = "src/resources/Func1/CP-RF1-C1.json";
    TokenManager tm = new TokenManager();

    try {
      String res = tm.TokenRequestGeneration(filePath, "MD5");
      tm.tokenRequestTester(res, "437af2f417fb67604686f7df3e9ca4bd");
      
      Assertions.fail("A generated string value does not correspond to expected string value of the TokenRequest exception was expected.");
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: generated string value does not correspond to expected string value of the TokenRequest.");
    }

    try {
      String res = tm.TokenRequestGeneration(filePath, "MD5");
      tm.tokenRequestTester(res, "437af2f417fb67604686f7df3e9ca4bc");
      System.out.println(res);
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.fail("An exception was not expected.");
    }
  }

  @Test
  /* Test case: TM_RF_01_O2 - DONE
  * Equivalence class or boundary value considered: 
  * <CE-RF1-IV-31>
  * <CE-RF1-IV-32>
  * <CE-RF1-IV-33>
  * Testing technique: Equivalence Class
  * Expected value: 
  * input data file not found
  * input file does not contain data or the data is not in the expected format
  * internal processing error when obtaining the Token Request
  */
  public void tm_RF_01_O2() {
    String filePath = "src/resources/Func1/no_file_found.json";
    TokenManager tm = new TokenManager();
    try {
      String res = tm.TokenRequestGeneration(filePath, "MD5");
      Assertions.fail("An input data file not found exception was expected.");
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: input data file not found.");
    }

    filePath = "src/resources/Func1/CP-RF1-O2.json";
    try {
      String res = tm.TokenRequestGeneration(filePath, "MD5");
      Assertions.fail("An input file does not contain data or the data is not in the expected format exception was expected.");
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: input file does not contain data or the data is not in the expected format.");
    }

    filePath = "src/resources/Func1/CP-RF1-C1.json";
    try {
      String res = tm.TokenRequestGeneration(filePath, "MD6");
      Assertions.fail("An internal processing error when obtaining the Token Request exception was expected.");
    } catch (TokenManagementException e) {
      // TODO Auto-generated catch block
      Assertions.assertEquals(e.message, "Error: internal processing error when obtaining the Token Request.");
    }
  }
}
