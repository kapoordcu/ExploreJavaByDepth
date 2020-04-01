package explore.topics._system.design.load.balancer;

import java.util.ArrayList;
import java.util.List;

public class RoundRobin implements LoadBalancer {
    public static Integer slot = 0;

    @Override
    public String getServerAddress(String clientIp) {
        List<String> ipList = new ArrayList<>(ServerDiscovery.map.values());
        synchronized (slot) {
            if(slot>ipList.size()-1) {
                slot = 0;
            }
            return ipList.get(slot++);
        }
    }
}
