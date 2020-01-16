package explore.topics._codingproblmes2020;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReversePolishNotation {
    private static String[] expression = {"2", "1", "+", "3", "*"};
    private static String[] operator = {"+", "-", "*", "\\"};
    private static Pattern p = Pattern.compile("\\d");

    public static void main(String[] args) {
        System.out.println(ReversePolishNotation.calculate(expression));
    }

    private static double calculate(String[] expression) {
        Stack<String> stack = new Stack<>();
        for(String s: expression) {
            Matcher matcher = p.matcher(s);
            if(matcher.find()) {
                stack.push(matcher.group());
            } else {
                Double v1 = Double.parseDouble(stack.pop());
                Double v2 = Double.parseDouble(stack.pop());
                String miniExpression = calculateMini(s, v1, v2);
                stack.push(miniExpression);
            }
        }
        return Double.valueOf(stack.pop());
    }

    private static String calculateMini(String symbol, double a, double b) {
        if(symbol.equalsIgnoreCase("+")) {
            return String.valueOf(a + b);
        } else if(symbol.equalsIgnoreCase("-")) {
            return String.valueOf(b - a);
        } else if(symbol.equalsIgnoreCase("*")) {
            return String.valueOf(a * b);
        } else if(symbol.equalsIgnoreCase("/")) {
            return String.valueOf(b / a);
        }
        return "0";
    }
}
