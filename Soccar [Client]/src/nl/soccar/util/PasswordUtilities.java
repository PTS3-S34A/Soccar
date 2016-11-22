package nl.soccar.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utilities class for password authentication that provides a method for
 * hashing a password.
 *
 * @author PTS34A
 */
public class PasswordUtilities {

    /**
     * Constructor that is intentionally marked private so a PasswordUtilities
     * object can never be initiated outside this class.
     */
    private PasswordUtilities() {
    }

    public static byte[] generateHash(String password) {
        byte[] hash = new byte[64];

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes());
            hash = md.digest();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }

        return hash;
    }

}
