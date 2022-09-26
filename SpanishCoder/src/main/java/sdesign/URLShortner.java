package sdesign;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class URLShortner {
    private String hostname = "http://mytiny.url/";
    String base62Str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char[] base62 = base62Str.toCharArray();
    private URLCache urlCache = new URLCache();

    @Test
    public void test1000() throws InterruptedException {
        Set<String> urlsGenerated = new HashSet<>();
        String longURL = "http://randomjsajhkjkdoaskd/jijdj";
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        executorService.submit(() -> {
            urlsGenerated.add(createShortURL(longURL));
        });
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        executorService.shutdown();
        assertTrue(urlsGenerated.size()==1);
    }

    @Test
    public void test0() {
        String longURL = null;
        String shortURL1 = createShortURL(longURL);
        assertTrue(shortURL1==null);
    }

    @Test
    public void test1() {
        String longURL = "http://randomjsajhkjkdoaskd/jijdj";
        String shortURL1 = createShortURL(longURL);
        String shortURL2 = createShortURL(longURL);
        assertTrue(shortURL1.equals(shortURL2));
    }

    @Test
    public void test2() {
        String longURL = "http://randomjsajhkjkdoaskd/jijdj";
        String shortURL1 = createShortURL(longURL);
        String expected = retrieveLongURL(shortURL1);
        assertTrue(longURL.equals(expected));
    }

    private String createShortURL(String longURL) {
        if(longURL == null || longURL.length()==0) {
            return null;
        }
        String shortUrl = urlCache.findIfExists(longURL);
        if(shortUrl != null) {
            return shortUrl;
        }
        long keyLong = CounterService.generateUniqueKey();
        return convertToBase62AndSaveInCache(longURL, keyLong);
    }

    private String convertToBase62AndSaveInCache(String longURL, long key) {
        String shortURL = hostname + base62(key);
        urlCache.insertIntoCache(longURL, shortURL);
        return shortURL;
    }

    private String base62(Long key) {
        String hash = "";
        while (key >0) {
            hash = base62[key.intValue()%62] + hash;
            key /= 62;
        }
        return hash;
    }

    private String retrieveLongURL(String shortURL) {
        return urlCache.fetchLongURL(shortURL);
    }
}
