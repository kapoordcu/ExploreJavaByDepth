package explore.topics.lambdas;

public class RunnableLanbda {
    public static void main(String[] args) {
//        Thread lambda = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Greeting from RunnableLanbda");
//            }
//        });
//
//        lambda.start();

        MyLambda le = (String str, int age) -> {
            System.out.println("Test me SAM called." + str + " with age " + age);
        };


        le.testMe("test", 12);

//        Thread lambdaThread = new Thread(() -> System.out.println("Greeting from lambdaThread")) ;
//        lambdaThread.start();
    }
}
