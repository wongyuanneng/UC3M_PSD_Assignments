package Transport4Future.TokenManagement.Utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GenericHasher implements IHash{
    private String algo;
    
    /**
     * Insert parameters to do hashing.
     *
     * @throws TokenManagementException if any error occurs
     */
    public String hash(String input) throws TokenManagementException {
        return this.generateHash(input, algo);
    }
    
    /**
     * Hashes an input string according to the specified algorithm (MD5/SHA-256).
     *
     * @throws TokenManagementException if any error occurs
     */
    protected String generateHash(String input, String algo) throws TokenManagementException {
        MessageDigest md = getHashAlgo(algo);

        md.update(input.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();

        String hex = null;
        // Beware the hex length. If MD5 -> 32:"%032x", but for instance, in SHA-256 it should be "%064x" 
        //md.getDigestLength() is in number of Bytes, and since required int is number of Hex-digits, thus multiply by 2.
        hex = String.format("%"+md.getDigestLength()*2+"x", new BigInteger(1, digest));
        return hex;
    }

    private MessageDigest getHashAlgo(String algo) throws TokenManagementException {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algo);
        } catch (NoSuchAlgorithmException e) {
            throw new TokenManagementException("Error: no such hashing algorithm.");
        }
        return md;
    }
}
