package explore.topics._stacks_queues;

import java.util.Stack;

public class QueueUsingTwoStacks {

    public static Stack<Integer> pushStack = new Stack<>();
    public static Stack<Integer> popStack = new Stack<>();
    public static void main(String[] args) {


        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
        queue.enqueue(2);
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(7);
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(11);
        queue.enqueue(10);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    private void enqueue(int value) {
        while (!popStack.isEmpty()) {
            pushStack.push(popStack.pop());
        }
        pushStack.push(value);
    }

    private int dequeue() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.pop();
    }
}
