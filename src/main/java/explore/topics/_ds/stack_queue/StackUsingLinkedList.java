package explore.topics._ds.stack_queue;

import java.util.Stack;

public class StackUsingLinkedList {
    public static void main(String[] args) {
        Stack<Integer> ints = new Stack<>();
        StackLL ll = new StackLL();
        ll.push(10);
        System.out.println(ll.peek());
        ll.push(6);
        ll.push(13);
        System.out.println(ll.peek());
        System.out.println(ll.pop());
        ll.push(2);
        System.out.println(ll.peek());
    }
}

class StackLL{
    public StackNode top;

    public StackLL() {
        this.top = null;
    }

    public void push(int value) {
        StackNode oldTop = top;
        if(top!=null) {
            top = new StackNode(value);
            top.next = oldTop;
        } else {
            top = new StackNode(value);
        }
    }

    public int peek() {
        if(top!=null) {
            return top.value;
        }
        return Integer.MAX_VALUE;
    }

    public int pop() {
        if(top!=null) {
            int value = top.value;
            top = top.next;
            return value;
        }
        return Integer.MAX_VALUE;
    }
}

class StackNode {
    public int value;
    public StackNode next;

    public StackNode(int value) {
        this.value = value;
        this.next = null;
    }
}
