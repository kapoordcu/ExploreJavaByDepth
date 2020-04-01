package explore.topics._system.design.load.balancer;

import org.junit.Test;

import java.util.List;
import static org.junit.Assert.assertEquals;

public class RoundRobinTest {
    private static Integer REQUEST_COUNT = 114;
    private static Integer THREAD_COUNT = 16;
    public static String EXPECTED_LAST_SERVER = "";
    private RoundRobin roundRobin = new RoundRobin();

    @Test
    public void fireRequestForRoundRobin() throws InterruptedException {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new RRtask(roundRobin));
        }
        for(Thread t: threads) {
            t.start();
        }
        for(Thread t: threads) {
            t.join();
        }

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