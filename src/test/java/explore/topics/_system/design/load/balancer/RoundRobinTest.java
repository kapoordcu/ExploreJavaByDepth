package explore.topics._system.design.load.balancer;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class RoundRobinTest {
    private static Integer REQUEST_COUNT = 5;
    private static Integer THREAD_COUNT = 8;
    private static long AWAIT_TERMINATION = 2000;
    private RoundRobin roundRobin = new RoundRobin();
    
    @Test
    public void setup() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i = 0; i < REQUEST_COUNT; i++) {
            threadPool.submit(new RRtask(roundRobin));
        }
        threadPool.awaitTermination(AWAIT_TERMINATION, TimeUnit.MILLISECONDS);
        assertTrue(roundRobin.slot==REQUEST_COUNT%ServerDiscovery.map.size());
    }
}

class RRtask  implements Runnable {
    private RoundRobin roundRobin;

    public RRtask(RoundRobin roundRobin) {
        this.roundRobin = roundRobin;
    }

    @Override
    public void run() {
        roundRobin.getServerAddress("");
    }
}