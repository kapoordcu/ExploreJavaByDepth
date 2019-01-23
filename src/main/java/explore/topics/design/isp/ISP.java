package explore.topics.design.isp;

// Clients should not be forced to depend on methods that they do not use.

/*
This principle is very much related to the Single Responsibility Principle. What it really means is that you should always design your abstractions in a way
that the clients that are using the exposed methods do not get the whole pie instead. That also include imposing the clients with the burden of implementing
methods that they don’t actually need.
Keep your interfaces thin or fine-grained and don’t attach to them unused methods.

*/

// Correct abstraction is the key to Interface Segregation Principle


// Proximity to Single Responsibility Principle
public class ISP {
}

interface Printer {
    // Polluted Interface
    void print();
    void scan();
    void copy();

}

interface OnlyPrinter {
    void print();
}

interface OnlyScanner {
    void scan();
}

interface Copier extends OnlyPrinter, OnlyScanner {

}

class BasicPrinter implements OnlyPrinter {

    @Override
    public void print() {

    }
//
//    @Override
//    public void scan() {
//        // FORCED
//    }
//
//    @Override
//    public void copy() {
//        // FORCED
//    }
}

class AllInOnePrinter implements Printer {

    @Override
    public void print() {

    }

    @Override
    public void scan() {

    }

    @Override
    public void copy() {

    }
}

