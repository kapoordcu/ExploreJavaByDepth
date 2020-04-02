package explore.topics._system.design.url.shortner;

import java.security.NoSuchAlgorithmException;

public class CounterStrategy implements HashingStrategy {

    @Override
    public String generateShortenedURL(String url) throws NoSuchAlgorithmException {
        Long requestId = URLMapping.serveNextRequest();
        String hash = base(requestId);
        return "www.goo.gl/" + hash;
    }

    public static String base(Long seed) {
        char[] s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String hashValue = "";
        while (seed>0) {
            hashValue = s[seed.intValue()%62] + hashValue;
            seed /= 62;
        }
        return hashValue;
    }
}
