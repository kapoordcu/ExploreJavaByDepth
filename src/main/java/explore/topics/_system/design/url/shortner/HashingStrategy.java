package explore.topics._system.design.url.shortner;

public interface HashingStrategy {
    String generateShortenedURL(String url);
}
