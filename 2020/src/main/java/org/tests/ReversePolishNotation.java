package org.tests;

import org.junit.Test;
import java.util.Stack;

import static org.junit.Assert.assertTrue;

public class ReversePolishNotation {
    public double evaluate(String expr) {
        if(expr==null || expr.length()==0) {
            return 0d;
        }
        Stack<Double> temporaryStack = new Stack<>();
        String[] symbols = expr.split("\\s+");
        Double upper = 0d;
        Double lower = 0d;
        for (String sym: symbols) {
            switch (sym) {
                case "+" :
                    temporaryStack.push(temporaryStack.pop() + temporaryStack.pop());
                    break;
                case "-" :
                    lower = temporaryStack.pop();
                    upper = temporaryStack.pop();
                    temporaryStack.push(upper - lower);
                    break;
                case "*" :
                    temporaryStack.push(temporaryStack.pop() * temporaryStack.pop());
                    break;
                case "/" :
                    lower = temporaryStack.pop();
                    upper = temporaryStack.pop();
                    temporaryStack.push(upper/lower);
                    break;
                default:
                    temporaryStack.push(Double.parseDouble(sym));
            }

        }
        return temporaryStack.pop();
    }

    @Test
    public void set1() {
        ReversePolishNotation polishNotation = new ReversePolishNotation();
        Double aDouble = polishNotation.evaluate("1 2 3.5");
        assertTrue(3.5 == aDouble);
    }

    @Test
    public void set2() {
        ReversePolishNotation polishNotation = new ReversePolishNotation();
        Double aDouble = polishNotation.evaluate("10000 123 +");
        assertTrue(10123 == aDouble);
    }

    @Test
    public void set3() {
        ReversePolishNotation polishNotation = new ReversePolishNotation();
        Double aDouble = polishNotation.evaluate("5 1 2 + 4 * + 3 -");
        assertTrue(14 == aDouble);
    }
}
