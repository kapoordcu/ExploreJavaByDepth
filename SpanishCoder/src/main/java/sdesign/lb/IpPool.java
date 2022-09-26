package sdesign.lb;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IpPool {
    public static Map<String, Integer> ipMap = new ConcurrentHashMap<>();

    static {
        ipMap.put("192.168.1.0", 10);
        ipMap.put("192.168.1.1", 10);
        ipMap.put("192.168.1.2", 10);
        ipMap.put("192.168.1.3", 10);
        ipMap.put("192.168.1.4", 10);
        ipMap.put("192.168.1.5", 10);
        ipMap.put("192.168.1.6", 10);
        ipMap.put("192.168.1.7", 10);
        ipMap.put("192.168.1.8", 10);
        ipMap.put("192.168.1.9", 10);
    }

    @Test
    public void test01() {
        doGetServer(new RoundRobin());
    }

    public void doGetServer(LoadBalance loadBalance) {
        doGetServer(loadBalance, 100);
    }

    private void doGetServer(LoadBalance loadBalance, int queryCount) {
        for (int i = 0; i < queryCount; i++) {
            String serverId = loadBalance.getServer(String.valueOf(i));
            System.out.println(String.format("[%s] index:%s,%s", loadBalance.getClass().getSimpleName(), i, serverId));
        }
    }
}
