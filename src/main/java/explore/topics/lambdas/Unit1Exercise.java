package explore.topics.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Unit1Exercise {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("G", "Kapoor", 32),
                new Person("Q", "Wu", 36),
                new Person("E", "Ochivochi", 23),
                new Person("S", "Orishaev", 30),
                new Person("A", "Hazarvi", 25)
        );

        Collections.sort(personList, Comparator.comparing(Person::getLastName));

        // printCondition(personList, p -> true);
        System.out.println("person sorted");
        performConditionUsingPredicate(personList, p -> true, p -> System.out.println(p));
        System.out.println("-------------------------");
        System.out.println("p.getLastName().startsWith(\"O\")");
        //printConditionUsingPredicate(personList, (Person p) -> p.getLastName().startsWith("O"));
        performConditionUsingPredicate(personList, (Person p) -> p.getLastName().startsWith("O"), p -> System.out.println(p));
        System.out.println("-------------------------");
        System.out.println("p.getFirstName().startsWith(\"A\")");
        performConditionUsingPredicate(personList, (Person p) -> p.getFirstName().startsWith("A"), p -> System.out.println(p.getFirstName()));


    }

    private static void printCondition(List<Person> personList, ConditionName conditionName) {
        for(Person p : personList) {
            if(conditionName.test(p)) {
                System.out.println(p);
            }
        }
    }
    private static void printConditionUsingPredicate(List<Person> personList, Predicate<Person> predicate) {
        for(Person p : personList) {
            if(predicate.test(p)) {
                System.out.println(p);
            }
        }
    }
    private static void performConditionUsingPredicate(List<Person> personList, Predicate<Person> predicate
                                            , Consumer<Person> consumer) {
        for(Person p : personList) {
            if(predicate.test(p)) {
                consumer.accept(p);
            }
        }
    }
}

interface ConditionName {
    boolean test(Person p);
}