package explore.topics._concurrency.producer.consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerUsingWaitNotify {
    public static Integer CAP = 10;
    public static Random random = new Random();
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();
    }

}

class Producer implements Runnable {
    private Queue<Integer> sharedQ;

    public Producer(Queue<Integer> sharedQ) {
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        while (true){
            synchronized (sharedQ) {
                while(sharedQ.size()== ProducerConsumerUsingWaitNotify.CAP) {
                    try {
                        sharedQ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int itemAdded = ProducerConsumerUsingWaitNotify.random.nextInt(ProducerConsumerUsingWaitNotify.CAP);
                sharedQ.add(itemAdded);
                System.out.println("Produced and now  Size:" + sharedQ.size());
                sharedQ.notifyAll();
            }
        }
    }
}

class Consumer implements Runnable {
    private Queue<Integer> sharedQ;

    public Consumer(Queue<Integer> sharedQ) {
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedQ) {
                while (sharedQ.isEmpty()) {
                    try {
                        sharedQ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                sharedQ.poll();
                System.out.println("Consumed and now  Size:" + sharedQ.size());
                sharedQ.notifyAll();
            }
        }
    }
}