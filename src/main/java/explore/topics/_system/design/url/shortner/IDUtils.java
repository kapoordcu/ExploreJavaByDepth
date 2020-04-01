package explore.topics._system.design.url.shortner;

import java.util.Random;

public class IDUtils {
    private static Random random = new Random();

    public static String generateShortenedURL(String url) {
        int seed = random.nextInt(Integer.MAX_VALUE);
        String hash = base62(seed);
        return "www.goo.gl/" + hash;
    }

    public static String base62(Integer seed) {
        char[] s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String hashValue = "";
        while (seed>0) {
            hashValue = s[seed%62] + hashValue;
            seed /= 62;
        }
        return hashValue;
    }
}
