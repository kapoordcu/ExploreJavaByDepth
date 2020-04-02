package explore.topics._system.design.url.shortner;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class URLShortnerServiceTest {
    public static  String URL1 = "https://www.youtube.com/watch?v=N3gQdIn90CI";
    public static  String URL1_COPY = "https://www.youtube.com/watch?v=N3gQdIn90CI";
    public static  String URL3 = "https://www.youtube.com/watch?v=N3gQdIn9ddd0CI";
    public static  String SHORT_URL = "";

    @Test
    public void checkURLBase62() throws InterruptedException, NoSuchAlgorithmException {
        URLShortnerService service = new URLShortnerService(new Base64Strategy());
        String generatedURL1 = service.shortenedURL(URLShortnerServiceTest.URL1);
        String generatedURL2 = service.shortenedURL(URLShortnerServiceTest.URL1_COPY);
        String generatedURL3 = service.shortenedURL(URLShortnerServiceTest.URL3);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new ShortURLTAsk(service));
        }

        for (Thread t: threads) {
            t.start();
        }
        for (Thread t: threads) {
            t.join();
        }
        assertTrue(SHORT_URL.equalsIgnoreCase(generatedURL1));
        assertTrue(generatedURL2.equalsIgnoreCase(generatedURL1));
        assertFalse(generatedURL3.equalsIgnoreCase(generatedURL1));
    }

    @Test
    public void encodeAndDecodeURL() throws NoSuchAlgorithmException {
        URLShortnerService service = new URLShortnerService(new Base64Strategy());
        String generatedURL1 = service.shortenedURL(URL1);
        String origin = service.originalURL(generatedURL1);
        assertTrue(URL1.equalsIgnoreCase(origin));
    }

    @Test
    public void checkURLMD5() throws InterruptedException, NoSuchAlgorithmException {
        URLShortnerService service = new URLShortnerService(new Md5Strategy());
        String generatedURL1 = service.shortenedURL(URL1);
        String generatedURL2 = service.shortenedURL(URL1_COPY);
        String generatedURL3 = service.shortenedURL(URL3);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new ShortURLTAsk(service));
        }

        for (Thread t: threads) {
            t.start();
        }
        for (Thread t: threads) {
            t.join();
        }
        assertTrue(SHORT_URL.equalsIgnoreCase(generatedURL1));
        assertTrue(generatedURL2.equalsIgnoreCase(generatedURL1));
        assertFalse(generatedURL3.equalsIgnoreCase(generatedURL1));
    }
}

class ShortURLTAsk implements Runnable {
    private URLShortnerService service;

    public ShortURLTAsk(URLShortnerService service) {
        this.service = service;
    }

    @Override
    public void run() {
        try {
            URLShortnerServiceTest.SHORT_URL  = service.shortenedURL(URLShortnerServiceTest.URL1);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}