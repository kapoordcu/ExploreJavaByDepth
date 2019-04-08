package explore.topics.ocp.streams05;

import java.util.Optional;
import java.util.stream.Stream;

public class SearchMethods {
    public static void main(String[] args) {
        /*
        find*() -> returns an Optional instance describing an element of the stream  : findFirst, findAny
        *Match(Predicate<? super T> predicte) : Returns weather elements of the stream match the given predicate : anyMatch, allMatch, nonematch
        *
        *
        Optional<T> findFirst(); -> short-circuiting terminal operation, return an empty Optional(if stream is empty)  or first
        Optional<T> findAny(); -> arbitrary element of the stream or an empty Optional (if stream is empty) -->
            non-deterministic ...Not consistent for multiple invocation on the same source
            maximal performance in parallel operations


*/
        Stream<String> streamFinders = Stream.of("Hello", "You", "Are", "Welcome");
        Optional<String> first = streamFinders.findFirst();
    }
}
