package explore.topics._concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReadWriteLockDemo {

    private void process() {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        // Create a task and submit to a thread
        MyTask task = new MyTask();
        final Future<?> future = threadPool.submit(task);
        // 2  : wait for 10 minutes to get response
        try {
            future.get(10, TimeUnit.MINUTES);
        } catch (InterruptedException | ExecutionException e) {
            // process exception
        } catch (TimeoutException e) {
            future.cancel(true); // if using interrupts
            task.stop(); // if using volatile
        }
    }
}

class MyTask implements Runnable {
    public AtomicBoolean keepRunning = new AtomicBoolean(true);
    @Override
    public void run() {
        while (keepRunning.get()==true) {
            //steps
        }
    }

    public void stop() {
        keepRunning.set(false);
    }
}