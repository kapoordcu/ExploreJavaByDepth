package explore.topics._system.design.load.balancer;

import java.util.concurrent.atomic.AtomicLong;

public class Server {
    private String ip;
    private Integer weight;
    private AtomicLong requestServed;

    public Server(String ip, Integer weight) {
        this.ip = ip;
        this.weight = weight;
        this.requestServed = new AtomicLong();
    }

    public String getIp() {
        return ip;
    }

    public Integer getWeight() {
        return weight;
    }

    public AtomicLong getRequestServed() {
        return requestServed;
    }
}
