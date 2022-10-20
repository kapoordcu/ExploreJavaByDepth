package own_ds;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class mStack<T> {
    private ArrayList<T> internalMem;
    private int top;

    private int size;

    public mStack() {}

    mStack(int size) {
        this.internalMem = new ArrayList<>(size);
        this.top = -1;
        this.size = size;
    }

    public <T> T pop() {
        if(top == -1 || size==0) {
            throw new ArrayIndexOutOfBoundsException("Stack is empty" + size);
        }
        T popped = (T) internalMem.get(top);
        internalMem.remove(popped);
        return popped;
    }

    public void push(T t) {
        if(internalMem.size() >= size) {
            throw new ArrayIndexOutOfBoundsException("Size is beyond capacity " + size);
        }
        internalMem.add(t);
        top = internalMem.size() - 1;
    }


    @Test
    public void test01()  {
        mStack<Integer> mStack = new mStack<>(10);
        mStack.push(2);
        mStack.push(3);
        mStack.push(1);
        assertTrue(mStack.size()==3);
        Integer popTop  = mStack.pop();
        assertTrue(popTop==1);
        assertTrue(mStack.size()==2);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testEmptyStack()  {
        mStack<Integer> mStack = new mStack<>(10);
        mStack.pop();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testFullStack()  {
        mStack<Integer> mStack = new mStack<>(1);
        mStack.push(2);
        mStack.push(3);
    }

    private int size() {
        return internalMem.size();
    }
}
