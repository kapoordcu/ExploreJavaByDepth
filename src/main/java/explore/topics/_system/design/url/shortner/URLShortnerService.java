package explore.topics._system.design.url.shortner;

import java.security.NoSuchAlgorithmException;

public class URLShortnerService {
    private URLMapping urlSave = new URLMapping();
    private HashingStrategy strategy;

    public URLShortnerService(HashingStrategy strategy) {
        this.strategy = strategy;
    }

    public String shortenedURL(String url) throws NoSuchAlgorithmException {
        String shortUrl = urlSave.getShortUrl(url);
        if(shortUrl==null) {
            shortUrl = strategy.generateShortenedURL(url);
            urlSave.insert(url, shortUrl);
        }
        return shortUrl;
    }

    public String originalURL(String shortUrl) {
        return urlSave.urlMappings.values()
                .stream()
                .filter(e -> e.equals(shortUrl))
                .findFirst()
                .orElse(null);
    }
}
