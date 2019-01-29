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
        String emToken = "764d-4d65";
        CustomerHLP customer = new CustomerHLP("4932be6a-764d-4d65-be57-3e282cf0bcd8", emToken);
        TpiWalletService tpiWalletService = new TpiWalletServiceImpl();
        EMWalletService emWalletService = new EMWalletServiceImpl();

        // Wrap a tpiWalletService in a TpiWalletAdaptor so that it
        // behaves like EMWalletService
        EMWalletService tpiAdaptor = new TpiWalletAdaptor(tpiWalletService);

        System.out.println();
        System.out.println("tpi..." + tpiWalletService.purchase(ExternalSystemIdHLP.SWIPE_IN_SLOTS, customer, "uuid-1", 10).toString());

        System.out.println();
        System.out.println("EM..." + emWalletService.emPurchase(emToken, 40).toString());

        // EMWalletService behaving like a TpiWalletService
        System.out.println();
        System.out.println("Adaptor..." + tpiAdaptor.emPurchase(emToken, 40).toString());
    }
}


/*
    Advantages of Adapter design pattern
        It allows more flexibility in design.
        They handle logic by wrapping a new interface around that of an existing class so you can use new APIs (with different interfaces)
            and avoid breaking existing implementations.
        It absolutely interconnects two incompatible interfaces.
    Disadvantages of Adapter design pattern
        It unnecessarily increases the size of the code as class inheritance is less used and lot of code is needlessly duplicated between classes.
        Sometimes many adaptations are required along an adapter chain to reach the type which is required.
*/
