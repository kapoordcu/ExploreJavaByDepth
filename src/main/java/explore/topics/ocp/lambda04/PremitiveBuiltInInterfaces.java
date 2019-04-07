package explore.topics.ocp.lambda04;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleToLongFunction;
import java.util.function.IntPredicate;
import java.util.function.LongFunction;
import java.util.function.LongSupplier;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

/*
     Generics FI can only operate on ref types, when using these Generic FI with primitive types, values are autoboxed and un-boxed, incurring overhead at both compile(extra work for compiler) and runtime
     handling objects of wrapper at runtime is more expensive as compared to primitive types
     java.util.function provide primitive type specializations of FI,  these specializations support primitive types
     Similar name same as generic, except prefix is different
*/
public class PremitiveBuiltInInterfaces {
    private static String statusRegistered = "Registered";
    private static String statusAccepted = "Accepted";
    private static String statusRejected = "Rejected";

    public static void main(String[] args) {
/*
A ***********************XPredicate  XPredicate   XPredicate  ******************************
        // IntPredicate, LongPredicate, DoublePredicate ---> boolean test(x value)  /// x primitive type
        Unique abstract method is == boolean test(x value)  /// x primitive type , x = int, long , double
        3 Default Methods - Combining Predicates
            default XPredicate negate();
            default XPredicate and(XPredicate other);
            default XPredicate or(XPredicate other) ;
*/
        IntPredicate primitivePredicate = i-> {
            // System.out.println(i instanceof Integer);// wont compile
            return i> 0;
        };

/*
        Example 1
        DoublePredicate predicate = d -> d<1.0;
        System.out.println(predicate.negate().test(0.0));
*/

        Predicate<Integer> wrapperPredicate = i-> {
            System.out.println(i instanceof Integer); return i> 0;
        };
/*
B ***********************XConsumer  XConsumer   XConsumer  ******************************
        IntConsumer, LongConsumer, DoubleConsumer ---> 3 premitive versions of consumer interface
        Unique abstract method is ==  void accept(x value)  /// x primitive type
            1 Default Methods -  default XConsumer andThen(XConsumer after):
*/

        DoubleConsumer doubleConsumer = d -> {
           // System.out.println(d.intValue());  // wont compile
        };

        Consumer<Double> wrapperConsumer = d -> {
            System.out.println(d.intValue());
        };
/*
        Example 2
        LongConsumer consumer = System.out::println;
        consumer.andThen(consumer).accept(1);
*/
/*
C ***********************XFunction  XFunction   XFunction  ******************************
        To facilitate function operations on  primitive values, various primitive version of FI have been introduces
        Grouped into 3 category

        i) Accepting a primitive argument
            Interfaces : IntFunction , LongFunction , DoubleFunction
            abstract method: == R apply(x value);  returns an object
        ii) producing a primitive result
            Interfaces : ToIntFunction , ToLongFunction , ToDoubleFunction
            abstract method: == x applyAsX(T object); --> returns a primitive value
        iii) Accepting and producing a primitive value
            Interfaces : XToYFunction
            abstract method: == y applyAsY(x value); --> apply this function to a prmitive argument and returns a primitive result

        NO DEFAULT METHODS FOR Primitive FI unlike Generic FI
*/
        LongFunction<String> longFunction = l -> String.valueOf(l); // accepts  a long premitive value, returns String object
        ToIntFunction<String> toIntFunction = s -> s.length(); // accepts a String object and returns a int primitive
        DoubleToLongFunction doubleToLongFunction = d -> Math.round(d);// accepts a double primitive and returns a long primitive
/*
D ***********************XSupplier  XSupplier   XSupplier  ******************************

    Supplier: has 4 primitive versions including
    Interfaces : IntSupplier , LongSupplier , DoubleSupplier, BooleanSupplier
        abstract method is == x getAsX();  -> get an value  of a primitive type
        NO default methods
*/
        LongSupplier supplier = () -> Long.MAX_VALUE;
        System.out.println(supplier);

    }
}
