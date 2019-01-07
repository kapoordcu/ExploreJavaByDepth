package explore.topics.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Condition;

public class Unit1Exercise {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("G", "Kapoor", 32),
                new Person("Q", "Wu", 36),
                new Person("E", "Ochivochi", 23),
                new Person("S", "Orishaev", 30),
                new Person("A", "Hazarvi", 25)
        );

        Collections.sort(personList, (Person o1, Person o2) ->  o1.getLastName().compareTo(o2.getLastName()));

        printCondition(personList, p -> true);
        printCondition(personList, (Person p) -> p.getLastName().startsWith("O"));
    }

    private static void printCondition(List<Person> personList, ConditionName conditionName) {
        for(Person p : personList) {
            if(conditionName.test(p)) {
                System.out.println(p);
            }
        }
    }

}

interface ConditionName {
    boolean test(Person p);
}