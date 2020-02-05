package explore.topics._stacks_queues;

public class OwnQueue {
    private static QNode enqueueEnd;
    private static QNode dequeueEnd;

    public OwnQueue() {
        this.enqueueEnd = null;
        this.dequeueEnd = null;
    }

    static class QNode {
        public int value;
        public QNode next;

        public QNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        OwnQueue queue = new OwnQueue();
        queue.enqueue(4);
        queue.enqueue(7);
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(6);
        queue.enqueue(8);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    private int dequeue() {
        int value = 0;
        if(dequeueEnd==null) {
            System.out.println("Empty Queue");
        } else {
            QNode nextDeq = dequeueEnd.next;
            value = dequeueEnd.value;
            dequeueEnd = nextDeq;
        }
        return value;
    }

    private void enqueue(int value) {
        if(enqueueEnd==null) {
            enqueueEnd = dequeueEnd = new QNode(value);
        } else {
            QNode neu = new QNode(value);
            enqueueEnd.next = neu;
            enqueueEnd = neu;
        }
    }
}
