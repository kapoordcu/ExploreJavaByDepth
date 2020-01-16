package explore.topics._ds.stack_queue;

//          Pros: Easy to implement. Memory is saved as pointers are not involved.
//          Cons: It is not dynamic. It doesn’t grow and shrink depending on needs at runtime.

public class StackUsingArray {
    private int[] stackArray;
    private int capacity = 5;
    private int top;

    public StackUsingArray() {
        this.stackArray = new int[capacity];
        this.top = -1;
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }

    public void push(int value) {
        if(top>=capacity-1) {
            throw new RuntimeException("Stack out of capacity");
        }
        stackArray[++top] = value;
    }

    public int pop() {
        return top < 0 ?  -1 : stackArray[top--];
    }

    public int peek() {
        return top < 0 ?  -1 : stackArray[top];
    }

    public boolean isEmpty() {
        return top < 0;
    }


}
