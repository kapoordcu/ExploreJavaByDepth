package explore.topics.jvm;

public class JMM {
    //BOTH stored on the heap along with the object itself
    private int objectMVPrimitiveType;
    private Integer objectMVReferenceType;
    //Static class variables are also stored on the heap along with the class definition.
    private static int staticMVOfClass;
    /**
     * Even if two threads are executing the exact same code,
     * the two threads will still create the local variables
     * of that code in each their own thread stack.
     * Thus, each thread has its own version of each local variable.
     */
    public void method() {
        int primitiveLocalVariable; // stored on Thread Stack

        // regardless of which thread created the object, The object is on Heap
        // the reference (the local variable) is stored on the thread stack
        Own_Type createdObject = new Own_Type();
    }
}

class Own_Type {

}