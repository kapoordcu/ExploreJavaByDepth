package explore.topics._stacks_queues;

import java.util.Stack;

public class StackUsingO1ON {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public static void main(String[] args) {
        StackUsingO1ON obj = new StackUsingO1ON();
        obj.push(12);
        obj.push(4);
        obj.push(2);
        obj.push(7);
        obj.push(1);
        System.out.println(obj.getMin());
        obj.push(3);
        System.out.println(obj.getMin());

    }

    private void push(int val) {
        if(min.isEmpty()) {
            min.push(val);
        } else {
            Integer minVal = min.pop();
            if(minVal<val) {
                min.push(minVal);
            } else {
                min.push(val);
            }
        }
        s1.push(val);
    }

    private int pop() {
        min.pop();
        return s1.pop();
    }

    private int getMin() {
        return min.pop();
    }
}
