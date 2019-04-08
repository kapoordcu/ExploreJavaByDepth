package explore.topics.ocp.generics;

// The filtering process in Collection and Streams is implemented using a Predicate
// Predicate is an expression that evaluates to Boolean value which is true/false
// java SE8 defines a FunctionInterface having a SAM(predicate) :boolean test(T t)

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class PredicateApp {
    public static void main(String[] args) {
        Collection<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(7);
/*
    You can filter the elements of a collection using removeIf is default method of Collection interface , inherited automatically
    boolean removeIf(Predicate<? super E> filter)
*/
        integers.removeIf(integer -> integer%2==0);
        integers.stream().forEach(m -> System.out.println(m));

/*
    You can filter the elements of a stream using filter which takes a predicate argument and returns a stream
    boolean removeIf(Predicate<? super E> filter)
*/
        Stream<Integer> filteredInt = integers.stream().filter(integer -> integer%2==0);
        filteredInt.forEach(n -> System.out.println(n));
    }
}


