package explore.topics.design.aStrategy;

public class StrategyApp {
    public static void main(String[] args) {
        DevContext ctx1 = new DevContext(new FrontEnd());
        ctx1.startApp();

        ctx1 = new DevContext(new BackEnd());
        ctx1.startApp();

    }
}

class DevContext {
    private final Development type;

    public DevContext(Development type) {
        this.type = type;
    }

    public void startApp() {
        type.developApplication();
    }
}

//•	Capture the abstraction in an interface, bury implementation details in derived classes.
interface Development {
    void developApplication();
}

class FrontEnd implements Development {
    @Override
    public void developApplication() {
        System.out.println("React application started.");
    }
}

class BackEnd implements Development {
    @Override
    public void developApplication() {
        System.out.println("Java application started.");
    }
}