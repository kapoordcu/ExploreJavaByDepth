package explore.topics._system.design.load.balancer;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class WeightedRandomLB implements LoadBalancer {
    @Override
    public String getServerAddress(String clientIp) {
        List<Server> allServers = new LinkedList<>();
        ServerDiscovery.serverList.stream()
                .forEach(server -> {
                    for (int i = 0; i < server.getWeight(); i++) {
                        allServers.add(server);
                    }
                });

        return allServers.get(new Random().nextInt(allServers.size())).getIp();
    }

}
