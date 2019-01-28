package explore.topics.design.adaptor;

// the adapter pattern makes two incompatible interfaces compatible without changing their existing code.
// Adapter patterns use a single class (the adapter class) to join functionalities of independent or incompatible interfaces/classes.
// This pattern converts the (incompatible) interface of a class (the adaptee) into another interface (the target) that clients require.

/*
The adapter class implements the expected interface and keeps a reference to an object of the class you want to reuse.
The methods defined by the interface call one or more methods on the referenced object and return a value of the expected type.
By doing that, the adapter class fulfills the expected contract by implementing the interface and enables you to reuse existing, incompatible implementations.

*/

public class AdaptorApp {
    public static void main(String[] args) {

    }
}
