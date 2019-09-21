package explore.topics.design.aDip;

public class DIP_EmailExample {

}
//
//    Here Notification class has a dependency on Email class.
//    In this case, the notification creates an instance of the e-mail directly inside of the notifications constructor and knows exactly what kind of email class it’s creating and consuming. It's violate DIP.
//      A class has dependency on some other class and knows a lot about the other classes it interacts with is said to be tightly coupled.
//      When a class knows explicitly about the design and implementation of another class, its raise the risk that changes to one class will break the other class.
//
//      What if we want to send some other types of notifications like SMS or save into the DB? To enable this behavior we have to modify the implementation of the notification class.
//
//    To reduce dependency we have to do couple of steps.
//      Firstly introduce an abstraction layer between these two classes.
//      We can use interface/ abstract class to represent the abstractions between Notification and Email.
//

class Email {
    public void sendEmail() {
        // code
    }
}

class Notification {
    private Email email;
    public Notification() {
        email = new Email();
    }

    public void sendPromotionalNotification() {
        email.sendEmail();
    }
}

interface SourceType {
    void send() ;
}

class EmailNew implements SourceType {
    public void send() {
        // code
    }
}

class SMS implements SourceType {
    public void send() {
        // code
    }
}

// Here, introduced an interface SourceType to represent the abstraction, and ensure that the Notification class only calls methods or properties on that interface.
// Secondly need to move the creation of the Email class outside of the Notification. We can achieve this by DI pattern.

class NotificationNew  {
    private SourceType _source;

    public NotificationNew() {
        _source = new EmailNew();
    }

    public void sendPromotionalNotification() {
        _source.send();
    }
}