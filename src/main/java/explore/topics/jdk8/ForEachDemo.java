package explore.topics.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ForEachDemo {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(2, 4, 5, 7, 8);
        //integers.forEach(System.out::println);

        Stream<Integer> s = integers.stream();
        s.forEach(System.out::println); // Will work
        s.forEach(System.out::println); // Exception: stream has already been operated upon or closed
    }
}

