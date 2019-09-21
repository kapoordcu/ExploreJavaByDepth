package explore.topics.lambdas;

public class Closures {
    public static void main(String[] args) {
        int a = 10;
        int add = 20;
        doProcess(a, i -> System.out.println(i + add));
    }
    public static void doProcess(int i, Process p) {
        p.process(i);
    }

}

interface Process {
    void process(int i);
}