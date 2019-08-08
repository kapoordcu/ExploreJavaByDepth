package explore.topics.ocp.generics;

// The filtering process in Collection and Streams is implemented using a Predicate
// Predicate is an expression that evaluates to Boolean value which is true/false
// java SE8 defines a FunctionInterface having a SAM(predicate) :boolean test(T t)

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class PredicateFilterByLambda37 {
    public static void main(String[] args) {
        Collection<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
/*
    You can filter the elements of a collection using removeIf is default method of Collection interface , inherited automatically
    boolean removeIf(Predicate<? super E> predicate)  ---> Since predicate is a FI, thats why you can use a lambda expression in removeIf method
*/
        System.out.println("-----------removeIf(Predicate<? super E> predicate)--------------------");
        integers.removeIf(integer -> integer%2==0);
        integers.stream().forEach(m -> System.out.println(m));

/*

    You can filter the elements of a stream using filter which takes a predicate argument and returns a NEW stream
    Stream<T> filter(Predicate<? super E> predicate)
*/
        System.out.println("-----------Stream<T> filter(Predicate<? super E> predicate)--------------------");
        Stream<Integer> filteredInt = integers.stream().filter(integer -> integer>=4);
        filteredInt.forEach(n -> System.out.println(n));
    }

//    public static void main(String[] args) {
//        Deque<String> deque = new ArrayDeque<>();
//        deque.add("Alex");
//        deque.add("Sina");
//        deque.add("Denis");
//        deque.removeIf(new NameDelete());
//        deque.stream().forEach(System.out::println);
//    }
}
//
//class NameDelete implements Predicate<String> {
//
//    @Override
//    public boolean test(String s) {
//        return s.startsWith("A");
//    }
//}
