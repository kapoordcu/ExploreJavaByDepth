package explore.topics._system.design;

import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

public class URLShortener {

    public static void main(String[] args) {
        URLShortener url = new URLShortener();
        url.createTinyURL();
    }

    public String createTinyURL() {
        System.out.println(new Date());
        System.out.println(UUID.randomUUID().toString());
        return null;
    }

    public static String base62(Integer decimal) {
        char[] s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String hash_str = "";
        while (decimal>0) {
            hash_str = s[decimal%62] + hash_str;
            decimal /= 62;
        }
        return hash_str;
    }
}
