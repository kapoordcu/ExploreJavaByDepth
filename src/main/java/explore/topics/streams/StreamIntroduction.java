package explore.topics.streams;

import explore.topics.lambdas.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamIntroduction {

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Gaurav", "Kapoor", 32),
                new Person("Qun", "Wu", 36),
                new Person("Elias", "Ochivochi", 23),
                new Person("Stas", "Orishaev", 30),
                new Person("Gkif", "Hazarvi", 25)
        );

        personList.stream()
                .filter(p -> p.getLastName().startsWith("O"))
                .forEach(p-> System.out.println(p.getFirstName()));

        long count = personList.stream()
                .filter(p -> p.getLastName().startsWith("O"))
                .count();
        System.out.println(count);
    }
}
