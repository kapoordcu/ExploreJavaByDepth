package explore.topics._stacks_queues;

import java.util.Stack;

public class ParenthesisChecker {
    public static void main(String[] args) {
        String b1 = "{([])}";
        String b2 = "{}";
        String b3 = "()}";

        ParenthesisChecker checker = new ParenthesisChecker();

        System.out.println(checker.isBalanced(b1));
        System.out.println(checker.isBalanced(b2));
        System.out.println(checker.isBalanced(b3));
    }

    private boolean isBalanced(String str) {
        Stack exprStack = new Stack();
        for (char ch : str.toCharArray()) {
            if(ch=='{' || ch=='[' || ch=='(') {
                exprStack.push(ch);
            }
            if(ch=='}' || ch==']' || ch==')') {
                if(!exprStack.isEmpty()) {
                    char pop = (char) exprStack.pop();
                    if(!isMatchingPair(pop, ch)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return exprStack.isEmpty();
    }

    private boolean isMatchingPair(char pop, char ch) {
        if(ch==']' && pop=='[') {
            return true;
        } else if(ch=='}' && pop=='{') {
            return true;
        } else if(ch==')' && pop=='(') {
            return true;
        }
        return false;
    }
}
