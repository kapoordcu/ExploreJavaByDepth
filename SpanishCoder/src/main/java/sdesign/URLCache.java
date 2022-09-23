package sdesign;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class URLCache {
    Map<String, String> urlCache = new ConcurrentHashMap<>();

    public String findIfExists(String longURL) {
        return urlCache.getOrDefault(longURL, null);
    }

    public synchronized void insertIntoCache(String longURL, String shortURL) {
        urlCache.putIfAbsent(longURL, shortURL);
    }

    public String fetchLongURL(String shortURL) {
        return urlCache.entrySet().stream()
                .filter(entry -> shortURL.equals(entry.getValue()))
                .map(Map.Entry::getKey).findFirst().orElse(null);
    }
}
