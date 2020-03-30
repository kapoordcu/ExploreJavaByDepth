package explore.topics._concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserAsLatch {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        Phaser phaser = new Phaser(3);
        threadPool.submit(new DependentServicePhaser(phaser));
        threadPool.submit(new DependentServicePhaser(phaser));
        threadPool.submit(new DependentServicePhaser(phaser));

        phaser.awaitAdvance(1) ;// like await()
        System.out.println("All dependent services started.");
    }
}

class DependentServicePhaser implements Runnable {
    private Phaser phaser;

    public DependentServicePhaser(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        //startup task
        phaser.arrive(); // like countDown()
        //continue with other ops
    }
}
