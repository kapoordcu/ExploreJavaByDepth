package explore.topics.ocp.lambda04;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LambdaBuildInInterfaces {
    private static String statusRegistered = "Registered";
    private static String statusAccepted = "Accepted";
    private static String statusRejected = "Rejected";

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("Whizlabs");
        Consumer<String> consumer = System.out::println;
        stringStream.forEach(consumer.andThen(System.out::println));
    }
}
// Build-in interfaces - Predicate, Consumer, Function, Supplier (from java.util.function package)

/*
    FI provide target types for lambda expressions and MR, Placeholders for Lambda Expre
    A FI has a SAM whose parameters and return type are matched by those of the lambda expression in the using context (parameters types are same, return type of LE must be same of suntype)

    Predicate: represents a boolean valued function of an arg,
    Unique abstract method is == boolean test(T t);  -> evaluates this predicate on the given argument
    3 Default Methods - Combining Predicates
            default Predicate<T> and(Predicate<? super T> other); // returns Composted predicate which is AND between predicate and the argument
            default Predicate<T> negate();  // Logical Negation of the predicate
            default Predicate<T> or(Predicate<? super T> other); // returns Composted predicate which is OR between predicate and the argument

***********************Predicate  Predicate   Predicate  Predicate Predicate  Predicate ******************************
    Predicate<MilitaryApplicant> isMale = a -> a.getGender() == MilitaryApplicant.Gender.MALE;
    Predicate<MilitaryApplicant> eligibleAge = a -> a.getAge()>=18 && a.getAge()<=45;

    Predicate<MilitaryApplicant> entryIntoMilitary = isMale.and(eligibleAge);


    MilitaryApplicant m1 = new MilitaryApplicant("Graun", MilitaryApplicant.Gender.MALE, 23);
    MilitaryApplicant m2 = new MilitaryApplicant("Graise", MilitaryApplicant.Gender.FEMALE, 23);
    MilitaryApplicant m3 = new MilitaryApplicant("Tasty", MilitaryApplicant.Gender.FEMALE, 18);
    MilitaryApplicant m4 = new MilitaryApplicant("Timo", MilitaryApplicant.Gender.MALE, 46);

    MilitaryApplicant.entryMilitary(m1, entryIntoMilitary);
    MilitaryApplicant.entryMilitary(m2, entryIntoMilitary);
    MilitaryApplicant.entryMilitary(m3, entryIntoMilitary);
    MilitaryApplicant.entryMilitary(m4, entryIntoMilitary);

***********************Consumer  Consumer   Consumer  Consumer Consumer  Consumer ******************************
    Consumer: represents an operation that works on an input arg and does not return any value, Side effected
    Unique abstract method is == void accept(T t);  -> performs this operation on the given argument
    1 Default Methods -
            default Consumer<T> andThen(Consumer<? super T> after): // returns  a Composted Consumer that performs this operation, followed by the after argument

        private static String statusRegistered = "Registered";
        private static String statusAccepted = "Accepted";
        Consumer<MilitaryApplicant> setStatus = a-> {
            if(a.getAge()>=18 && a.getAge()<=45) {
                a.setStatus(statusAccepted);
            }
        };
        Consumer<MilitaryApplicant> notify = a-> {
            if(a.getStatus().equalsIgnoreCase(statusAccepted)) {
                System.out.println(a.getName() + " is accepted.");
            }
        };
        MilitaryApplicant m1 = new MilitaryApplicant("Graun", MilitaryApplicant.Gender.MALE, 23);
        MilitaryApplicant m2 = new MilitaryApplicant("Graise", MilitaryApplicant.Gender.FEMALE, 23);
        MilitaryApplicant m3 = new MilitaryApplicant("Tasty", MilitaryApplicant.Gender.FEMALE, 18);
        MilitaryApplicant m4 = new MilitaryApplicant("Timo", MilitaryApplicant.Gender.MALE, 46);
        MilitaryApplicant.handleApplicant(m1, setStatus.andThen(notify));
        MilitaryApplicant.handleApplicant(m2, setStatus.andThen(notify));
        MilitaryApplicant.handleApplicant(m3, setStatus.andThen(notify));
        MilitaryApplicant.handleApplicant(m4, setStatus.andThen(notify));



***********************Function  Function   Function  Function Function  Function ******************************
    Function: represents a function that accepts an arg and produces the result
    Unique abstract method is == R apply(T t);  -> performs this function to given argument
    2 Default Methods -
            default <V> Function<V, R> compose(Function<? super V, ? extends T> before) // returns  a Composted Function that functionargument(input) and then applies this function(result)
            default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) // returns  a Composted Function that function(input) and then applies this functionargument(result)
    static <T> Function<T, T> identity() // returns  a Composted Consumer that performs this operation, followed by the after argument


        Function<MilitaryApplicant, MilitaryApplicant> setStatus = a-> {
            if(a.getAge()>=18 && a.getAge()<=45) {
                a.setStatus(statusAccepted);
            }
            return a;
        };
        Function<MilitaryApplicant, String> notify = a-> {
            if(a.getStatus().equalsIgnoreCase(statusAccepted)) {
                return statusAccepted;
            } else {
                return statusRejected;
            }
        };

        MilitaryApplicant m1 = new MilitaryApplicant("Graun", MilitaryApplicant.Gender.MALE, 23);
        MilitaryApplicant m2 = new MilitaryApplicant("Graise", MilitaryApplicant.Gender.FEMALE, 23);
        MilitaryApplicant m3 = new MilitaryApplicant("Tasty", MilitaryApplicant.Gender.FEMALE, 18);
        MilitaryApplicant m4 = new MilitaryApplicant("Timo", MilitaryApplicant.Gender.MALE, 46);

        MilitaryApplicant.handleApplicantFunction(m1, notify.compose(setStatus));
        MilitaryApplicant.handleApplicantFunction(m2, notify.compose(setStatus));
        MilitaryApplicant.handleApplicantFunction(m3, notify.compose(setStatus));
        MilitaryApplicant.handleApplicantFunction(m4, notify.compose(setStatus));

***********************Supplier  Supplier   Supplier  Supplier Supplier  Supplier ******************************

    Supplier: represents a Supplier of object of a particular objects
    Unique abstract method is == T get();  -> get an object of a particular type


        Supplier<MilitaryApplicant> suppliear = MilitaryApplicant.provider();
        MilitaryApplicant militaryApplicant1 = suppliear.get();
        MilitaryApplicant militaryApplicant2 = suppliear.get();
        System.out.println("The first applicant is " + militaryApplicant1.getName());
        System.out.println("The second applicant is " + militaryApplicant2.getName());

*/
class MilitaryApplicant {
    private Integer id;
    private String name;
    private Gender gender;
    private Integer age;
    private String status = "Registered";
    public MilitaryApplicant(String name, Gender gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public MilitaryApplicant(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public MilitaryApplicant(String name) {
        this.name = name;
        this.id = new Random().nextInt(1000);
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    enum Gender {MALE, FEMALE};

    public static void entryMilitary(MilitaryApplicant applicant, Predicate<MilitaryApplicant> predicate) {
        if(predicate.test(applicant)) {
            System.out.println(applicant.getName() + " is selected");
        } else {
            System.out.println(applicant.getName() + " is rejected, Sorry");
        }

    }

    public static void handleApplicant(MilitaryApplicant applicant, Consumer<MilitaryApplicant> consumer) {
        consumer.accept(applicant);
    }

    public static void handleApplicantFunction(MilitaryApplicant applicant, Function<MilitaryApplicant, String> function) {
        String apply = function.apply(applicant);
        System.out.println(applicant.getName() + " is " + apply);
    }

    public static Supplier<MilitaryApplicant> provider() {
        return () -> new MilitaryApplicant("Hello User");
    }
}