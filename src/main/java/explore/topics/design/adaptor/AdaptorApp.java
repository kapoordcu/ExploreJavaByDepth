package explore.topics.design.adaptor;

// the adapter pattern makes two incompatible interfaces compatible without changing their existing code.
// Adapter patterns use a single class (the adapter class) to join functionality of independent or incompatible interfaces/classes.
// This pattern converts the (incompatible) interface of a class (the adaptee) into another interface (the target) that clients require.

/*
The adapter class implements the expected interface and keeps a reference to an object of the class you want to reuse.
The methods defined by the interface call one or more methods on the referenced object and return a value of the expected type.
By doing that, the adapter class fulfills the expected contract by implementing the interface and enables you to reuse existing, incompatible implementations.

*/
// Mimick some interface

public class AdaptorApp {
    public static void main(String[] args) {
        Customer customer = new Customer("4932be6a-764d-4d65-be57-3e282cf0bcd8", "764d-4d65");

        System.out.println("-------BEFORE ADAPTOR-------------");
        Wallet wallet = new TpiWallet();
        System.out.println(wallet.purchase(customer, "uuid-0", 100));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("-------AFTERRRRR ADAPTOR-------------");
        wallet = new EMWallet();
        WalletAdaptor adaptor = new WalletAdaptor(wallet);  // Adapter adapts subject (adaptee i.e. TpiWallet) to a different interface.
        System.out.println(adaptor.purchase(customer, "uuid-1", 10));

        // Decorator not only delegate, not only maps one method to another, they do more, they modify behaviour of some subject methods,
        // Decorators typically add (transparently) functionality to wrapped object like logging, encryption, formatting, or compression to subject.
        // This New functionality may bring a lot of new code. Hence, decorators are usually much “fatter” then Adapters.

//        WalletDecorator decorator1 = new WalletDecorator(new TpiWallet(), "Klarna");
//        WalletDecorator decorator2 = new WalletDecorator(new TpiWallet(), "PAYPAL");
//        System.out.println(decorator1.purchase(WalletType.WALLET_TPI, customer, "uuid-1", 10).toString());
//        System.out.println(decorator2.purchase(WalletType.WALLET_EM, customer, "uuid-1", 10).toString());

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
