package explore.topics._stacks_queues;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BalancedBracket {
    Map<Character, Character> setup = new HashMap<>();

    @Before
    public void setup() {
        setup.put('(', ')');
        setup.put('{', '}');
        setup.put('[', ']');
    }

    @Test
    public void check1() {
        String expre = "(){}[]";
        String expre2 = "(])[";
        String expre3 = "(";
        String expre4 = "([";
        boolean balanced = checkIfbalanced(expre);
        boolean balanced2 = checkIfbalanced(expre2);
        boolean balanced3 = checkIfbalanced(expre3);
        boolean balanced4 = checkIfbalanced(expre4);
        assertTrue(balanced);
        assertFalse(balanced2);
        assertFalse(balanced3);
        assertFalse(balanced4);

    }

    private boolean checkIfbalanced(String expre) {
        Stack<Character> charStack = new Stack<>();
        for (Character ch:         expre.toCharArray()) {
            if(charStack.isEmpty()) {
                charStack.push(ch);
            } else {
                Character peek = charStack.peek();
                if(peek!=null) {
                    Character matchingBracket = setup.get(peek);
                    if(ch==matchingBracket) {
                        charStack.pop();
                    } else {
                        charStack.push(ch);
                    }
                }
            }
        }

        return charStack.isEmpty();
    }
}
