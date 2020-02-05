package explore.topics._stacks_queues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    private static Queue queue1;
    private static Queue queue2;

    public StackUsingQueue() {
        queue1 = new LinkedList();
        queue2 = new LinkedList();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(10);
        stack.push(3);
        stack.push(7);
        stack.push(2);
        stack.push(14);
        stack.push(1);
        stack.push(12);

        System.out.println();
        System.out.println("After 4 pop operations");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private int pop() {
        return (int)queue1.poll();
    }

    private void push(int value) {
        queue2.add(value);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
}
