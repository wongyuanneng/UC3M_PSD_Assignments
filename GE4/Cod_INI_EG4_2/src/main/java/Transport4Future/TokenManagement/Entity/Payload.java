package Transport4Future.TokenManagement.Entity;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Transport4Future.TokenManagement.Boundary.TokenManagementException;


public class Payload {
    private String device;
    private long iat;
    private long exp;

    /**
     * Payload constructor
     *
     * 
     */
    public Payload(String device) {
        this.device = device;
        this.iat = 1584523340892l;
        if ((this.device.startsWith("4"))){
            this.exp = this.iat + 604800000l;
        }
        else {
            this.exp = this.iat + 60480000000l;
        }
        //this.iat = System.currentTimeMillis();
    }
    
    public String getDevice() {
        return device;
    }

    public long getIat() {
        return iat;
    }

    public long getExp() {
        return exp;
    }
    
    /**
     * Checks if token is granted
     *
     * @throws TokenManagementException if any error occurs
     */
    public boolean isGranted () {
        if (this.iat < System.currentTimeMillis()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Checks if token is expired
     *
     * @throws TokenManagementException if any error occurs
     */
    public boolean isExpired () {
        if (this.exp > System.currentTimeMillis()) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Get value of payload from token parameters
     *
     * @throws TokenManagementException if any error occurs
     */
    public String toString () {
        Date iatDate = new Date(this.iat);
        Date expDate = new Date(this.exp);

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        return	"Dev=" + this.device 
                + "\\n iat=" + df.format(iatDate)
                + "\\n exp=" + df.format(expDate);
    }


}
