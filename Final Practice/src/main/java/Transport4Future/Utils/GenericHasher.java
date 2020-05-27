package Transport4Future.Utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Transport4Future.TokenManagement.Exceptions.TokenManagementException;

public abstract class GenericHasher implements IHash {

    protected String algorithm;
    protected String format;

    public GenericHasher() {
        super();
    }
    
    /**
     * Hashes an input string according to the specified algorithm (MD5/SHA-256).
     *
     * @throws TokenManagementException if any error occurs
     */
    public String hash(String input) throws TokenManagementException {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new TokenManagementException("Error: no such hashing algorithm.");
        }

        md.update(input.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();

        // Beware the hex length. If MD5 -> 32:"%032x", but for instance, in SHA-256 it
        // should be "%064x"
        String hex = String.format(format, new BigInteger(1, digest));
        return hex;
    }

}