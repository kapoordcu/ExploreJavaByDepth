package explore.topics._stacks_queues;

import org.junit.Test;

import static org.junit.Assert.*;


public class ParenthesisCheckerTest {
    @Test
    public void chackPattern() {

        String pattern = "(())((())";
        boolean valid = ParenthesisChecker.isValid(pattern);
        assertFalse(valid);
    }

    @Test
    public void chackBalancedPattern() {
        String pattern = "(())(())";
        boolean valid = ParenthesisChecker.isValid(pattern);
        assertTrue(valid);
    }

    @Test
    public void chackSmallPattern() {
        String pattern = "()";
        boolean valid = ParenthesisChecker.isValid(pattern);
        assertTrue(valid);
    }

    @Test
    public void chackSmallUnbalancedPattern() {
        String pattern = "((";
        boolean valid = ParenthesisChecker.isValid(pattern);
        assertFalse(valid);
    }

    @Test
    public void chackBlankPattern() {
        String pattern = "";
        boolean valid = ParenthesisChecker.isValid(pattern);
        assertTrue(valid);
    }

    @Test
    public void checkSkewPattern() {
        String pattern = "()))))))))))";
        boolean valid = ParenthesisChecker.isValid(pattern);
        assertFalse(valid);
    }

    @Test
    public void checkIfMultipleTypeOfBracketsAreMatching() {
        String pattern = "{[()]}";
        boolean valid = ParenthesisChecker.isValid(pattern);
        assertTrue(valid);
    }

}
