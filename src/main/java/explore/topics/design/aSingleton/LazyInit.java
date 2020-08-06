package explore.topics.design.aSingleton;

public class LazyInit {
    public static void main(String[] args) {
        System.out.println(SingletonClass.getLazyInstance().hashCode());
        System.out.println(SingletonBillPugh.getBillPughInstance());
        System.out.println(SingletonEager.getEagerInstance());
        System.out.println(SingletonLikeENUM.INSTANCE);


    }
}

class SingletonClass { // The class is not instantiated when its loaded in the memory
    private static SingletonClass INSTANCE;
    private SingletonClass() {};

    public static synchronized SingletonClass getLazyInstance() { // Downside synchronized method
        if(INSTANCE==null) {
            INSTANCE = new SingletonClass();
        }
        return INSTANCE;
    }
}


class SingletonBillPugh {
    private SingletonBillPugh() {};
    public static class SingletonHolder { // Most commonly used singleton pattern in java
        private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
    }

    public static SingletonBillPugh getBillPughInstance() {
        return SingletonHolder.INSTANCE;
    }
}


class SingletonEager {  // In effect Lazy
    private static final SingletonEager INSTANCE = new SingletonEager(); // When containing class is loaded, semantic of java m, the class is only loaded when reference for the first time
    private SingletonEager() {};

    public static SingletonEager getEagerInstance() {
        return INSTANCE;
    }
}

class SingletonLikeENUM {  // internal structure like ENUM
    public static final SingletonLikeENUM INSTANCE = new SingletonLikeENUM();
    private SingletonLikeENUM() {};

}