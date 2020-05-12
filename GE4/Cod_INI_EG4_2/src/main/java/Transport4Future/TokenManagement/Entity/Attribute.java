package Transport4Future.TokenManagement.Entity;

import java.util.regex.Pattern;

import Transport4Future.TokenManagement.Utils.TokenManagementException;

public class Attribute {
    private String pattern;
    private String errorOutput;
    private String data;
    
    /**
     * Attribute constructor
     * 
     *
     * 
     */
    public Attribute(String pattern, String errorOutput, String data) {
        this.pattern = pattern;
        this.errorOutput = errorOutput;
        this.data = data;
    }
    
    
    
    public String getPattern() {
        return pattern;
    }



    public String getErrorOutput() {
        return errorOutput;
    }



    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Attribute [data=" + data + "]";
    }

    /**
     * Checks pattern of an attribute
     *
     * @throws TokenManagementException if any error occurs
     */
    public void attributePatternCheck() throws TokenManagementException {
        Pattern p = Pattern.compile(this.pattern);
        if  (!p.matcher(this.data).matches()) {
            throw new TokenManagementException(this.errorOutput);  
        }
    }
    
    /**
     * Checks length of an attribute
     *
     * @throws TokenManagementException if any error occurs
     */
    public void attributeLengthCheck(int min, int max) throws TokenManagementException {
        if ((this.data.length() < min) || (this.data.length() > max)) {
            throw new TokenManagementException(this.errorOutput); 
        }
    }
}
