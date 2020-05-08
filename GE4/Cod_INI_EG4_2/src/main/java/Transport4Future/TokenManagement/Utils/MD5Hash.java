package Transport4Future.TokenManagement.Utils;

public class MD5Hash extends GenericHasher implements IHash{
    private String key;
    
    public MD5Hash(String key) {
        this.key = key;
    }
    
    @Override
    public String hash(String input) throws TokenManagementException {
        return this.generateHash(key+input, "MD5");
    }
}
