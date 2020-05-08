package Transport4Future.TokenManagement.Utils;

public class SHA256Hash extends GenericHasher implements IHash {
    @Override
    public String hash(String input) throws TokenManagementException {
        return this.generateHash(input, "SHA-256");
    }
}
