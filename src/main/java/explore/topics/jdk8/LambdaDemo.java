package explore.topics.jdk8;

interface ALambda {
    void show();
}


public class LambdaDemo {
    public static void main(String[] args) {

        ALambda obj = () -> {System.out.println("Instantiate ALambda (Using Anonymous class)");};
    }
}
