package explore.topics._jdk2020.optional;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OptionalCases {
    public static void main(String[] args) {


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
}
