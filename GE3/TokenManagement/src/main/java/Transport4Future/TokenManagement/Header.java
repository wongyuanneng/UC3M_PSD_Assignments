package Transport4Future.TokenManagement;

public class Header {
	private String alg;
	private String typ;
	
	public Header() {
		this.alg="SHA-256";
		this.typ="PDS";
	}
	
	public Header(String alg, String typ) {
		super();
		this.alg = alg;
		this.typ = typ;
	}
	
	public String getAlg() {
		return alg;
	}
	
	public String getTyp() {
		return typ;
	}

	@Override
	public String toString() {
		return "Header [alg=" + alg + ", typ=" + typ + "]";
	}

}
