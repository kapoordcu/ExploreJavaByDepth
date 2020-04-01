package explore.topics._system.design.url.shortner;

public class HashContext {
    private HashingStrategy strategy;

    public void setStrategy(HashingStrategy strategy) {
        this.strategy = strategy;
    }

    public String hash(String url) {
        return strategy.generateShortenedURL(url);
    }
}
