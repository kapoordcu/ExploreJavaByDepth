package explore.topics._system.design.url.shortner;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
public class URLShortnerServiceTest {
    public static  String URL1 = "www.google.com?jsjkokaso";
    public static  String URL2 = "www.google.com?dskhdajdojnksj";
    public static  String URL3 = "www.google.com?iwjiejiwnkjsnkd";
    public static  String URL4 = "www.google.com?jsjkokaso";
    public static  String SHORT_URL = "";

    private URLShortnerService service = new URLShortnerService();

    @Test
    public void checkURL() throws InterruptedException {
        String generatedURL = service.shortenedURL(URLShortnerServiceTest.URL1);

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

        assertTrue(SHORT_URL.equalsIgnoreCase(generatedURL));
    }

}

class ShortURLTAsk implements Runnable {
    private URLShortnerService service;

    public ShortURLTAsk(URLShortnerService service) {
        this.service = service;
    }

    @Override
    public void run() {
        URLShortnerServiceTest.SHORT_URL  = service.shortenedURL(URLShortnerServiceTest.URL1);
    }
}