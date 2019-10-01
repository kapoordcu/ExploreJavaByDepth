package explore.topics.design.aStrategy;

public class StrategyApp {
    public static void main(String[] args) {
        DevContext ctx1 = new DevContext();
        //we could assume context is already set by preferences
        ctx1.setType(new FrontEnd());
        ctx1.startApp();

        ctx1.setType(new BackEnd());
        ctx1.startApp();

    }
}

class DevContext {
    private Development type;

    //this can be set at runtime by the application preferences
    public void setType(Development type) {
        this.type = type;
    }

    //use the strategy
    public void startApp() {
        type.developApplication();
    }
}

//•	Capture the abstraction in an interface, bury implementation details in derived classes.
//Strategy Interface
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