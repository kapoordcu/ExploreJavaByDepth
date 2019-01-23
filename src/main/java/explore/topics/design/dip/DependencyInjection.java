package explore.topics.design.dip;

public class DependencyInjection {
    public static void main(String[] args) {
        MessageServiceInjector injector = null;
        Consumer app = null;

        //Send email
        injector = new EmailServiceInjector();
        app = injector.getConsumer();
        app.processMessages();

        //Send SMS
        injector = new SMSServiceInjector();
        app = injector.getConsumer();
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
interface Consumer {
    void processMessages();
}

class MyDIApplication implements Consumer {
    private MessageService messageService;

    public MyDIApplication(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void processMessages() {
        messageService.sendMessage();
    }
}

// Java Dependency Injection – Injectors Classes
interface MessageServiceInjector {
    Consumer getConsumer();
}

class EmailServiceInjector implements MessageServiceInjector {

    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new EmailServiceImpl());
    }

}

class SMSServiceInjector implements MessageServiceInjector {

    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new SMSServiceImpl());
    }

}