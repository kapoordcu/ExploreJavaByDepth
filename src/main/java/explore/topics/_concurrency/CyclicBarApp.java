package explore.topics._concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarApp {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        threadPool.submit(new CBTask(cyclicBarrier));
        threadPool.submit(new CBTask(cyclicBarrier));
        threadPool.submit(new CBTask(cyclicBarrier));
        Thread.sleep(2000);

    }
}

class CBTask implements Runnable {
    private CyclicBarrier cyclicBarrier;

    public CBTask(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        while (true) { // we want to run it repeatedly
            try {
                cyclicBarrier.await();
                // all 3 tasks running on 3 different threads calls this
                // could take different times to reach this point
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            // Send message to users
        }
    }
}