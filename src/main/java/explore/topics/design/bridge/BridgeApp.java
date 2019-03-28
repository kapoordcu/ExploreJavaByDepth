package explore.topics.design.bridge;

/*
PROBLEM IT SOLVES
    This problem occurs because we’re trying to extend the classes in two independent dimensions, That’s a very common issue with class inheritance.
    When you subclass an abstract base class to provide alternative implementations it is compile-time binding between interface and implementation.
    The abstraction and implementation cannot be independently extended or composed.
*/

/*
SOLUTION
    The Bridge pattern attempts to solve this problem by switching from inheritance to composition. What this means is that you extract one of the dimensions into a separate
    class hierarchy, so that the original classes will reference an object of the new hierarchy, instead of having all of its state and behaviors within one class.
*/

/*
NAMING CONVENTION
    Following this approach, we can extract the color-related code into its own class with two subclasses: Red and Blue.
    The Shape class then gets a reference field pointing to one of the color objects. Now the shape can delegate any color-related work to the linked color object.
    That reference will act as a bridge between the Shape and Color classes. From now on, adding new colors won’t require changing the shape hierarchy, and vice versa.
 */

/*
INTENT
    The Bridge design pattern proposes refactoring exponentially explosive inheritance hierarchy into orthogonal hierarchies
    Decouples(separate) an abstraction from its implementation so that two can vary independently without impact in client
    Publish interface in an inheritance hierarchy, and bury implementation in its own inheritance hierarchy.
    Uses composition over inheritance.
*/

/*
WHEN TO USE
    you want run-time binding of the implementation,
    you want to share an implementation among multiple objects,
    you need to map orthogonal class hierarchies.
    The Bridge pattern is an application of the old advice, “prefer composition over inheritance”.
    It becomes handy when you must subclass different times in ways that are orthogonal with one another.
*/
// https://refactoring.guru/design-patterns/bridge

public class BridgeApp {
    public static void main(String[] args) {
        PaymentProvider paypalCreditCard = new PayPalPaymentProvider(new CreditCardImpl());
        paypalCreditCard.whoIsPaymentProvoder();

        PaymentProvider klarnaCreditCard = new SofortPaymentProvider(new CreditCardImpl());
        klarnaCreditCard.whoIsPaymentProvoder();

        PaymentProvider klarnaDebitCard = new SofortPaymentProvider(new DebitCardImpl());
        klarnaDebitCard.whoIsPaymentProvoder();
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

