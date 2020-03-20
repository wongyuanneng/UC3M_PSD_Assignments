package Transport4Future.TokenManagement;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Token {
	private Header h;
	private Payload p;
	private String signature;
	
	public Token(Header h, Payload p, String signature) {
		super();
		this.h = h;
		this.p = p;
		this.signature = signature;
	}
	
	public Header getH() {
		return h;
	}
	
	public Payload getP() {
		return p;
	}
	
	public String getSignature() {
		return signature;
	}
}
