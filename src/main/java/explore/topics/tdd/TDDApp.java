package explore.topics.tdd;


import org.junit.Assert;
import org.junit.Test;
/*


This whole process often looks overwhelming to TDD beginners.
One of the common complains is that TDD slows down the development process. It is true that at first it takes time to get into speed.
However, after a bit of practice development using TDD process saves time, produces better design, allows easy and safe refactoring,
    increases quality and test coverage and, last but not least, makes sure that software is always tested.
Another great benefit of TDD is that tests serve as a living documentation. It is enough to look at tests to know what each software unit should do.
That documentation is always up to date as long as all tests are passing.
Unit tests produced with TDD should provide “code coverage” for most of the code and they should be used together with Acceptance Test Driven Development (ATDD)
    or Behavior Driven Development (BDD). Together they are covering both unit and functional tests, serving as full documentation and requirements.

TDD makes you focus on your task, code exactly what you need, think from outside and, ultimately, a better programmer.

*/


// https://technologyconversations.com/2013/12/20/test-driven-development-tdd-example-walkthrough/
public class TDDApp {

//    @Test(expected=RuntimeException.class)
//    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
//        SumCalculator.add("1, 2, 3");
//    }

    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
        SumCalculator.add("1,2");
        Assert.assertTrue(true);
    }
    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        SumCalculator.add("1,X");
    }

    @Test
    public final void whenEmptyStringIsUsedThenReturnValueIs0() {
        Assert.assertEquals(0, SumCalculator.add(""));
    }

    @Test
    public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
        Assert.assertEquals(3, SumCalculator.add("3"));
    }

    @Test
    public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
        Assert.assertEquals(3+6, SumCalculator.add("3,6"));
    }

    @Test
    public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
        Assert.assertEquals(3+6+15+18+46+33, SumCalculator.add("3,6,15,18,46,33"));
    }

    @Test
    public final void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
        Assert.assertEquals(3+6+15, SumCalculator.add("//;n3;6;15"));
    }

    @Test(expected = RuntimeException.class)
    public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
        Assert.assertEquals(3+6+15, SumCalculator.add("//;n3;-6;15"));
    }

    @Test
    public final void whenOneOrMoreNumbersAreGreaterThan1000IsUsedThenItIsNotIncludedInSum() {
        Assert.assertEquals(3+100, SumCalculator.add("3, 100, 2000"));
    }
}
