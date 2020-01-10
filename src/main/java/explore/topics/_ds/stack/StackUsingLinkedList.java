package explore.topics._ds.stack;

public class StackUsingLinkedList {
    public static void main(String[] args) {

        StackLL ll = new StackLL();
        ll.push(10);
        System.out.println(ll.peek());
        ll.push(6);
        ll.push(13);
        System.out.println(ll.peek());
        ll.push(2);

    }
}

class StackLL{
    public StackNode top;

    public StackLL() {
        this.top = null;
    }

    public void push(int value) {
        StackNode node = new StackNode(value);
        if(top==null) {
            top = node;
        } else {
            StackNode prevTop = top;
            top = node;
            top.next = prevTop;
        }
    }

    public int peek() {
        if(top==null) {
            return Integer.MIN_VALUE;
        }
        return top.value;
    }

    public int pop() {
        if(top==null) {
            return Integer.MIN_VALUE;
        }
        int value = top.value;
                top = top.next;

        return value;
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
