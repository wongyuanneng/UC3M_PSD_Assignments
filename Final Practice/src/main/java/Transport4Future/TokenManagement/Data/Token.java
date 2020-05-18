package Transport4Future.TokenManagement.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

import Transport4Future.TokenManagement.Data.Attributes.Device;
import Transport4Future.TokenManagement.Data.Attributes.EMail;
import Transport4Future.TokenManagement.Data.Attributes.RequestDate;
import Transport4Future.TokenManagement.Exceptions.TokenManagementException;
import Transport4Future.TokenManagement.IO.TokenParser;
import Transport4Future.TokenManagement.Store.TokensRequestStore;
import Transport4Future.TokenManagement.Store.TokensStore;
import Transport4Future.Utils.SHA256Hasher;

public class Token {
	private String alg;
	private String typ;
	private Device device;
	private RequestDate requestDate;
	private EMail notificationEmail;
	private long iat;
	private long exp;
	private String signature;
	private String tokenValue;
	
	public Token (String FileName) throws TokenManagementException {
		TokenParser myParser = new TokenParser();
		HashMap<String, String> items = myParser.Parse(FileName);
		this.alg = "HS256";
		this.typ = "PDS";
		this.device = new Device(items.get(TokenParser.TOKEN_REQUEST));
		this.requestDate = new RequestDate(items.get(TokenParser.REQUEST_DATE));
		this.notificationEmail = new EMail(items.get(TokenParser.NOTIFICATION_E_MAIL));
		this.checkTokenRequestEmmision();
//		this.iat = System.currentTimeMillis();
		// SOLO PARA PRUEBAS
		testIATEXP();
		this.signature = this.generateSignature();
		this.tokenValue = this.setTokenValue();
		Store();
	}

	public Token() {

	}

	private void Store() throws TokenManagementException {
		TokensStore myStore = TokensStore.getInstance();
		myStore.Add(this);
	}

	public boolean Decode (String TokenStringRepresentation) {
		TokensStore myStore = TokensStore.getInstance();		
		Token tokenFound = myStore.Find(TokenStringRepresentation);
		
		if (tokenFound != null) {
			this.alg = tokenFound.alg;
			this.typ = tokenFound.typ;
			this.device = tokenFound.device;
			this.requestDate = tokenFound.requestDate;
			this.notificationEmail = tokenFound.notificationEmail;
			this.iat = tokenFound.iat;
			this.exp = tokenFound.exp;
			this.signature = tokenFound.signature;
			this.tokenValue = tokenFound.tokenValue;
			return true;
		}
		else{
			return false;
		}
	}
	
	private void testIATEXP() {
		this.iat = 1584523340892l;
		if ((this.device.getValue().startsWith("5"))){
			this.exp = this.iat + 604800000l;
		}
		else {
			this.exp = this.iat + 65604800000l;
		}
	}
	
	private String generateSignature () throws TokenManagementException {
		SHA256Hasher myHasher = new SHA256Hasher();
		return (myHasher.Hash(this.getHeader() + this.getPayload()));
	}
	
	private void checkTokenRequestEmmision() throws TokenManagementException {
		TokensRequestStore myStore = TokensRequestStore.getInstance(); 
        if (!myStore.Find(this.getDevice())) {
        	throw new TokenManagementException("Error: Token Request Not Previously Registered");
        }
	}
	
	public String getDevice() {
		return device.getValue();
	}

	public String getRequestDate() {
		return requestDate.getValue();
	}

	public String getNotificationEmail() {
		return notificationEmail.getValue();
	}
	
	public boolean isValid () {
		if ((this.iat < System.currentTimeMillis()) && (this.exp > System.currentTimeMillis())){
			return true;
		}
		else {
			return false;
		}
	}

	public String getHeader () {
		return	"Alg=" + this.alg + "\\n Typ=" + this.typ + "\\n";
	}
	
	public String getPayload () {
		Date iatDate = new Date(this.iat);
		Date expDate = new Date(this.exp);
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		return	"Dev=" + this.device.getValue() 
				+ "\\n iat=" + df.format(iatDate)
				+ "\\n exp=" + df.format(expDate);
	}

	public String getSignature() {
		return this.signature;
	}
	
	public String getTokenValue() {
		return this.tokenValue;
	}	
	
	private String setTokenValue() {
		String stringToEncode = this.getHeader() + this.getPayload() + this.getSignature();
		String result  = Base64.getUrlEncoder().encodeToString(stringToEncode.getBytes());
		return result;
	}
	
	public void setSignature(String value) {
		this.signature = value;
	}
}
