package explore.topics.ocp.lambda04;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
    What is FI ?
    FI provide target types for lambda expressions and MR, They are used when declaring context that expect a function . You can think them as placeholders for Lambda Expre
    A FI has a SAM whose parameters and return type are matched by those of the lambda expression in the using context (match means parameters types are same, return type of LE must be same or suntype of Abs method Return type)

    Four Basic type of package
    Build-in interfaces - Predicate, Consumer, Function, Supplier (from java.util.function package)
*/
public class BuiltInInterfaces {
    private static String statusRegistered = "Registered";
    private static String statusAccepted = "Accepted";
    private static String statusRejected = "Rejected";

    public static void main(String[] args) {

        Applicant m1 = new Applicant("Braun", Applicant.Gender.MALE, 24);
        Applicant m2 = new Applicant("Philips", Applicant.Gender.FEMALE, 23);
        Applicant m3 = new Applicant("Remmington", Applicant.Gender.FEMALE, 15);
        Applicant m4 = new Applicant("Bosch", Applicant.Gender.MALE, 31);
        Applicant m5 = new Applicant("Nova", Applicant.Gender.MALE, 12);
    /*
            A ***********************Predicate  Predicate   Predicate  Predicate Predicate  Predicate ******************************

            Predicate: represents a boolean valued function of an arg,
            Unique abstract method is == boolean test(T t);  -> evaluates the containing predicate on the given argument
            3 Default Methods - Combining Predicates
            default Predicate<T> negate();  // Logical Negation of the predicate
            default Predicate<T> and(Predicate<? super T> other); // returns Composted predicate which is AND between predicate and the argument
            default Predicate<T> or(Predicate<? super T> other); // returns Composted predicate which is OR between predicate and the argument
    */
        Predicate<Applicant> isMale = a -> a.getGender()== Applicant.Gender.MALE;
        Predicate<Applicant> withinAgeLimits = a -> a.getAge()>= 18 && a.getAge() <=35 ;
        Predicate<Applicant> compositePredicate= isMale.and(withinAgeLimits);

        System.out.println("----------------  Predicate  ----------------");
        Applicant.applyPredicate(m1, compositePredicate);
        Applicant.applyPredicate(m2, compositePredicate);
        Applicant.applyPredicate(m3, compositePredicate);
        Applicant.applyPredicate(m4, compositePredicate);
        Applicant.applyPredicate(m5, compositePredicate);

    /*
            B ***********************Consumer  Consumer   Consumer  Consumer Consumer  Consumer ******************************
            Consumer: represents an operation that works on an input arg and does not return any value, operates via Side effects
            Unique abstract method is == void accept(T t);  -> applies the containing consumer to the given argument
            Default Method - allows you to combine multiple consumers
            default Consumer<T> andThen(Consumer<? super T> after): // returns a consumer composed of the containing Consumer object and the operation denoted by the after argument

    */
        Consumer<Applicant> setStatusConsumer = a-> {
            if(a.getAge()>=18 && a.getAge()<=35) {
                a.setStatus(statusAccepted);
            }
        };
        Consumer<Applicant> notifyConsumer = a-> {
            if(a.getStatus().equalsIgnoreCase(statusAccepted)) {
                System.out.println(a.getName() + " is accepted by Consumer.");
            }
        };
        Consumer<Applicant> applicantConsumer = setStatusConsumer.andThen(notifyConsumer);

        System.out.println("----------------  Consumer  ----------------");
        Applicant.applyConsumer(m1, applicantConsumer);
        Applicant.applyConsumer(m2, applicantConsumer);
        Applicant.applyConsumer(m3, applicantConsumer);
        Applicant.applyConsumer(m4, applicantConsumer);
        Applicant.applyConsumer(m5, applicantConsumer);
    /*
            C ***********************Function  Function   Function  Function Function  Function ******************************
            Function: represents a function that accepts an arg and produces a result
            Unique abstract method is == R apply(T t);  -> operates on the given argument
            2 Default Methods -
            default <V> Function<V, R> compose(Function<? super V, ? extends T> before) // applies functionargument(input) first and then function(result)
            default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) // applies function(input) first and then functionargument(result)
            static <T> Function<T, T> identity() // returns  a Composted Consumer that performs this operation, followed by the after argument

    */
        Function<Applicant, Applicant> setStatusFunction = a-> {
            if(a.getAge()>=18 && a.getAge()<=45) {
                a.setStatus(statusAccepted);
            }
            return a;
        };
        Function<Applicant, String> notifyFunction = a-> {
            if(a.getStatus().equalsIgnoreCase(statusAccepted)) {
                return statusAccepted;
            } else {
                return statusRejected;
            }
        };
        Function<Applicant, String> andThenFunction = setStatusFunction.andThen(notifyFunction);
        Function<Applicant, String> composeFunction = notifyFunction.compose(setStatusFunction);

        System.out.println("----------------  Function  ----------------");
        Applicant.applyFunction(m1, andThenFunction); Applicant.applyFunction(m1, composeFunction);
        Applicant.applyFunction(m2, andThenFunction); Applicant.applyFunction(m2, composeFunction);
        Applicant.applyFunction(m3, andThenFunction); Applicant.applyFunction(m3, composeFunction);
        Applicant.applyFunction(m4, andThenFunction); Applicant.applyFunction(m4, composeFunction);
        Applicant.applyFunction(m5, andThenFunction); Applicant.applyFunction(m5, composeFunction);
    /*
            D ***********************Supplier  Supplier   Supplier  Supplier Supplier  Supplier ******************************

            Supplier: represents a Supplier of object of a particular type, The return object may/maynot be same during different invocations
            Unique abstract method is == T get();  -> get an object of a particular type
            NO default methods
    */

        Supplier<Applicant> suppliear = Applicant.provider();
        Applicant militaryApplicant1 = suppliear.get();
        Applicant militaryApplicant2 = suppliear.get();

        System.out.println("----------------  Supplier  ----------------");
        System.out.println("The first applicant is " + militaryApplicant1.getName());
        System.out.println("The second applicant is " + militaryApplicant2.getName());
    }
}

class Applicant {
    private Integer id;
    private String name;
    private Gender gender;
    private Integer age;
    private String status = "Registered";
    public Applicant(String name, Gender gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Applicant(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Applicant(String name) {
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

    public static void applyPredicate(Applicant applicant, Predicate<Applicant> predicate) {
        if(predicate.test(applicant)) {
            System.out.println(applicant.getName() + " is selected by Predicate");
        } else {
            System.out.println(applicant.getName() + " is rejected by Predicate");
        }

    }

    public static void applyConsumer(Applicant applicant, Consumer<Applicant> consumer) {
        consumer.accept(applicant);
    }

    public static void applyFunction(Applicant applicant, Function<Applicant, String> function) {
        String apply = function.apply(applicant);
        System.out.println(applicant.getName() + " is " + apply);
    }

    public static Supplier<Applicant> provider() {
        return () -> new Applicant("Hello User");
    }
}