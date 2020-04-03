package Transport4Future.TokenManagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Token {
	private String alg;
	private String typ;
	private String device;
	private long issued_at;
	private long expiration_date;
	private String requestDate;
	private String notifEmail;
	private String signature;
	private String tokenValue;
	
	public Token(String device, String requestDate, String notifEmail) {
		super();
		this.alg="SHA-256";
		this.typ="PDS";
		this.device = device;
		//this.issued_at = System.currentTimeMillis();
		this.issued_at = 1583780309;
		this.expiration_date = this.issued_at + 604800000l;
		this.requestDate = requestDate;
		this.notifEmail = notifEmail;
		this.signature = null;
		this.tokenValue = null;
	}

	public String getAlg() {
		return alg;
	}

	public String getTyp() {
		return typ;
	}

	public String getDevice() {
		return device;
	}

	public long getIssued_at() {
		return issued_at;
	}

	public long getExpiration_date() {
		return expiration_date;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public String getNotifEmail() {
		return notifEmail;
	}

	public String getSignature() {
		return signature;
	}

	public String getTokenValue() {
		return tokenValue;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}

	public boolean isGranted () {
		return (this.issued_at < System.currentTimeMillis());
	}
	
	public boolean isExpired () {
		return !(this.expiration_date > System.currentTimeMillis());
	}

	public String getHeader () {
		return	"Alg=" + this.alg + "\\n Typ=" + this.typ + "\\n";
	}
	
	public String getPayload () {
		Date iatDate = new Date(this.issued_at);
		Date expDate = new Date(this.expiration_date);
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		return	"Dev=" + this.device 
				+ "\\n iat=" + df.format(iatDate)
				+ "\\n exp=" + df.format(expDate);
	}
	
	@Override
	public String toString() {
		return "Token [alg=" + alg + ", typ=" + typ + ", device=" + device + ", issued_at=" + issued_at
				+ ", expiration_date=" + expiration_date + ", requestDate=" + requestDate + ", notifEmail=" + notifEmail
				+ ", signature=" + signature + ", tokenValue=" + tokenValue + "]";
	}
	
}
