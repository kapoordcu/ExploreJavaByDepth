package explore.topics.ocp.streams05;

import java.io.IOException;
import java.util.Optional;

/*
        null references
*/
public class OptionalApp {
    public static void main(String[] args) {
        HabitantNullPointerException habitantNullPointerException = new HabitantNullPointerException();
        // System.out.println(habitantNullPointerException.getAddress().getStreetName()); //Exception in thread "main" java.lang.NullPointerException

        HabitantOptional habitantOptional = new HabitantOptional();
        // System.out.println(habitantOptional.getAddress().get().getStreetName());//java.util.NoSuchElementException: No value present
        Optional<Address> address = habitantOptional.getAddress();
        if (address.isPresent()) {
            System.out.println(address.get().getStreetName()); // get() is not the only way to retrieve the value in optional class, use only when its guaranteed non empty
        }

/*
        Optional - no public constructors - Creation Methods
        1.    public static<T> Optional<T> empty() --> empty optional instance and returned Optional contains no value
        2.    public static <T> Optional<T> of(T value) --> returns an optional instance  with the given value or NullPointerException
                Optional.of(null) --> NullPointerException
                Optional.of("Hello");
        3.    public static <T> Optional<T> ofNullable(T value)
                Optional.ofNullable(null) --> Empty Optional
                Optional.of("Hello");
*/
/*
        Optional - Retrieval Methods
        1.      public T get() --> returns a contained value in Optional object if it is present otherwise throws NoSuchElementException
        2.      public T orElse(T other) --> returns a contained value in Optional object if it is present otherwise returns the given argument
        3.      public T orElseGet(Supplier<? extends T> other) --> returns a contained value in Optional object if it is present otherwise rinvokes the supplier argument
        4.      public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X --> returns a contained value in Optional object if it is present otherwise throws an exception created by the supplier argument
        5.      public boolean isPresent()  // True or False(Empty Options)
        6.      public void ifPresent(Consumer<? super T> consumer)  // invokes the Consumer argument if the value is present, otherwise DO NOTHING
        7.      public Optional<T> filter(Predicate<? super T> predicate)   // returns an Optional object describing the value if it is present and metches the preducate argument, otherwise returns empty Optional
        8.      public<U> Optional<U> map(Function<? super T, ? extends U> mapper)   // rapplies the mapping Function argument to the value if it is present otherwise returns empty Optional
        9.      public<U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper)   // applies the optional bearing mapping Function argument to the value if it is present otherwise returns empty Optional

*/
        Optional<String> containingValue = Optional.of("Hello");
        // System.out.println(containingValue.get());
        System.out.println(containingValue.orElse("Empty"));

        Optional<String> emptyOptional = Optional.empty();
        // System.out.println(notContaining.get());//Exception in thread "main" java.util.NoSuchElementException: No value present
        System.out.println(emptyOptional.orElse("Empty"));
        System.out.println(emptyOptional.orElseGet(()-> "Empty Value"));
        emptyOptional.ifPresent(System.out::println);


        /*        String value = emptyOptional.orElseThrow(IOException::new);
                    System.out.println(value);
        */
        Optional<Integer> optionalInteger = Optional.of(1);
        Optional<Integer> optionalFilter = optionalInteger.filter(i-> i%2==0);
        System.out.println(optionalFilter.isPresent());// prints false

        Optional<Integer> opLengthEmpty = emptyOptional.map(String::length);
        Optional<Integer> opLength = containingValue.map(String::length);
        System.out.println(opLengthEmpty.get());//Exception in thread "main" java.util.NoSuchElementException: No value present
        System.out.println(opLength.get());

    }
}

class HabitantOptional {
    private Optional<Address> address = Optional.empty();

    public Optional<Address> getAddress() {
        return address;
    }

    public void setAddress(Optional<Address> address) {
        this.address = address;
    }
}

class HabitantNullPointerException {
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

class Address {
    private String streetName;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}