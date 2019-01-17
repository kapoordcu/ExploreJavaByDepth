package explore.topics.streams;

import explore.topics.lambdas.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamIntroduction {

    private static Person[] arrayOfEmps = {
            new Person("Jeff", "Bezos", 32),
            new Person("Bill", "Gates", 36),
            new Person("Mark", "Zuckerberg", 23)
    };

    private static List<Person> empList = Arrays.asList(arrayOfEmps);

    public static void main(String[] args) {

        /*   OBTAIN A STREAM
            // obtain a stream from an existing array : Stream.of(arrayOfEmps);
            // obtain a stream from an existing list: empList.stream();
            // we can create a stream from individual objects using Stream.of()
            Stream.of(arrayOfEmps[0], arrayOfEmps[1], arrayOfEmps[2]);

            //  obtain a stream from an existing list: using Stream.builder()
            Stream.Builder<Person> empStreamBuilder = Stream.builder();
            empStreamBuilder.accept(arrayOfEmps[0]);
            empStreamBuilder.accept(arrayOfEmps[1]);
            empStreamBuilder.accept(arrayOfEmps[2]);
            Stream<Person> empStream = empStreamBuilder.build();
            empStream.forEach(emp -> System.out.println(emp.getLastName()));


            */

        /*   Stream Operations   */
        empList.stream()
                .forEach(e -> System.out.println(e.getLastName()));

//        List<Person> personList = Arrays.asList(
//                new Person("Gaurav", "Kapoor", 32),
//                new Person("Qun", "Wu", 36),
//                new Person("Elias", "Ochivochi", 23),
//                new Person("Stas", "Orishaev", 30),
//                new Person("Gkif", "Hazarvi", 25)
//        );
//
//        // forEach() is a terminal operation
//        personList.stream()
//                .filter(p -> p.getLastName().startsWith("O"))
//                .forEach(p-> System.out.println(p));
//
//        long count = personList.stream()
//                .filter(p -> p.getLastName().startsWith("O"))
//                .count();
//        System.out.println(count);
    }
}
