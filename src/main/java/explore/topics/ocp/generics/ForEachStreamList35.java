package explore.topics.ocp.generics;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class ForEachStreamList35 {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        stream.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer number) {
                number += number;
                System.out.println(number);
            }
        });
    }
}
/*    iterating using forEach method of streams and list */
// forEach method of both stream and list interface take an action argument in the form of Consumer objects
// Consumer Interface represents an operation that accepts a single i/p argument and returns no result
//  void accept(T t), A consumer is FI, so its impl can be represented by Lambda
// void  forEach(Consumer<? super T> action), forEach is terminal op which consumes the stream
// behaviour of forEach is non-deterministic  - Result might not be the same everytime is called

/*    forEach method in Interface List */
// default method inherited from the Iterable interface with the signature void  forEach(Consumer<? super T> action)
// behaviour of forEach in List is deterministic