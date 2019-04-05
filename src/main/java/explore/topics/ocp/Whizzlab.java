package explore.topics.ocp;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Whizzlab {
    public static void main(String[] args) {

/*
    Question 5
        Map<String, Integer> map = new TreeMap<>();
        map.put("ab", 1);
        map.put("abc", 2);
        map.put("abcd", 3);
        map.replaceAll((k,v) -> (int)k.charAt(v));
        System.out.println(map.values());
*/
/*
    Question 4
        Stream<String> stringStream = Stream.of("A", "B", "C", "D");
        System.out.println(stringStream.peek(System.out::println).findAny().orElse("NA"));

*/
/*
    Question 3
        ArrayDeque<String> adeq = new ArrayDeque<>();
        adeq.add("a");
        adeq.add("b");
        adeq.add("c");
        adeq.add("a");

        System.out.println(adeq);
*/
/*
    Question 2
        IntStream stream = IntStream.of(1, 2, 2, 4);
        Stream<String> ste = stream.boxed().map(Integer:: toString);
        System.out.println(ste.distinct().findFirst());
*/

/*
    Question 1
        TreeMap<String, String> map = new TreeMap<>();
        map.put("a", "apple");
        map.put("e", "egg");
        map.put("g", "gear");

        SortedMap<String, String> smap = map.subMap("a", "f");
        smap.put("b", "ball");
        smap.put("f", "fish");

        map.put("c", "cat");
        map.remove("a");

        System.out.println(smap);
        System.out.print(map);
*/

    }
}
