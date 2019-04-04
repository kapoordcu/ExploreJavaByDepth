package explore.topics.ocp;

import java.util.stream.Stream;

public class StreamInterfacePipeline {
    public static void main(String[] args) {
//        Collection<Integer> collection = Arrays.asList(1, 4, 5, 6, 8, 12, 3, 18);
//        Stream<Integer> stream = collection.stream();
//        stream.filter(i-> i%2==0).filter(i-> i%3==0).forEach(i -> System.out.println(i));
//

        Stream<String> employees = Stream.of("John", "Jane", "Janardhan");
        employees.filter(n-> {
            System.out.println(n);
            return n.equalsIgnoreCase("john");
        }).forEach(n-> System.out.println(n));
    }
}
// StreamInterface represents a seq of elements and supports aggregate operations(may be seq or par)
// Stream instance can be created by a static method or by a stream creation method invoked on a DS
// Can be operated on only once. Reusing as stream may result IllegalStateException
// The source of stream should not be modified while the stream is being processed. Unpredictable behavious
// Operation -> Intermediate | Terminal  = Stream Pipeline ( a source + 0 or more Intermediate ops + single terminal operation
// Intermediate -> return a New stream (Lazy and triggered only when terminal op of the pipeline is inititaed
// Terminal finish, the stream pipeline is consumed and cannot be reused. Create a new stream for reuse.