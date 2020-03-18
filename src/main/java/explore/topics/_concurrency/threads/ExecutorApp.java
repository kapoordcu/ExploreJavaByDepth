package explore.topics._concurrency.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorApp {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Current Thread=" + Thread.currentThread().getName());
        System.out.println("Creating 100 Thread for 100 tasks");
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(()-> System.out.println("In a different thread=" + Thread.currentThread().getName()));
            t.start();
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("newFixedThreadPool");
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(cores);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> System.out.println("Using ExecutorService=" + Thread.currentThread().getName()));
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Creating 10 Threads for 100 tasks");
        ScheduledExecutorService scheduledTP = Executors.newScheduledThreadPool(10);

        executorService.shutdown(); // Initiate, not immediate, Lot of task already submitted to blocking queue
        // I will NOT take new one, but let me complete the already tasks.
        // If you submit new task after calling .shutdown, RejectionExecutionException is thrown

        executorService.isTerminated();
        // return true if initiation is started (does not mean its completed)

        executorService.isShutdown();
        //If shutdown is completed, (all completed including the one in queue)

        executorService.awaitTermination(200, TimeUnit.MILLISECONDS);
        // block until all tasks are completed or timeout occurs

        executorService.shutdownNow();
        //will return will all queued tasks. Only complete that thread that are running.
        // (not yet initiated)

        Future<Integer> future = executorService.submit(() -> 3);
        //Integer integer = future.get();

        future.cancel(false);
        // Good if you call cancel before TP has started , but if it has started, then cancel will have no effect.
        // depend on the interruptability of the threads

        future.isDone(); // Sucessfully or otherwise
        future.isCancelled();
    }
}

class MyTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 3;
    }
}