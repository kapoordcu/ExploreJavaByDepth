package explore.topics._concurrency.forkjoin;

import java.util.concurrent.RecursiveTask;

public class Fibonacci {
    private int number;

    public Fibonacci(int number) {
        this.number = number;
    }

    private int solve() {
        if(number<=1) {
            return number;
        } else {
            Fibonacci f1 = new Fibonacci(number-1);
            Fibonacci f2 = new Fibonacci(number-2);
            f1.solve();
            f2.solve();
            int result = f1.number + f2.number;
            return result;
        }
    }

    public static void main(String[] args) {

    }
}

class Fib extends RecursiveTask<Integer> {
    @Override
    protected Integer compute() {
        if(n<=1) {
            return n;
        } else {
            Fib f1 = new Fib(n-1);
            f1.fork();
            Fib f2 = new Fib(n-2);
            f2.fork();
            int result = f1.join() + f2.join();
            return result;
        }
    }
    private int n;

    public Fib(int n) {
        this.n = n;
    }
}