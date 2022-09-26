package sdesign.lb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RoundRobin implements LoadBalance{
    private static AtomicInteger position = new AtomicInteger(0);

    @Override
    public String getServer(String clientIp) {
        List<String> servers = IpPool.ipMap.keySet().stream().sorted().collect(Collectors.toList());
        synchronized (position) {
            int andIncrement = position.getAndIncrement();
            if(andIncrement > servers.size()-1) {
                position.set(0);
                andIncrement = 0;
            }
            return servers.get(andIncrement);
        }
    }
}
