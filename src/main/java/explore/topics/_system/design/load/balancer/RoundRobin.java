package explore.topics._system.design.load.balancer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobin implements LoadBalancer {
    public static AtomicInteger slot = new AtomicInteger();

    @Override
    public String getServerAddress(String clientIp) {
        List<String> ipList = new ArrayList<>(ServerDiscovery.map.values());
//        synchronized (slot) {
//            if(slot>ipList.size()-1) {
//                slot = 0;
//            }
//            return ipList.get(slot++);
//        }
        return ipList.get(slot.getAndIncrement() % ServerDiscovery.map.size());
    }
}
