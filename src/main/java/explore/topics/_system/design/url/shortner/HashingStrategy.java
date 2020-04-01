package explore.topics._system.design.url.shortner;

import java.security.NoSuchAlgorithmException;

public interface HashingStrategy {
    String generateShortenedURL(String url) throws NoSuchAlgorithmException;
}
