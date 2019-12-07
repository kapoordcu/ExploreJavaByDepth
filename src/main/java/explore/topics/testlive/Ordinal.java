package explore.topics.testlive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class Ordinal {

    public static void main(String[] args) {
        Ordinal or = new Ordinal();
       or.addOne(new int[]{});


    }


    int spiderMove(int x, int y) {

        x = Math.abs(x);
        y = Math.abs(y);

        int[] n = new int[x + 1];
        for (int i = 0; i < x + 1; i++) {
            n[i] = 1;
        }

        for (int i = 0; i < y; i++) {
            for (int j = 1; j < x + 1; j++) {
                n[j] = n[j - 1] + n[j];
            }
        }
        return n[n.length-1];
    }

    String[] splitNumber(String number, int k) {
        List<String> bytes = new ArrayList<>();

        if(k>=number.length()) {
            return new String[] {number};
        }
        for (int i = 0; i < number.length();) {
            int endIndex = (i + k > number.length()) ? number.length() : i + k;
            String numByte = number.substring(i, endIndex).replaceFirst("^0+(?!$)", "");
            if(numByte.length()<k && (i!=number.length()-1)) {
                int takeDigits = k - numByte.length();
                numByte += number.substring(endIndex, endIndex + takeDigits);
                i += takeDigits;
            }
            i = i + k;
            bytes.add(numByte);
        }
        String[] endResult = new String[bytes.size()];
        return bytes.toArray(endResult);
    }

    String[] addBorder(String[] picture) {

        List<String> answer = new ArrayList<>();
        answer.add("");

        for (int i = 0; i < picture[0].length()+2; i++) {
            answer.set(0, answer.get(0) + "*");
        }

        for (int i = 0; i < picture.length; i++) {
            answer.add("*");
            for (int j = 0; j < picture[0].length(); j++) {
                answer.set(i + 1, answer.get(i + 1) + picture[i].charAt(j));
            }
            answer.set(i + 1, answer.get(i + 1) + "*");
        }

        answer.add(answer.get(0));

        return answer.toArray(new String[picture.length + 2]);
    }


    int[] addOne(int[] digits) {
        if(digits.length==0) {
            return new int[]{0};
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < digits.length; i++) {
            sb.append(digits[i]);
        }
        int value = Integer.parseInt(sb.toString()) + 1;
        return Integer.toString(value).chars().map(c -> c-'0').toArray();
    }


    public static String maskify(String creditCardNumber) {
        Pattern digitRegex = Pattern.compile("\\d");
        StringBuilder maskedStr = new StringBuilder();
        if(creditCardNumber.length()<6 || creditCardNumber==null) {
            return creditCardNumber;
        } else {
            maskedStr.append(creditCardNumber, 0, 1);
            maskedStr.append(creditCardNumber.substring(1, creditCardNumber.length()-4).replaceAll(digitRegex.pattern(), "#"));
            maskedStr.append(creditCardNumber.substring(creditCardNumber.length()-4));

        }
        return maskedStr.toString();
    }

    public static String ordinal(int number) {
        String ordinalStr = number + "th";
        int lastTwoDigits = number % 100;
        int lastSingleDigit = number % 10;
        if(lastSingleDigit == 1 && lastTwoDigits != 11) {
            ordinalStr =  number + "st";
        } else if(lastSingleDigit == 2 && lastTwoDigits != 12) {
            ordinalStr =  number + "nd";
        } else if(lastSingleDigit == 3 && lastTwoDigits != 13) {
            ordinalStr =  number + "rd";
        }
        return ordinalStr;
    }

    public double evaluate(String expr) {
        if(expr==null || expr.length()==0) {
            return 0.0;
        }
        String[] tokens = expr.trim().split(" ");
        Stack<String> stack = new Stack<String>();
        double returnValue = 0;
        String operators = "+-*/";
        for (String currentSymbol : tokens) {
            if (operators.contains(currentSymbol)) {
                double a = Double.valueOf(stack.pop());
                double b = Double.valueOf(stack.pop());
                pushToStack(stack, a, b, currentSymbol);
            } else {
                stack.push(currentSymbol);
            }
        }

        returnValue = Double.valueOf(stack.pop());

        return returnValue;
    }

    public void pushToStack(Stack<String> stack, double a, double b, String currentSymbol) {
        if(currentSymbol.equalsIgnoreCase("+")) {
            stack.push(String.valueOf(a + b));
        } else if(currentSymbol.equalsIgnoreCase("-")) {
            stack.push(String.valueOf(b - a));
        } else if(currentSymbol.equalsIgnoreCase("*")) {
            stack.push(String.valueOf(a * b));
        } else if(currentSymbol.equalsIgnoreCase("/")) {
            stack.push(String.valueOf(b / a));
        }
    }

}
