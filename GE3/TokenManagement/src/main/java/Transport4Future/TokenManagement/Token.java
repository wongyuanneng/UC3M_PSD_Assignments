package Transport4Future.TokenManagement;

import java.util.Date;

public class Token {
	private String alg;
	private String typ;
	private String device;
	private long issued_at;
	private long expiration_date;
	private String requestDate;
	private String notifEmail;
	
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

	@Override
	public String toString() {
		return "Token [alg=" + alg + ", typ=" + typ + ", device=" + device + ", issued_at=" + issued_at
				+ ", expiration_date=" + expiration_date + ", requestDate=" + requestDate + ", notifEmail=" + notifEmail
				+ "]";
	}
	
}
