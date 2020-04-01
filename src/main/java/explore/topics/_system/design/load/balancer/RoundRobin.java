package explore.topics._system.design.load.balancer;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobin implements LoadBalancer {
    public static AtomicInteger slot = new AtomicInteger();

    @Override
    public String getServerAddress(String clientIp) {
        List<Server> serverList = ServerDiscovery.serverList;
        Server server = serverList.get(slot.getAndIncrement()%serverList.size());
        return server.getIp();
    }

    public static void main(String[] args) {
        RoundRobin roundRobin = new RoundRobin();
        for (int i = 0; i < 100; i++) {
            System.out.println(roundRobin.getServerAddress(""));
        }
    }
}
