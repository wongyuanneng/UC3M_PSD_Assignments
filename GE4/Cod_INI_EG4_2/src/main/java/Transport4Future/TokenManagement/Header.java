package Transport4Future.TokenManagement;

public class Header {
  private String alg;
  private String typ;

  /**
   * Header constructor without parameters (default basic)
   *
   * 
   */
  public Header() {
    this.alg = "HS256";
    this.typ = "PDS";
  }
  
  /**
   * Header constructor without parameters (with alg and typ defined)
   *
   * 
   */
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
	
}
