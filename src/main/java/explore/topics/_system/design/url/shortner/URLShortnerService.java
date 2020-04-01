package explore.topics._system.design.url.shortner;

public class URLShortnerService {
    private URLMapping urlSave = new URLMapping();

    public String shortenedURL(String url) {
        String shortUrl = urlSave.getShortUrl(url);
        if(shortUrl==null) {
            shortUrl = IDUtils.generateShortenedURL(url);
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

    public static void main(String[] args) {
        URLShortnerService service = new URLShortnerService();
        System.out.println(service.shortenedURL("www.google.com?jsjkokaso"));
        System.out.println(service.shortenedURL("www.google.com?jsjkokasso"));
        System.out.println(service.shortenedURL("www.google.com?jsjsokaso"));
        System.out.println(service.shortenedURL("www.google.com?jsjdokaso"));
        System.out.println(service.shortenedURL("www.google.com?jsjkokaso"));

    }
}
