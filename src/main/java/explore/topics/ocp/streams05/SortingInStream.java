package explore.topics.ocp.streams05;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public class SortingInStream {
    public static void main(String[] args) {

/*        Both are Intermediate operation and effectless without terminal operation
        A: Stream<T> sorted() : Returns a stream consisting of the elements of the original stream sorted according to their natural order
                Since, Natural order, the class of elements must be a Comparable Impl otherwise ClassCastException will be thrown.
        B: Stream<T> sorted(Comparator<? super T> comparator): according to given Comparator
*/
        Collection<String> sourceString = Arrays.asList("B", "D", "A", "E", "C");
        Stream<String> stream = sourceString.stream().sorted(String::compareTo);
        Optional<String> concatenatedAndSorted = stream.reduce(String::concat);
        System.out.println(concatenatedAndSorted.get());

        //Example 2
        Collection<PersonSorted> persons = Arrays.asList(new PersonSorted("Gaurav"),
                new PersonSorted("kapoor"));
        persons.stream().sorted().forEachOrdered(p-> System.out.println(p.getName())); //java.lang.ClassCastException: explore.topics.ocp.streams05.PersonSorted cannot be cast to java.lang.Comparable
    }
}

class PersonSorted {
    private String name;

    public PersonSorted(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int compareTo(PersonSorted personSorted) {
        return personSorted.getName().compareTo(name);
    }

}