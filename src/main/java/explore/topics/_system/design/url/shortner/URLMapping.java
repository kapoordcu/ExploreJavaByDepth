package explore.topics._system.design.url.shortner;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class URLMapping {
    private static AtomicLong counter = new AtomicLong();

    public Map<String, String> urlMappings = new ConcurrentHashMap<>();

    public void insert(String url, String shortUrl) {
        urlMappings.putIfAbsent(url, shortUrl);
    }

    public String getShortUrl(String url) {
        return urlMappings.getOrDefault(url, null);
    }

    public static Long serveNextRequest() {
        return counter.incrementAndGet();
    }

    public static void resetCounter() {
        counter.set(0);
    }
}
