package explore.topics._system.design.load.balancer;

public interface LoadBalancer {
    String getServerAddress(String clientIp);
}
