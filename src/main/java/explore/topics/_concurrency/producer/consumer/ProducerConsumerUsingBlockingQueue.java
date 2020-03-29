package explore.topics._concurrency.producer.consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingBlockingQueue {
    private static final Integer CAP = 10;
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(CAP);

        final Runnable producer = () -> {
            while (true) {
                try {
                    queue.put(createItem());
                    System.out.println("Produced: " + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();

        final Runnable consumer = () -> {
            while (true) {
                try {
                    queue.take();
                    System.out.println("Consumed: " + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(consumer).start();
        new Thread(consumer).start();
        Thread.sleep(1000);
    }

    private static Integer createItem() {
        Random r = new Random();
        return r.nextInt(CAP);
    }
}

