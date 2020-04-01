package explore.topics._system.design.url.shortner;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Strategy implements HashingStrategy {
    @Override
    public String generateShortenedURL(String url) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        BigInteger bi = new BigInteger(1, md.digest(url.getBytes()));
        return bi.toString(16);
    }
}
