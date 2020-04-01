package explore.topics._system.design.url.shortner;

import java.security.NoSuchAlgorithmException;

public class HashContext {
    private HashingStrategy strategy;

    public void setStrategy(HashingStrategy strategy) {
        this.strategy = strategy;
    }

    public String hash(String url) throws NoSuchAlgorithmException {
        return strategy.generateShortenedURL(url);
    }
}
