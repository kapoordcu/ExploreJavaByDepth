package explore.topics._stacks_queues;

public class OwnStack {
    private SNode top;

    public OwnStack() {
        this.top = null;
    }

    public void push(int value) {
        if(top==null) {
            top = new SNode(value);
        } else {
            SNode next = new SNode(value);
            next.next = top;
            top = next;
        }
    }

    public int pop() {
        if(top==null) {
            return -1;
        } else {
            SNode nextTop = top.next;
            top = nextTop;
        }
        return top.data;
    }

    public void printStack() {
        if(top==null) {
            return;
        } else {
            SNode start = top;
            while(start!=null) {
                System.out.print(start.data + " ");
                start = start.next;
            }
        }
    }
    static class SNode {
        public int data;
        public SNode next;

        public SNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        OwnStack stack = new OwnStack();
        stack.push(10);
        stack.push(3);
        stack.push(7);
        stack.push(2);
        stack.push(14);
        stack.push(1);
        stack.printStack();

        System.out.println();
        System.out.println("After 4 pop operations");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.printStack();
    }
}
