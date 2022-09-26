package sdesign.lb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class WeightRoundRobin implements LoadBalance {
    private static AtomicInteger position = new AtomicInteger(0);
    List<String> servers = new ArrayList<>();
    @Override
    public String getServer(String clientIp) {
        IpPool.ipMap.entrySet().stream()
                .filter(entry -> entry.getValue()>0)
                .forEach(server -> servers.add(server.getKey()));
        synchronized (position) {
            int andIncrement = position.getAndIncrement();
            if(andIncrement > servers.size()) {
                position.set(0);
            }
            return servers.get(andIncrement%servers.size());
        }
    }
}
