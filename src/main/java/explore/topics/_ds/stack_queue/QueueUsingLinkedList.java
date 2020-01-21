package explore.topics._ds.stack_queue;

public class QueueUsingLinkedList {
    private MyQueueNode entry;
    private MyQueueNode exit;

    public QueueUsingLinkedList() {
        this.entry = null;
        this.exit = null;
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enqueue(10);
        queue.enqueue(30);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(15);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(5);
        queue.enqueue(11);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }



    private int dequeue() {
        if(exit==null) {
            return Integer.MAX_VALUE;
        } else {
            int value = exit.value;
            exit = exit.next;
            return value;
        }
    }

    /**
     *
     *  |entry| -- || -- || -- || -- |exit|
     */

    private void enqueue(int value) {
        MyQueueNode newNode = new MyQueueNode(value, null);
        if(exit==null) {
            entry = exit = newNode;
        } else {
            MyQueueNode oldEntry = entry;
            oldEntry.next = newNode;
            entry = newNode;
        }
    }

}

class MyQueueNode {
    public int value;
    public MyQueueNode next;

    public MyQueueNode(int value, MyQueueNode next) {
        this.value = value;
        this.next = next;
    }

}

