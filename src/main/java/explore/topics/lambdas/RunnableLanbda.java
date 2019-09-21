package explore.topics.lambdas;

public class RunnableLanbda {
    public static void main(String[] args) {
        Thread lambda = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Greeting from RunnableLanbda");
            }
        });

        lambda.start();

        Thread lambdaThread = new Thread(() -> System.out.println("Greeting from lambdaThread")) ;
        lambdaThread.start();
    }
}
