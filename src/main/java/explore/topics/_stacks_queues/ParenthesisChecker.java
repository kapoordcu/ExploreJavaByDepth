package explore.topics._stacks_queues;

import java.util.Stack;

public class ParenthesisChecker {

    /**
     * Time Complexity: O(n)
     * Auxiliary Space: O(n) for stack.
     */
    public static boolean isValid(String pattern) {
        Stack<Character> stack = new Stack<>();
        for(Character ch: pattern.toCharArray()) {
            if(!stack.isEmpty()) {
                checkIfMismatchFound(stack, ch);
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    private static void checkIfMismatchFound(Stack<Character> stack, Character ch) {
        Character peek = stack.peek();
        if(checkIFMatchingCharIsPopped(peek, ch)) {
            stack.pop();
        } else {
            stack.push(ch);
        }
    }

    private static boolean checkIFMatchingCharIsPopped(Character pop, Character ch) {
        if(pop=='{' && ch=='}' ||
                pop=='[' && ch==']' ||
                pop=='(' && ch==')' ) {
            return true;
        }
        return false;
    }

    public boolean ifSame(Character inStack, Character matchingChar) {
        return false;
    }
}
