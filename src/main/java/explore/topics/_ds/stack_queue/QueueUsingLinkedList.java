package explore.topics._ds.stack_queue;

public class QueueUsingLinkedList {
    private QueueNode first;
    private QueueNode last;

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enqueue(10);
        queue.enqueue(30);
        queue.enqueue(15);
        queue.enqueue(5);
        queue.enqueue(11);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    public QueueUsingLinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first==null;
    }

    public void enqueue(int value) {
        QueueNode node = new QueueNode(value);
        if(isEmpty()) {
            first = last = node;
        } else {
            QueueNode oldLast = last;
            oldLast.next = node;
            last = node;
        }
    }

    public int dequeue() {
        if(isEmpty()) {
            last = null;
        } else {
            int value = first.value;
            first = first.next;
            return value;
        }
        return Integer.MAX_VALUE;
    }
}


class QueueNode {
    public int value;
    public QueueNode next;

    public QueueNode(int value) {
        this.value = value;
        this.next = null;
    }
}