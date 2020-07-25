package explore.topics.design.aBuilder;

import java.util.UUID;

public class NotificationBuilderApp {
    public static void main(String[] args) {
        Notification build = new NotificationBuilder()
                .withDeviceMake("7928i9jii")
                .withDeviceType("iOS")
                .withDeviceId(UUID.randomUUID().toString())
                .build();

    }
}
