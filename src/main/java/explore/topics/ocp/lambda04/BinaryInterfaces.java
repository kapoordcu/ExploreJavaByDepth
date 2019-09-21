package explore.topics.ocp.lambda04;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.ObjIntConsumer;

/*
     Binary Interfaces are the FI,  that have an abstract method with 2 params
     All have binary versions (except Supplier)
*/
public class BinaryInterfaces {
    public static void main(String[] args) {



/*
A ***********************Binary Predicate ******************************
        BiPredicate is the only binary specialization of the Primitive interface
        BiPredicate<T, U> : boolean test(T t, U u);
        three default methods negate, or, and
*/
        BiPredicate<Integer, Double> biPredicate = (i, d) -> i>d;
        boolean test = biPredicate.test(1, 1.2);
        if (test) {
            System.out.println("Integer is greater than double ");
        } else {
            System.out.println("Double is greater than Integer ");
        }

/*
B ***********************Binary Consumer ******************************
        Four Binary spec: BiConsumer, ObjIntConsumer, ObjLongConsumer, ObjDoubleConsumer
        BiConsumer<T, U> : void accept(T t, U u);
        ObjXConsumer<T> : void accept(T t, x value);

        Default methods: andThen
*/
        BiConsumer<String, String> biConsumer = (s1, s2) -> System.out.println(s1 + "." + s2);
        biConsumer.accept("hello", "com");

        ObjIntConsumer<String> intConsumer = (s, i) -> System.out.println(s.length()-i);
        intConsumer.accept("hello.com", 2);

/*
C ***********************Binary Function ******************************
    Four Binary spec: BiFunction, ToIntBiFunction, ToLongBiFunction, ToDoubleBiFunction
    BiFunction<T, U, R> : R apply(T t, U u);
    ToXBiFunction<T, U> : x applyAsX(T t, U u);

    Default methods: andThen
*/
/*
D ***********************Binary Operator Function ******************************
    BinaryOperator interface is specialization fo the BiFunction
    BinaryOperator subinterface of BiFunction
    XBinaryOperator
        BinaryOperator<T> : R apply(T left, T right);
        XBinaryOperator: x applyAsX(x left, x right);
*/
        BinaryOperator<String> binaryOperator = (s1, s2) -> s1.concat(".").concat(s2);
        String url =binaryOperator.apply("hello", "com");
        System.out.println(url);

        LongBinaryOperator longBinaryOperator = (l1, l2) -> l1+l2;
        long result = longBinaryOperator.applyAsLong(10l, -9l);
        System.out.println(result);

        BinaryOperator<Double> doubleBinaryOperator = (d1, d2) -> d1*d2;
        //double res = doubleBinaryOperator.apply(1, 2);
    }

}
