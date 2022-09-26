package sdesign.lb;

public interface LoadBalance {
    String getServer(String clientIp);
}