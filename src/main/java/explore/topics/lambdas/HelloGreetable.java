package explore.topics.lambdas;

public class HelloGreetable implements Greetable {
    @Override
    public void perform() {
        System.out.println("Greeting from HelloGreetable");
    }
}
