package explore.topics.ocp.generics;

// Generics allows types to be specified as parameters when defining classes, interfaces and methods
// It enables you to reuse same class/interface with diff types of input

public class Generics31 {

    public static void main(String[] args) {
        Person<String, Integer> person = new Person<>("Gaurav", 25);


/*        // strong type checks at compile time
        // Eleiminates the use of casting
        List list = new ArrayList();
        list.add("Hello");
        String element = (String) list.get(0);

        List<String> listGenerics = new ArrayList<String>();
        listGenerics.add("Hello");
        String elementgenerics = listGenerics.get(0);

        ClasscastException at RunTime
        */

    }
}

class Data<T extends Number> {

//    Integer input = 10;
//    Data data = new Data<Number>(input);
//    Integer out = data.getAge();

    private T age;

    public Data(T age) {
        this.age = age;
    }

    public T getAge() {
        return age;
    }
}
// generic classes are classes that are parameterized over types.
class Person<S, T extends Number> {
    /*
    Normally any types can be passed to a genric class, But in some cases you might want to limit the values that can be used as type argument eg. age property
    Number class: Float and Integer , Bounded type parameter, PREVENT unrelated type to be used here like String
    Type parameter name 'extends' Upper bound  (Can use number as well)
    */

   /*
    A super type and sub types can be assigned to each other, the object type must be the subtype of variable type, type arguments must be no different
    ArrayList<Integer> is subtype of List<Integer>
    ArrayList<Integer> is NOT related to ArrayList<Number> or List<Number>
    */
    private S name;
    private T age;

    public Person(S name, T age) {
        this.name = name;
        this.age = age;
    }

    public S getName() {
        return name;
    }

    public T getAge() {
        return age;
    }
}