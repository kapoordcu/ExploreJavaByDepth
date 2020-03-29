package explore.topics._concurrency.producer.consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerUsingLock {
    private Queue<Integer> queue;
    private int CAP;

    private ReentrantLock lock = new ReentrantLock(true);

    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public ProducerConsumerUsingLock(Integer sixe) {
        this.queue = new LinkedList<>();
        this.CAP = sixe;
    }

    public void add(Integer e) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (queue.size()==CAP) {
                    notFull.await();
                }
                queue.add(e);
                System.out.println("Produced: " + queue.size());
                notEmpty.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public Integer remove() throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (queue.size()==0) {
                    notEmpty.await();
                }
                Integer poll = queue.poll();
                System.out.println("Consumed: " + queue.size());
                notFull.signalAll();
                return poll;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerUsingLock flow = new ProducerConsumerUsingLock(10);
        Thread producer = new Thread(new ProducerL(flow));
        Thread consumer = new Thread(new ConsumerL(flow));
        Thread consumer2 = new Thread(new ConsumerL(flow));
        producer.start();
        consumer.start();
        consumer2.start();
    }

}

class ProducerL implements Runnable {
    private ProducerConsumerUsingLock container;
    private Random random;

    public ProducerL(ProducerConsumerUsingLock container) {
        this.container = container;
        random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                container.add(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ConsumerL implements Runnable {
    private ProducerConsumerUsingLock container;

    public ConsumerL(ProducerConsumerUsingLock container) {
        this.container = container;
    }

    @Override
    public void run() {
        while (true) {
            try {
                container.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}