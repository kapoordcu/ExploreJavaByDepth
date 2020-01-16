package explore.topics._ds.stack_queue;

public class StackUsingGenerics<T> {
    private StackNodeGen top;

    public StackUsingGenerics() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T value) {
        StackNodeGen oldTop = top;
        top = new StackNodeGen(value);
        top.next = oldTop;
    }

    public T pop() {
        T value = (T) top.value;
        top = top.next;
        return value;
    }

    public static void main(String[] args) {
        StackUsingGenerics stack = new StackUsingGenerics();
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}

class StackNodeGen<T> {
    public T value;
    public StackNodeGen next;

    public StackNodeGen(T value) {
        this.value = value;
        this.next = null;
    }
}