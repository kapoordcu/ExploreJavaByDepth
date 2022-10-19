package strings;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BracketBalance {
    Map<Character, Character> bracketsMap = new HashMap<>();

    @Test
    public void test01() {
        String s = "()";
        assertTrue(isBalanced(s));
    }

    private boolean isBalanced(String str) {
        if(bracketsMap.isEmpty()) {
            bracketsMap.put('(', ')');
            bracketsMap.put('{', '}');
            bracketsMap.put('[', ']');
        }

        Stack<Character> queue = new Stack<>();
        queue.add(str.charAt(0));

        while (!queue.isEmpty()) {
            for (int i = 1; i < str.length(); i++) {
                Character prevBracket = null;
                if(!queue.isEmpty()) {
                    prevBracket = queue.peek();
                }
                Character currentBracket = str.charAt(i);
                if(bracketsMap.containsKey(prevBracket) &&
                        currentBracket.equals(bracketsMap.get(prevBracket))) {
                    queue.pop();
                } else {
                    queue.add(currentBracket);
                }
            }
            if(queue.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Test
    public void test02() {
        String s = "()[]{}";
        assertTrue(isBalanced(s));
    }

    @Test
    public void test03() {
        String s = "(}";
        assertFalse(isBalanced(s));
    }

    @Test
    public void test04() {
        String s = "(){}}{";
        assertFalse(isBalanced(s));
    }



//    private boolean isBalanced(String s) {
//        Stack<Character> stack = new Stack<>();
////        Map<Character, Character> brackets = new HashMap<>();
//        Character pop = null;
////        brackets.put('{', '}');
////        brackets.put('[', ']');
////        brackets.put('(', ')');
//        for (Character ch: s.toCharArray()) {
//            if(!stack.isEmpty()) {
//                pop = stack.peek();
//            }
//            if(pop!=null && isMatchFound(pop, ch)) {
//                stack.pop();
//                pop = null;
//            } else {
//                stack.push(ch);
//            }
//        }
//        return stack.isEmpty();
//    }
//
//    private boolean isMatchFound(char pop, char ch) {
//        if(pop=='{' && ch=='}' ||
//                pop=='[' && ch==']' ||
//                pop=='(' && ch==')' ) {
//            return true;
//        }
//        return false;
//    }
}
