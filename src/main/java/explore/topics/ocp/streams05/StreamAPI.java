package explore.topics.ocp.streams05;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        PersonStream lorenzo = new PersonStream("Lorenzo", 34);
        PersonStream grenchen = new PersonStream("Grenchen", 35);
/*
    peek method of Stream interface performs an action to each element of the stream
    Stream<T> peek(Consumer<? super T> action);
    Intermediate operation(Its action is not initiated unless a terminal operation is initiated on resulting stream).
    Usually used for logging
*/

        Stream<PersonStream> peekStream = Stream.of(lorenzo, grenchen);
        Stream<PersonStream> peekStreamResult = peekStream.peek(p -> System.out.println(p.getName() + ":" + p.getAge()));
        peekStreamResult.forEach(p->{});


/*
    map method of Stream interface applies a mapper to  elements of the stream
    Stream<R> map(Function<? super T, ? extends R> mapper);
    Intermediate operation(Its action is not initiated unless a terminal operation is initiated on resulting stream).

*/
        Stream<PersonStream> mapStream = Stream.of(lorenzo, grenchen);
        Stream<String> mapStreamResult = mapStream.map(p -> p.getName());
        mapStreamResult.forEach(s-> System.out.println(s));

/*
        The map operation of the stream interface has Three primitive type specializations : mapToInt, mapToLong, mapToDouble
        Each of these methods takes a primitive version of function as its argument and returns a primitive specialization of stream

        IntStream mapToInt(ToIntFunction<? super T> mapper);
        LongStream mapToLong(ToLongFunction<? super T> mapper);
        DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper);
*/
        Stream<PersonStream> mapStreamPrimitive = Stream.of(lorenzo, grenchen);
        IntStream primitiveIntStream = mapStreamPrimitive.mapToInt(p-> p.getAge());
        primitiveIntStream.forEach(s-> System.out.println(s));
    }

}

class PersonStream {
    private String name;
    private Integer age;

    public PersonStream(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
