package explore.topics.design.aDip;

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

/*

https://javarevisited.blogspot.com/2015/06/difference-between-dependency-injection.html


In the case of Factory design pattern, client class is responsible for calling getInstance() of factory class to create an instance of products, it also means that client class is directly coupled with factory and can't be unit tested without factory class being available.
On the other hand in Dependency Injection, client class has no clue about how its dependencies are created and managed. It only knows about dependencies.
Mostly dependencies are injected by a framework like a bean class exists without any hard-coded dependency, as those are injected by IOC container like Spring Framework.


Difference between Factory Pattern vs Dependency Injection
Based on our knowledge of both of these patterns, you can easily deduce following key differences between them :

1) Factory pattern adds coupling between object, factory, and dependency. Object not only needs a dependent object to work properly but also a Factory object. While in case of dependency injection, Object just knows the dependency, it doesn't know anything about container or factory


2) As compared to Factory pattern, Dependency injection makes unit testing easier. If you use the factory pattern, you need to create the object you want to test, the factory and the dependent object, of course, you factory can return a mock object, but you need all this just to start with unit testing.  On the other hand, if you use dependency injection, you just need to mock the dependency and inject into an object you want to test, no clutter or boilerplate is needed.


3) Dependency injection is more flexible than the factory pattern. You can even switch to different DI frameworks like Spring IOC or Google Guice.


4) One of the drawbacks of Dependency injection, as compared to Factory pattern, is that you need a container and configuration to inject the dependency, which is not required if you use a factory design pattern.

In true sense, it's not such a bad thing because you have one place to see dependency of your class and you can control them, but yes when you compare DI to a factory method, this is the additional step you need to do.


5) Due to low coupling, DI results in much cleaner co than factory pattern. Your object looks like POJO and you also come to know what is mandatory and what is an option by looking at which type of dependency injection your class is using.

If an object is injected using Setter injection, which means it's optional and can be injected at any time, while dependencies which are injected using constructor injection means they are mandatory and must be supplied in the order they are declared.


6) Another tricky scenario with using DI is creating an object with too many dependencies and worse if those are injected using constructor injection.

That code becomes difficult to read. One solution to that problem is to use Facade pattern and inject dependencies by encapsulating in another object.  For example, you can introduce an object say ApplicationSettings which can contain DatabaseSetting, FileSetting and other configuration settings required by an object. You can read more about Facade pattern in the Design Pattern Library course on Pluralsight, which is one of the best collection fo design patterns in one place.


7) You should use Dependency Injection Patterns to introduce loose coupling. Use Factory Patterns if you need to delegate the creation of objects. In short, dependency injection frees your application from factory pattern boilerplate code.

All the work which is required to implement a factory is already done by IOC containers like Spring and Google Guice.






 */