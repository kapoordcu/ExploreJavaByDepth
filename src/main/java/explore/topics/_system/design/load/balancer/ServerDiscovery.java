package explore.topics._system.design.load.balancer;

import java.util.concurrent.ConcurrentHashMap;

public class ServerDiscovery {
    public static ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
    static {
        map.putIfAbsent(1, "192.168.0.1");
        map.putIfAbsent(2, "192.168.0.2");
        map.putIfAbsent(3, "192.168.0.3");
        map.putIfAbsent(4, "192.168.0.4");
        map.putIfAbsent(5, "192.168.0.5");
        map.putIfAbsent(6, "192.168.0.6");
    }
}
