package explore.topics.design;

// Correct abstraction is the key to Interface Segregation Principle
// Adaptor
// Template
// DIP and Factory
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

