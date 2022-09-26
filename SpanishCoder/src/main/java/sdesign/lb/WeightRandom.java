package sdesign.lb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class WeightRandom implements LoadBalance{
    List<String> servers = new ArrayList<>();
    private Random r = new Random();
    @Override
    public String getServer(String clientIp) {
        IpPool.ipMap.entrySet().stream()
                .filter(entry -> entry.getValue()>0)
                .forEach(server -> servers.add(server.getKey()));
        int serverNumber = r.nextInt(servers.size());
        return servers.get(serverNumber);
    }
}
