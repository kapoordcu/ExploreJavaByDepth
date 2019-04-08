package explore.topics.ocp.streams05;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDataAndCalculationMethod {
    public static void main(String[] args) {
/*
        Reduction operations

        Generic and Primitive
            count: long count();
            min:  Optional<T> min(Comparator<? super T> comparator);
            max: Optional<T> max(Comparator<? super T> comparator);
            reduce: T reduce(T identity, BinaryOperator<T> accumulator); // IntStream, LongStream, DoubleStream and Generic stream
             Collect method
*/
        Collection<String> sourceString = Arrays.asList("Hello", "this", "is", "boaring", "day");
        Collection<Integer> sourceInt = Arrays.asList(9,7,7,2,0,3,8,9);

        System.out.println("---------long count()----------------------");
        Stream<String> countMe = sourceString.stream();
        System.out.println(countMe.count());



        System.out.println("---------min----------------------");
        Stream<Integer> minMe = sourceInt.stream();
        Optional<Integer> minValue = minMe.min(Integer::compare);
        System.out.println(minValue.get());

        System.out.println("---------max----------------------");
        Stream<Integer> maxMe = sourceInt.stream();
        Optional<Integer> maxValue = maxMe.max(Integer::compare);
        System.out.println(maxValue.get());

        /*
        Reduce operations

        3 Reduce overloaded methods
            T reduce(BinaryOperator<T> accumulator); Performs a reduction on elements of the stream, using an associative accumulation function abd returns an optional describing the reduced value
            T reduce(T identity, BinaryOperator<T> accumulator); Performs a reduction on elements of the stream(using the provided identity value) using an associative accumulation function abd returns an optional describing the reduced value

*/
        System.out.println("---------reduce----------------------");
        Stream<Integer> reduceMe = sourceInt.stream();
        Optional<Integer> reduceSum = reduceMe.reduce(Integer::sum);
        System.out.println(reduceSum.get());

        System.out.println("---------reduce Overloaded----------------------");
        Stream<Integer> reduceMeOverloaded = sourceInt.stream();
        Integer reduceResult = reduceMeOverloaded.reduce(0, (i, j) -> i + j);
        System.out.println(reduceResult);

/*
        ONLY work with in Primitive type specialization
        average: OptionalDouble/Empty Optional = A.M. of elements of the stream  // Only PrimitiveStream
        sum: Total   // Only PrimitiveStream
*/
        System.out.println("---------intStreamAverage----------------------");
        IntStream intStreamAverage = IntStream.of(9,7,7,2,0,3,8,9);
        OptionalDouble average = intStreamAverage.average();
        System.out.println(average.getAsDouble());

        System.out.println("---------intStreamSum----------------------");
        IntStream intStreamSum = IntStream.of(9,7,7,2,0,3,8,9);
        System.out.println(intStreamSum.sum());
    }
}
