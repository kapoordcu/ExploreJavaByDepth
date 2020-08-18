package explore.topics._ds.stack_queue;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertTrue;

public class QueueUsingStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int v) {
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        stack.push(v);
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
    }

    public int dequeue() {
        return stack.pop();
    }

    @Test
    public void scenario1() {
        enqueue(5);
        enqueue(2);
        enqueue(3);
        enqueue(4);

        int pop = dequeue();
        assertTrue(pop==5);
//        Time Complexity:
//        Push operation: O(N).
//                In the worst case we have empty whole of stack 1 into stack 2.
//        Pop operation: O(1).
//                Same as pop operation in stack.
//        Auxiliary Space: O(N).
//                Use of stack for storing values.
    }


}
