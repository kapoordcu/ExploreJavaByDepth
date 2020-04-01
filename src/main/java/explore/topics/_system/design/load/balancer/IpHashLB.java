package explore.topics._system.design.load.balancer;

import java.util.Arrays;
import java.util.stream.Collectors;

public class IpHashLB implements LoadBalancer {
    @Override
    public String getServerAddress(String clientIp) {
        String hashIp = Arrays.stream(clientIp.split("\\."))
                .map(Integer::parseInt)
                .map(nibble -> String.format("%02X", nibble))
                .collect(Collectors.joining());

        return null;
    }

    //ip = 3232235778
    public static String longToString(long ip) {
        return ((ip>>24 & 0xFF) + "." +
                (ip>>16 & 0xFF) + "." +
                (ip>>8 & 0xFF) + "." +
                (ip & 0xFF));

    }

    public static Long stringToLong(String ipAddress) {
        String[] split = ipAddress.split("\\.");
        long result = 0;
        for (int i = 3; i >= 0; i--) {
            long ip = Long.parseLong(split[3-i]);
            result |= ip << i*8;
        }
        return result;
    }

    public static void main(String[] args) {
        Long longForm = IpHashLB.stringToLong("254.254.254.254");
        System.out.println(IpHashLB.longToString(longForm));
    }
}
