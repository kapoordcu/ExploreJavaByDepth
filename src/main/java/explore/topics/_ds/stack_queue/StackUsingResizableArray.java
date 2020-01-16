package explore.topics._ds.stack_queue;

//          Pros: Easy to implement. Memory is saved as pointers are not involved.
//          Cons: It is not dynamic. It doesn’t grow and shrink depending on needs at runtime.

public class StackUsingResizableArray {
    private int[] stackArray;
    private int capacity = 5;
    private int top;

    public StackUsingResizableArray() {
        this.stackArray = new int[capacity];
        this.top = -1;
    }

    public static void main(String[] args) {
        StackUsingResizableArray stack = new StackUsingResizableArray();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(5);
        stack.push(12);
        stack.push(7);
        stack.push(11);
        stack.push(2);
        stack.push(8);
    }

    public void push(int value) {
        if(top==capacity-1) {
            copyOldArrayToNew(stackArray.length*2);
        }
        stackArray[++top] = value;
    }

    private void copyOldArrayToNew(int newLength) {
        int[] newArray = new int[newLength];
        for (int i = 0; i < stackArray.length; i++) {
            newArray[i] = stackArray[i];
        }
        stackArray = newArray;
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
