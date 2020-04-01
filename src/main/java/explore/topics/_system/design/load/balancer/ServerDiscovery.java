package explore.topics._system.design.load.balancer;

import java.util.LinkedList;
import java.util.List;

public class ServerDiscovery {
    public final static List<Server> serverList = new LinkedList<>();
    static {
        serverList.add(new Server("192.168.0.1", 1));
        serverList.add(new Server("192.168.0.2", 4));
        serverList.add(new Server("192.168.0.3", 2));
        serverList.add(new Server("192.168.0.4", 9));
        serverList.add(new Server("192.168.0.5", 2));
        serverList.add(new Server("192.168.0.6", 3));
        serverList.add(new Server("192.168.0.7", 1));
        serverList.add(new Server("192.168.0.8", 1));
        serverList.add(new Server("192.168.0.9", 1));
        serverList.add(new Server("192.168.0.10", 1));
    }
}
