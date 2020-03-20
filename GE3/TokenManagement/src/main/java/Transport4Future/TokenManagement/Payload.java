package Transport4Future.TokenManagement;

import java.time.LocalDate;
import java.util.Date;

public class Payload {
	private String device;
	private LocalDate issued_at;
	private LocalDate expiration_date;
	
	public Payload(String device, LocalDate issued_at, LocalDate expiration_date) {
		super();
		this.device = device;
		this.issued_at = issued_at;
		this.expiration_date = expiration_date;
	}

	public String getDevice() {
		return device;
	}

	public LocalDate getIssued_at() {
		return issued_at;
	}

	public LocalDate getExpiration_date() {
		return expiration_date;
	}

	@Override
	public String toString() {
		return "Payload [device=" + device + ", issued_at=" + issued_at + ", expiration_date=" + expiration_date + "]";
	}
	
}
