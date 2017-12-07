package ph.gov.deped.security;

import org.springframework.beans.factory.annotation.Autowired;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * Created by ej on 8/20/14.
 */
public class SecurityUtil {

    private @Autowired SecureRandom secureRandom;

    public String generateRandomString() {
        String randomNum = new Integer(secureRandom.nextInt()).toString();
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException ex) {
            throw new SecurityException(ex);
        }
        byte[] result = md5.digest(randomNum.getBytes());
        return new String(Base64.getEncoder().encode(result));
    }
}
