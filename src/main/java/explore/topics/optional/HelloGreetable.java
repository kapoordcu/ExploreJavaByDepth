package explore.topics.optional;

public class HelloGreetable implements Greetable {
    @Override
    public void perform() {
        System.out.println("Greeting from HelloGreetable");
    }
}
