package explore.topics.design.bridge;

// Decouples an abstraction from its implementation so that two can vary independently (which means Used to separate an abstraction from its implementation so that both cab be modified independently

// This pattern Involves an interface which acts as a bridge b/w the abstraction class and the implementation classes
// With bridge pattern both type of classes can ve modified without affecting to each other.

//Publish interface in an inheritance hierarchy, and bury implementation in its own inheritance hierarchy.
//        Beyond encapsulation, to insulation

// When to choose : When you need to avoid a permanent binding between abstraction and implementation (when A & I) should be extensible
// Hide the imp of an abstraction completely from clients
/*

The Bridge design pattern proposes refactoring this exponentially explosive inheritance hierarchy into two orthogonal hierarchies – one for platform-independent abstractions,
and the other for platform-dependent implementations.
*/

// https://refactoring.guru/design-patterns/bridge

/*
Bridge is a structural design pattern that lets you split a large class or a set of closely related classes into
two separate hierarchies—abstraction and implementation—which can be developed independently of each other.
*/


import explore.topics.design.adaptor.Customer;
import explore.topics.design.adaptor.EMWalletService;
import explore.topics.design.adaptor.TpiWalletService;
import explore.topics.design.adaptor.WalletType;

public class BridgeApp {
    public static void main(String[] args) {
        String emToken = "764d-4d65";
        Customer customer = new Customer("4932be6a-764d-4d65-be57-3e282cf0bcd8", emToken);
        System.out.println("-------------Sofort Klarna---------------");
        AddMoneyToWallet sofort = new SofortMoneyToWallet(new EMWalletService());
        sofort.addMoney(3000l);
        sofort.wallet.purchase(WalletType.WALLET_TPI, customer, "uuid-1", 10).toString();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("-------------PayPal---------------");
        AddMoneyToWallet paypal = new PayPalMoneyToWallet(new TpiWalletService());
        paypal.addMoney(10000l);
        paypal.wallet.purchase(WalletType.WALLET_TPI, customer, "uuid-1", 10).toString();

    }
}
/*    Relations with Other Patterns
        Bridge is usually designed up-front, letting you develop parts of an application independently of each other.
        On the other hand, Adapter is commonly used with an existing app to make some otherwise-incompatible classes work together nicely.

        Bridge, State, Strategy (and to some degree Adapter) have very similar structures. Indeed, all of these patterns are based on composition,
        which is delegating work to other objects. However, they all solve different problems. A pattern isn’t just a recipe for structuring your code in a specific way.
        It can also communicate to other developers the problem the pattern solves.

        You can use Abstract Factory along with Bridge. This pairing is useful when some abstractions defined by Bridge can only work with specific implementations.
        In this case, Abstract Factory can encapsulate these relations and hide the complexity from the client code.

        You can combine Builder with Bridge: the director class plays the role of the abstraction, while different builders act as implementations.*/

