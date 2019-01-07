package explore.topics.lambdas;

public class Greeter {

    public void greet(Greetable greetable) {
        greetable.perform();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        Greetable innerClassGreetable = new Greetable() {
            @Override
            public void perform() {
                System.out.println("Greeting from InnerClass");
            }
        };

        Greetable greetableLambda = () -> System.out.println("Greeting from Lambda");
        greeter.greet(innerClassGreetable);
        greeter.greet(greetableLambda);

    }
}
