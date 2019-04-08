package explore.topics.ocp.streams05;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class SearchMethods {
    public static void main(String[] args) {
        /*
        find*() -> returns an Optional instance describing an element of the stream  : findFirst, findAny
        *Match(Predicate<? super T> predicte) : Returns weather elements of the stream match the given predicate : anyMatch, allMatch, nonematch
        *
        *
*/
        PersonStream lorenzo = new PersonStream("Lollita", 24);
        PersonStream grenchen = new PersonStream("Grenchen", 35);

        Stream<PersonStream> stream1 = Stream.of(lorenzo, grenchen);

/*      Optional<T> findFirst(); -> short-circuiting terminal operation, return an empty Optional(if stream is empty)  or Oprional describing first element of the stream
        Optional<T> findAny(); -> arbitrary element of the stream or an empty Optional (if stream is empty) -->
                non-deterministic ...Not consistent for multiple invocation on the same source
        maximal performance in parallel operations
*/
        PersonStream firstPersonFound = stream1.findFirst().get();
        System.out.println(firstPersonFound.getName() + " is " + firstPersonFound.getAge() + " years old.");

        Stream<PersonStream> stream2 = Stream.of(lorenzo, grenchen);
        PersonStream anyPersonFound = stream2.findAny().get();
        System.out.println(anyPersonFound.getName() + " is " + anyPersonFound.getAge() + " years old.");

/*      boolean anyMatch(Predicate<? super T> predicate) ; -> short-circuiting terminal operation, return an boolean )empty stream - false)
        boolean allMatch(Predicate<? super T> predicate) ; -> short-circuiting terminal operation, all elements of the stream match the given predicate, return an boolean---empty stream - true
        boolean noneMatch(Predicate<? super T> predicate) ; -> short-circuiting terminal operation, no elements of the stream match the given predicate, return an boolean---empty stream - true
*/
        Predicate<PersonStream> predicate = p-> p.getAge()>=25;
        Stream<PersonStream> stream3 = Stream.of(lorenzo, grenchen);
        System.out.println("anyMatch: " + stream3.anyMatch(predicate));

        Stream<PersonStream> stream4 = Stream.of(lorenzo, grenchen);
        System.out.println("allMatch: " + stream4.allMatch(predicate));

        Stream<PersonStream> stream5 = Stream.of(lorenzo, grenchen);
        System.out.println("noneMatch: " + stream5.noneMatch(predicate));

    }
}
