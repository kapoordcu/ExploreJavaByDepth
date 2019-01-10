package explore.topics.lambdas;

import java.util.Arrays;
import java.util.List;

public class CollectionIteration {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("G", "Kapoor", 32),
                new Person("Q", "Wu", 36),
                new Person("E", "Ochivochi", 23),
                new Person("S", "Orishaev", 30),
                new Person("A", "Hazarvi", 25)
        );

        personList.forEach(p -> System.out.println(p));
        personList.forEach(System.out::println);
//        for(Person p : personList) { // External Iterator
//            System.out.println(p);
//        }
    }
}
