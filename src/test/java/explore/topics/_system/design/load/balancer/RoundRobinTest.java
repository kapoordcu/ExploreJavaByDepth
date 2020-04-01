package explore.topics._system.design.load.balancer;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class RoundRobinTest {
    private static Integer REQUEST_COUNT = 114;
    private static Integer THREAD_COUNT = 8;
    private static long AWAIT_TERMINATION = 2000;
    public static String EXPECTED_LAST_SERVER = "";
    private RoundRobin roundRobin = new RoundRobin();

    @Test
    public void setup() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i = 0; i < REQUEST_COUNT; i++) {
            threadPool.submit(new RRtask(roundRobin));
        }
        threadPool.awaitTermination(AWAIT_TERMINATION, TimeUnit.MILLISECONDS);
        List<Server> serverList = ServerDiscovery.serverList;
        assertEquals(serverList.get((REQUEST_COUNT-1) % serverList.size()).getIp(), EXPECTED_LAST_SERVER);
    }
}

class RRtask  implements Runnable {
    private RoundRobin roundRobin;

    public RRtask(RoundRobin roundRobin) {
        this.roundRobin = roundRobin;
    }

    @Override
    public void run() {
        RoundRobinTest.EXPECTED_LAST_SERVER = roundRobin.getServerAddress("");
    }
}