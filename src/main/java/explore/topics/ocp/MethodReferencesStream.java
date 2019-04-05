package explore.topics.ocp;

// A MR can be replaced by a lambda exp , if the exp body does nothing but invoke an existing method
// <ClassName | objectVariable> :: <methodName>
/*

MR kinds
    ** ref to a static method
    ** ref to a instance method of an arbitrary object of a particular type
    ** ref to a instance method of a particular object
    ** ref to a constructor
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Stream;

public class MethodReferencesStream {
    public static void main(String[] args) {
        /*
             ** ref to a instance method of a particular object
        */
        Collection<PersonSort> persons = new ArrayList<>();
        persons.add(new PersonSort("Eva"));
        persons.add(new PersonSort("Adam"));

        PersonSorter sorter = new PersonSorter();

        persons.stream().sorted((p1, p2) -> sorter.sort(p1, p2))
                .forEach(p -> System.out.println(p));
        persons.stream().sorted(sorter::sort)
                .forEach(System.out::println);

        /*
         ** ref to a constructor
         */
        Stream<DataVar> dataVarStream = Stream.generate(DataVar::new).limit(10).filter(d-> d.getVar()%2==0);
        dataVarStream.forEach(d -> System.out.println(d.getVar()));
    }
}

// ref to a static method, { personStream.forEach(p-> Person.fullName(p))   ----> personStream.forEach(Person::fullName) } -- The current object is passed as an arg to the method
// ref to a instance method of an arbitrary object of a particular type {  ----> personStream.forEach(Person::isMale) }  // Similar to static method  -- The method is called on the current object
// ref to a instance method of a particular object {  ----> personStream.sorted((p1, p2) -> sorter.sort

class PersonSort {
    private String name;

    public PersonSort(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonSort{" +
                "name='" + name + '\'' +
                '}';
    }
}

class PersonSorter {
    public int sort(PersonSort p1, PersonSort p2) {
        return p1.getName().compareTo(p2.getName());
    }
}

class DataVar {
    private int var;

    private static Random generator = new Random();

    public DataVar() {
        var = generator.nextInt();
    }

    public int getVar() {
        return var;
    }
}