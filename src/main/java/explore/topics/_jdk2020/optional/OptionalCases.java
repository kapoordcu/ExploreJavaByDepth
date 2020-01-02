package explore.topics._jdk2020.optional;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OptionalCases {

    public String getMyDefault() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }

    //A value is present only if we have created Optional with a non-null value.
    @Test
    public void whenCreatesEmptyOptional_thenCorrect() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }

    @Test
    public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
        String name = "not_null_value";
        //the argument passed to the of() method can't be null. Otherwise, we'll get a NullPointerException
        Optional<String> opt = Optional.of(name);
        assertTrue(opt.isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
        String name = null;
        Optional.of(name);
    }

    //in case we expect some null values, we can use the ofNullable() method
    @Test
    public void givenNonNull_whenCreatesNullable_thenCorrect() {
        String name = "could be null";
        Optional<String> opt = Optional.ofNullable(name);
        assertTrue(opt.isPresent());
    }

    //  if we pass in a null reference, it doesn't throw an exception but rather returns an empty Optional object:
    @Test
    public void givenNull_whenCreatesNullable_thenCorrect() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        assertFalse(opt.isPresent());
    }

    // Optional makes us deal with nullable values explicitly as a way of enforcing good programming practice
    @Test
    public void givenOptional_whenIfPresentWorks_thenCorrect() {
        Optional<String> opt = Optional.of("enables us to run some code on the wrapped value if it's found to be non-null.");
        opt.ifPresent(name -> System.out.println(name.length()));
//        if(name != null) {
//            System.out.println(name.length());
//        }
    }

    // The orElse() method returns the wrapped value if it's present , in other case its argument
    @Test
    public void whenOrElseWorks_thenCorrect() {
        String nullName = null;
        String aDefault = Optional.ofNullable(nullName).orElse("Default");
        String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
        assertEquals(aDefault, "Default");
    }

    // when the wrapped value is not present, then both orElse() and orElseGet() work exactly the same way.
    // when using orElseGet() to retrieve the wrapped value, the getMyDefault() method is not even invoked since the contained value is present.
    // when using orElse(), whether the wrapped value is present or not, the default object is created.
    // So in this case, we have just created one redundant object that is never used.
    // However, when a method such as getMyDefault() has to make a web service call or even query a database, then the cost becomes very obvious.
    @Test
    public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
        String text = null;

        System.out.println("Using orElseGet:");
        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("Default Value", defaultText);

        System.out.println("Using orElse:");
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("Default Value", defaultText);
    }

    //Instead of returning a default value when the wrapped value is not present, it throws an exception:
    @Test(expected = IllegalArgumentException.class)
    public void whenOrElseThrowWorks_thenCorrect() {
        String text = null;

        System.out.println("Using orElseGet:");
        String defaultText = Optional.ofNullable(text).orElseThrow(IllegalArgumentException::new);
    }

    // BIGGEST PROBLEM WITH GET, IT DEFEATS THE PURPOSE OF OPTIONAL
    // get() can only return a value if the wrapped object is not null, otherwise, it throws a no such element exception:
    @Test
    public void givenOptional_whenGetsValue_thenCorrect() {
        String STR = "Value get";
        Optional<String> get_the_value = Optional.ofNullable(STR);
        String value = get_the_value.get();
        assertEquals(STR, value);
    }

    @Test
    public void whenOptionalFilterWorks_thenCorrect() {
        Integer year = 2020;
        Optional<Integer> currentYear = Optional.of(year);
        assertTrue(currentYear.filter(y -> y == year).isPresent());
    }

    @Test
    public void whenFiltersWithOptional_TraditionalIf() {

        assertTrue(Modem.priceIsInRangeTraditionalIf(new Modem(10.0)));
        assertFalse(Modem.priceIsInRangeTraditionalIf(new Modem(9.9)));
        assertFalse(Modem.priceIsInRangeTraditionalIf(new Modem(null)));
        assertFalse(Modem.priceIsInRangeTraditionalIf(new Modem(15.5)));
        assertFalse(Modem.priceIsInRangeTraditionalIf(null));
    }

    @Test
    public void whenFiltersWithOptional_thenCorrect() {

        assertTrue(Modem.priceIsInRangeOptional(new Modem(10.0)));
        assertFalse(Modem.priceIsInRangeOptional(new Modem(9.9)));
        assertFalse(Modem.priceIsInRangeOptional(new Modem(null)));
        assertFalse(Modem.priceIsInRangeOptional(new Modem(15.5)));
        assertFalse(Modem.priceIsInRangeOptional(null));
    }

/*    the filter method simply performs a check on the value and returns a boolean.
        the map method takes the existing value, performs a computation using this value and returns the result of the computation wrapped in an Optional object:
    */
    @Test
    public void test() {
        List<String> companyNames = Arrays.asList(
                "paypal", "oracle", "", "microsoft", "", "apple");
        Integer integer = Optional.ofNullable(companyNames)
                .map(List::size)
                .orElse(0);
    }

//    map transforms values only when they are unwrapped whereas flatMap takes a wrapped value and unwraps it before transforming it.
    @Test
    public void givenOptional_whenFlatMapWorks_thenCorrect2() {
        Person person = new Person("john", 26, null);
        Optional<Person> personOptional = Optional.of(person);
        Optional<Optional<String>> nameOptionalWrapper = personOptional.map(Person::getName);
        Optional<String> nameOptional = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
        String name1 = nameOptional.orElse("");
        assertEquals("john", name1);

        String name = personOptional
                .flatMap(Person::getName)
                .orElse("");
        assertEquals("john", name);
    }

}

class Modem {
    private Double price;

    public Modem(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    //  it's possible to forget about the null checks on a long day without getting any compile time errors.
    public static boolean priceIsInRangeTraditionalIf(Modem modem) {
        boolean isInRange = false;

        if (modem != null && modem.getPrice() != null
                && (modem.getPrice() >= 10
                && modem.getPrice() <= 15)) {

            isInRange = true;
        }
        return isInRange;
    }

    public static boolean priceIsInRangeOptional(Modem modem) {
        return Optional.ofNullable(modem)
                .map(Modem::getPrice)
                .filter(p -> p>=10)
                .filter(p -> p<=15)
                .isPresent();
    }
}

class Person {
    private String name;
    private int age;
    private String password;

    public Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> getAge() {
        return Optional.ofNullable(age);
    }

    public Optional<String> getPassword() {
        return Optional.ofNullable(password);
    }

}