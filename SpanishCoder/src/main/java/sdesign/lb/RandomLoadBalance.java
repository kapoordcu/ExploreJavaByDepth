package sdesign.lb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomLoadBalance implements LoadBalance {
    private Random r = new Random();
    List<String> servers = IpPool.ipMap.keySet().stream().sorted().collect(Collectors.toList());

    @Override
    public String getServer(String clientIp) {
        int serverNumber = r.nextInt(servers.size());
        return servers.get(serverNumber);
    }
}
