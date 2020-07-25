package explore.topics.design.aBuilder;

public class NotificationBuilder {
    private String deviceId;
    private String deviceType;
    private String deviceMake;

    public NotificationBuilder withDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public NotificationBuilder withDeviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public NotificationBuilder withDeviceMake(String deviceMake) {
        this.deviceMake = deviceMake;
        return this;
    }

    public Notification build() {
        return new Notification(deviceId, deviceType, deviceMake);
    }
}
