package explore.topics.ocp.generics;

// A MR can be replaced by a lambda exp , if the exp body does nothing but invoke an existing method
// <ClassName | objectVariable> :: <methodName>
/*

MR kinds
    ** method ref to a static method
    ** method ref to a instance method of an arbitrary object of a particular type
    ** method ref to a instance method of a particular object
    ** method ref to a constructor
*/

import java.util.stream.Stream;

public class MethodReferences38 {
    public static void main(String[] args) {
        Stream<PersonMR> personStream = Stream.of(new PersonMR("Gaurav", 31, PersonMR.GENDER.L),
                new PersonMR("Kapoor", 34, PersonMR.GENDER.M));
        personStream.forEach(p -> PersonMR.fullName(p));
        personStream.forEach(PersonMR::fullName);

        personStream.filter(p-> p.isMale()).forEach(person -> System.out.println(person.getName()));
        personStream.filter(PersonMR::isMale).forEach(person -> System.out.println(person.getName()));

    }
}

// ref to a static method, { personStream.forEach(p-> Person.fullName(p))   ----> personStream.forEach(Person::fullName) } -- The current object is passed as an arg to the method
// ref to a instance method of an arbitrary object of a particular type {  ----> personStream.forEach(Person::isMale) }  // Similar to static method  -- The method is called on the current object
//// ref to a instance method of a particular object {  ----> personStream.sorted((p1, p2) -> sorter.sort

class PersonMR {
    private String name;
    private Integer age;
    private GENDER gender;

    public PersonMR(String name, Integer age, GENDER gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
    public static void fullName(PersonMR person) {
        System.out.println(person.getName() + " and age: " + person.getAge());
    }

    public boolean isMale() {
        return gender==GENDER.M;
    }

    public enum GENDER { M, L};

}
