package explore.topics._concurrency.scatterpattern;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Scatter {
    ExecutorService threadPool = Executors.newFixedThreadPool(4);

    private Set<Integer> getPrices(int prodId) throws InterruptedException {
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());
        CountDownLatch latch = new CountDownLatch(3);
        // we have 3 tasks, give the latch to all the 3 tasks
        threadPool.submit(new PriceGatherTask("url1", prodId, prices, latch));
        threadPool.submit(new PriceGatherTask("url2", prodId, prices, latch));
        threadPool.submit(new PriceGatherTask("url3", prodId, prices, latch));
        latch.await(3, TimeUnit.SECONDS); //wait for every task to count down = 0
        return prices; // will wait  even if all prices have arrived
    }

    private Set<Integer> getPricesCompletableFuture(int prodId) throws InterruptedException, TimeoutException, ExecutionException {
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());


        CompletableFuture<Void> task1 = CompletableFuture
                .runAsync(new PriceGatherTask("url1", prodId, prices));
        CompletableFuture<Void> task2 = CompletableFuture
                .runAsync(new PriceGatherTask("url2", prodId, prices));
        CompletableFuture<Void> task3 = CompletableFuture
                .runAsync(new PriceGatherTask("url3", prodId, prices));
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);

        allTasks.get(3, TimeUnit.SECONDS);
        return prices; // will wait  even if all prices have arrived
    }
}

class PriceGatherTask implements Runnable {
    private String websiteUrl;
    private int prodId;
    private Set<Integer> prices;
    private CountDownLatch latch;

    public PriceGatherTask(String websiteUrl, int prodId,
                           Set<Integer> prices, CountDownLatch latch) {
        this.websiteUrl = websiteUrl;
        this.prodId = prodId;
        this.prices = prices;
        this.latch = latch;
    }

    public PriceGatherTask(String websiteUrl, int prodId,
                           Set<Integer> prices) {
        this.websiteUrl = websiteUrl;
        this.prodId = prodId;
        this.prices = prices;
    }

    @Override
    public void run() {
        int price = 0;
        // http call returns price
        prices.add(new Random().nextInt(100));
        latch.countDown(); //Add price and latch down, I am done
    }
}