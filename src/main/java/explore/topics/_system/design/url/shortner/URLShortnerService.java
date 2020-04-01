package explore.topics._system.design.url.shortner;

public class URLShortnerService {
    private URLMapping urlSave = new URLMapping();
    private HashingStrategy strategy = new Base64Strategy();

    public String shortenedURL(String url) {
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
