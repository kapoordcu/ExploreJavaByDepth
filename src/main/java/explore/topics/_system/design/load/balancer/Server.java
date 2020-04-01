package explore.topics._system.design.load.balancer;

public class Server {
    private String ip;
    private Integer weight;

    public Server(String ip, Integer weight) {
        this.ip = ip;
        this.weight = weight;
    }

    public String getIp() {
        return ip;
    }

    public Integer getWeight() {
        return weight;
    }
}
