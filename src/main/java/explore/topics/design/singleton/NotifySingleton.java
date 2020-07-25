package explore.topics.design.singleton;

public class NotifySingleton {
    private static NotifySingleton instance;

    private NotifySingleton() {}

    public static NotifySingleton getInstance() {
        if(null==instance) {
            synchronized (NotifySingleton.class) {
                if(null==instance) {
                    instance = new NotifySingleton();
                }
            }
        }
        return instance;
    }
}
