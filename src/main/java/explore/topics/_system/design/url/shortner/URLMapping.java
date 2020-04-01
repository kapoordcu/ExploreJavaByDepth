package explore.topics._system.design.url.shortner;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class URLMapping {
    public Map<String, String> urlMappings = new ConcurrentHashMap<>();

    public void insert(String url, String shortUrl) {
        urlMappings.putIfAbsent(url, shortUrl);
    }

    public String getShortUrl(String url) {
        return urlMappings.getOrDefault(url, null);
    }
}
