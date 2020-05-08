package Transport4Future.TokenManagement.Entity;

public class Token {
    private Header header;
    private Payload payload;
    private String signature;
    private String requestDate;
    private String notificationEmail;
    private String tokenValue;

    /**
     * Token constructor
     *
     * 
     */
    public Token (String device, String requestDate, String notificationEmail) {
        this.header = new Header();
        this.payload = new Payload(device);
        this.requestDate = requestDate;
        this.notificationEmail = notificationEmail;

        // SOLO PARA PRUEBAS
        this.signature = null;
        this.tokenValue = null;
    }
    
    public String getRequestDate() {
        return requestDate;
    }

    public String getNotificationEmail() {
        return notificationEmail;
    }

    public Header getHeader() {
        return header;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setSignature(String value) {
        this.signature = value;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setTokenValue(String value) {
        this.tokenValue = value;
    }

    public String getTokenValue() {
        return this.tokenValue;
    }	
}
