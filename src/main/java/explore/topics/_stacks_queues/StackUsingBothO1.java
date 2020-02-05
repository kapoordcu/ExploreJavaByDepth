package explore.topics._stacks_queues;

import java.util.Stack;

public class StackUsingBothO1 {
    private static Stack<Integer> stack = new Stack<>();
    private static Integer min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        StackUsingBothO1 obj = new StackUsingBothO1();
        obj.push(8);
        obj.push(10);
        obj.push(4);
        obj.push(2);
        obj.push(7);
        obj.push(1);
        obj.push(3);

        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }

    private void push(int value) {
        if(stack.isEmpty()) {
            min = value;
            stack.push(value);
        } else if(value > min) {
            stack.push(value);
        } else if(value <= min) {
            stack.push(2*value-min);
            min = value;
        }
    }

    private int pop() {
        Integer value = stack.pop();
        if(value>=min) {
            min = value - min;
            return value;
        } else {
            min = 2*value - min;
            return min;
        }
    }
}
