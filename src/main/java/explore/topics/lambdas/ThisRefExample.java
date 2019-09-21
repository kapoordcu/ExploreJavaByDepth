package explore.topics.lambdas;

public class ThisRefExample {
    public static void main(String[] args) {
        ThisRefExample ref = new ThisRefExample();
        ref.doProcess(10, i -> {
            System.out.println("value of i: " + i);
            // System.out.println(this); Will not work, context remains static
        });
        ref.execute();

    }

    public void doProcess(int i, Process p) {
        p.process(i);
    }

    public void execute() {
        doProcess(10, i -> {
            System.out.println("value of i: " + i);
            System.out.println(this);
        });
    }

    public String toString() {
        return "ThisRefExample class instance";
    }
}
