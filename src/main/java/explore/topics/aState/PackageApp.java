package explore.topics.aState;

public class PackageApp {
    public static void main(String[] args) {
        PackageCtx context = new PackageCtx();

        /**   First State  */
        System.out.println("------------First State-----------------");
        context.printStatus();

        /**   Moved to Delivered State  */
        System.out.println();
        System.out.println("------------ Moved to Delivered State----------------");
        context.setState(new DeliveredState());
        context.printStatus();

        /**   Moved to Received State  */
        System.out.println();
        System.out.println("------------ Moved to Received State----------------");
        context.setState(new ReceivedState());
        context.printStatus();

    }
}

// the package can be ordered, delivered and received, therefore we're going to have three states and the context class.
class PackageCtx {
/*
    it contains a reference for managing the state, notice previousState(), nextState() and printStatus() methods
    where we delegate the job to the state object. The states will be linked to each other and every state will set another
    one based on this reference passed to both methods.
        */
    private PackageState state = new OrderedState();

    public void setState(PackageState state) {
        this.state = state;
    }

    // The client will interact with the PackageCtx class, yet he won't have to deal with setting the states,
    // all the client has to do is go to the next or previous state.
    public void previousState() {
        state.prev(this);
    }

    public void nextState() {
        state.next(this);
    }

    public void printStatus() {
        state.printStatus();
    }
}

// This interface will be implemented by each concrete state class.
interface PackageState {
    void next(PackageCtx pkg);
    void prev(PackageCtx pkg);
    void printStatus();
}


class OrderedState implements PackageState {

    @Override
    public void next(PackageCtx pkg) {
        pkg.setState(new DeliveredState());
    }

    @Override
    public void prev(PackageCtx pkg) {
        System.out.println("The package is in its root state.");
    }

    @Override
    public void printStatus() {
        System.out.println("Package ordered, not delivered to the office yet.");
    }
}

class DeliveredState implements PackageState {

    @Override
    public void next(PackageCtx pkg) {
        pkg.setState(new ReceivedState());
    }

    @Override
    public void prev(PackageCtx pkg) {
        pkg.setState(new OrderedState());
    }

    @Override
    public void printStatus() {
        System.out.println("Package delivered to post office, not received yet.");
    }
}

class ReceivedState implements PackageState {

    @Override
    public void next(PackageCtx pkg) {
        System.out.println("This package is already received by a client.");
    }

    @Override
    public void prev(PackageCtx pkg) {
        pkg.setState(new DeliveredState());
    }

    @Override
    public void printStatus() {
        System.out.println("Package journey ended.");
    }
}