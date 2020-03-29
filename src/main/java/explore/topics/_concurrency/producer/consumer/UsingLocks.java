package explore.topics._concurrency.producer.consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class UsingLocks {
    private Queue<Integer> queue;
    private int max;
    private ReentrantLock lock = new ReentrantLock();

    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public UsingLocks(Integer MAX_SIZE) {
        this.queue = new LinkedList<>();
        this.max = MAX_SIZE;
    }

    public void add(Integer value) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size()==max) {
                notFull.await();
            }
            queue.add(value);
            System.out.println("P: " + queue.size());
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public Integer poll() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size()==0) {
                notEmpty.await();
            }
            Integer poll = queue.poll();
            System.out.println("C: " + queue.size());
            notFull.signalAll();
            return poll;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        UsingLocks locks = new UsingLocks(10);
        Thread prod = new Thread(new ProducerLock(locks));
        Thread cons = new Thread(new ConsumerLock(locks));

        prod.start();
        cons.start();
    }
}

class ProducerLock implements Runnable {
    private UsingLocks locks;
    private Random random;

    public ProducerLock(UsingLocks locks) {
        this.locks = locks;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                locks.add(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ConsumerLock implements Runnable {
    private UsingLocks locks;

    public ConsumerLock(UsingLocks locks) {
        this.locks = locks;
    }

    @Override
    public void run() {
        while (true) {
            try {
                locks.poll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}