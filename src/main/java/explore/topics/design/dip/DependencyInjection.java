package explore.topics.design.dip;

// Proximity to Dependency Inversion Principle
public class DependencyInjection {
    public static void main(String[] args) {
        MessageServiceInjector injector = null;
        MyDIApplication app = null;

        //Send email
        injector = new EmailServiceInjector();
        app = injector.getMyDIApplication();
        app.processMessages();

        //Send SMS
        injector = new SMSServiceInjector();
        app = injector.getMyDIApplication();
        app.processMessages();
    }
}

//Java Dependency Injection – Service Components

interface MessageService {
    void sendMessage();
}

class EmailServiceImpl implements MessageService {
    public void sendMessage() {
        System.out.println("Message sent from Email");
    }
}

class SMSServiceImpl implements MessageService {
    public void sendMessage() {
        System.out.println("Message sent from SMS");
    }
}

// Java Dependency Injection – Service Consumer
class MyDIApplication {
    private MessageService messageService;
    public MyDIApplication(MessageService messageService) {
        this.messageService = messageService;
    }
    public void processMessages() {
        messageService.sendMessage();
    }
}

// Java Dependency Injection – Injectors Classes
interface MessageServiceInjector {
    MyDIApplication getMyDIApplication();
}

class EmailServiceInjector implements MessageServiceInjector {

    @Override
    public MyDIApplication getMyDIApplication() {
        return new MyDIApplication(new EmailServiceImpl());
    }

}

class SMSServiceInjector implements MessageServiceInjector {

    @Override
    public MyDIApplication getMyDIApplication() {
        return new MyDIApplication(new SMSServiceImpl());
    }

}