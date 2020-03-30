package explore.topics._concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockBasics {
    private Lock A = new ReentrantLock();
    private Lock B = new ReentrantLock();

    public void execute() {
        new Thread(this::processThis).start();
        new Thread(this::processThat).start();
    }

    private void processThis() {
        A.lock();
        B.lock();

        A.unlock();
        B.unlock();
    }

    private void processThat() {
        B.lock();
        A.lock();

        A.unlock();
        B.unlock();
    }
}
