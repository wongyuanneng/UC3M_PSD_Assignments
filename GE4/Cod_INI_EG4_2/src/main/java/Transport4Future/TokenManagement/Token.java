package Transport4Future.TokenManagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Token {
  private Header header;
  private Payload payload;
  private String signature;
  private String requestDate;
  private String notificationEmail;
  private String tokenValue;

  /**
   * Token constructor
   *
   * 
   */
  public Token (String device, String requestDate, String notificationEmail) {
    this.header = new Header();
    this.payload = new Payload(device);
    this.requestDate = requestDate;
    this.notificationEmail = notificationEmail;
    
    // SOLO PARA PRUEBAS
    this.signature = null;
    this.tokenValue = null;
  }

  public String getRequestDate() {
    return requestDate;
  }

  public String getNotificationEmail() {
    return notificationEmail;
  }
  
  public Header getHeader() {
    return header;
  }

  public Payload getPayload() {
    return payload;
  }

/**
   * Get value of header from token parameters
   *
   * @throws TokenManagementException if any error occurs
   */
  public String headerToString() {
    return	"Alg=" + this.header.getAlg() + "\\n Typ=" + this.header.getTyp() + "\\n";
  }
  
  /**
   * Get value of payload from token parameters
   *
   * @throws TokenManagementException if any error occurs
   */
  public String payloadToString () {
    Date iatDate = new Date(this.payload.getIat());
    Date expDate = new Date(this.payload.getExp());
		
    DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
    return	"Dev=" + this.payload.getDevice() 
				+ "\\n iat=" + df.format(iatDate)
				+ "\\n exp=" + df.format(expDate);
  }
	
  public void setSignature(String value) {
    this.signature = value;
  }

  public String getSignature() {
    return this.signature;
  }
	
  public void setTokenValue(String value) {
    this.tokenValue = value;
  }
	
  public String getTokenValue() {
    return this.tokenValue;
  }	
}
