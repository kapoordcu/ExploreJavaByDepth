package explore.topics.ocp.streams05;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    An ordinary reduction on stream elements using the reduce method can collect data but uts performance might not be good as a new instance of the result type is created each time an element is handled
    Concatenate a Stream of string, lot of String copying
    A mutable reduction operation accumulates i/p elements into a mutable result container(StringBuilder, Collection) as it process the element of stream  (can be acieved using the collect operation of the stream API
        <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner);
           supplier  ->  To construct new instances of result container
           accumulator -> To incorporate input elements into a result container
           combiner -> to merge the content from diff result containers in a parallel stream

    Seperate functions of a collect method are tightly coupled and may be replaced by a collector
    <R, A> R collect(Collector<?super T, A, R> collector);


    The Collector Class
        provides a predefined factory methods
        toList. toSet, toCollection, toMap, groupingBy, partitioningBy

            <T> Collector<T, ?, List<T>> toSet()  /// returns a Collector that accumulates input elements into a new Set
            <T> Collector<T, ?, List<T>> toList()  /// returns a Collector that accumulates input elements into a new List

            toCollection(Supplier<C> collectionfactory) -> returns a Collector that accumulates inoput elements into a new collection, in encounter order

            toMap -> returns a Collector that accumulates inoput elements into a map whose key/vales are the result of applying the provided mapping functions to the input elements

            groupingBy -->  one-parameter groupingBy method of the Collectors class returns a Collector implementing a group-by operation on input elements abd retunr a resukt into a map
                            2-parameter groupingBy method of the Collectors class returns a Collector implementing a 'cascaded' group-by operation on input elements abd retunr a resukt into a map

            partitioningBy-> one-parameter partitioningBy method of the Collectors class returns a Collector partitioning input elements according to the given predicate and organizing them into
                            a Map (key are true/false, values are list instances )
                            two-parameter partitioningBy method of the Collectors class returns a Collector partitioning input elements according to the given predicate, reducing teh value of each partition into based on the collector  and organizing them into
                            a Map
 */
public class GroupingPartitioningData {
    public static void main(String[] args) {
        Collection<String> sourceString = Arrays.asList("B", "D", "A", "E", "C", "A", "E");
        List<String> toList = sourceString.stream().collect(Collectors.toList());
        Set<String> toSet = sourceString.stream().collect(Collectors.toSet());
        LinkedList<String> toCollection = sourceString.stream().collect(Collectors.toCollection(() -> new LinkedList<>()));

        System.out.println(toList);
        System.out.println(toSet);
        System.out.println(toCollection);

        PersonGroup gaurav = new PersonGroup(1, "gaurav");
        PersonGroup kapoor = new PersonGroup(2, "kapoor");
        Stream<PersonGroup> persons = Stream.of(gaurav, kapoor);
        Map<Integer, String> collecttoMap = persons.collect(Collectors.toMap(PersonGroup::getId  /* key mapper function*/, PersonGroup::getName/* value mapper function*/));
        System.out.println(collecttoMap);


        PersonGroup p1 = new PersonGroup(25, "Lio", PersonGroup.Gender.MALE);
        PersonGroup p2 = new PersonGroup(35, "Mia", PersonGroup.Gender.FEMALE);
        PersonGroup p3 = new PersonGroup(42, "Eli", PersonGroup.Gender.MALE);
        PersonGroup p4 = new PersonGroup(13, "Jio", PersonGroup.Gender.FEMALE);

        Stream<PersonGroup> groupByGenderStream = Stream.of(p1, p2, p3, p4);
        Map<PersonGroup.Gender, List<PersonGroup>> groupByGender = groupByGenderStream.collect(Collectors.groupingBy(PersonGroup::getGender));
        System.out.println(groupByGender);

        Stream<PersonGroup> groupByAgeStream = Stream.of(p1, p2, p3, p4);
        Map<PersonGroup.Gender, Double> genderDoubleMap = groupByAgeStream.collect(Collectors.groupingBy(PersonGroup::getGender, Collectors.averagingDouble(PersonGroup::getAge)));
        System.out.println(genderDoubleMap);

        Stream<PersonGroup> partitioningByGenderStream = Stream.of(p1, p2, p3, p4);
        Map<Boolean, List<PersonGroup>> byMalePartition = partitioningByGenderStream.collect(Collectors.partitioningBy(PersonGroup::isMale));
        System.out.println(byMalePartition);
        Stream<PersonGroup> partitioningByAgeStream = Stream.of(p1, p2, p3, p4);
        Map<Boolean, Double> byMaleAndAge = partitioningByAgeStream.collect(Collectors.partitioningBy(PersonGroup::isMale, Collectors.averagingDouble(PersonGroup::getAge)));
        System.out.println(byMaleAndAge);
    }
}

class PersonGroup {
    private int id;
    private int age;
    private String name;
    private Gender gender;

    public PersonGroup(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PersonGroup(int age, String name, Gender gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isMale() {
        return gender==Gender.MALE;
    }
    enum Gender {MALE, FEMALE};
}