package explore.topics.ocp;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class IterationStreamsLists {
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
/*    forEach method in interface Stream*/
// forEach method take an action arg in the form of Consumer objects
// Consumer Interface represents an operation that accepts a single i/p arg and returns no result
//  void accept(T t), A consumer is FI, so its impl can be repres by Lambda
// void  forEach(Consumer<? super T> action), forEach is terminal op which consumes the stream
// behaviour of forEach is non-deterministic

/*    forEach method in Interface List */
// default method inherited from the Iterable interface with the signature void  forEach(Consumer<? super T> action)
// behaviour of forEach is deterministic