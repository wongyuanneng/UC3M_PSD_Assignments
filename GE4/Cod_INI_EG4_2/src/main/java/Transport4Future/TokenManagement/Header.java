package Transport4Future.TokenManagement;

public class Header {
    private static Header h = null;
    
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

    /**
     * Header instantiation for Singleton implementation
     *
     * 
     */
    public static Header getHeaderInstance(String alg, String typ) {
        if (h == null) {
            h = new Header(alg, typ);
        } else {
            System.out.println("Cannot create object (" + alg + ", " + typ + ") because an object of class Header already exists");
        }
        return h;
    }

    /**
     * Get value of header from token parameters
     *
     * @throws TokenManagementException if any error occurs
     */
    public String toString() {
        return "Alg=" + this.alg + "\\n Typ=" + this.typ + "\\n";
    }

}
