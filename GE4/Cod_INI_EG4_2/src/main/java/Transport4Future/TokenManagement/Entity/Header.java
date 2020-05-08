package Transport4Future.TokenManagement.Entity;

import Transport4Future.TokenManagement.Utils.TokenManagementException;

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

    /**
     * Get value of header from token parameters
     *
     * @throws TokenManagementException if any error occurs
     */
    public String toString() {
        return "Alg=" + this.alg + "\\n Typ=" + this.typ + "\\n";
    }

}
