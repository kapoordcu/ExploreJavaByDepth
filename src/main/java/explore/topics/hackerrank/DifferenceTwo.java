package explore.topics.hackerrank;

import java.util.List;
import java.io.*;
import java.util.*;


class Result {

    /*
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY m
     */

    public static int minimumMoves(List<Integer> a, List<Integer> m) {
        // Write your code here
        int sumTotal = 0;
        for (int i = 0; i < a.size(); i++) {
            int sumPerDigit = 0;
            int first = a.get(i);
            int second = m.get(i);
            String firstValue = String.valueOf(first);
            String secondValue = String.valueOf(second);
            boolean equalDigits = firstValue.length() == secondValue.length();
            if(!equalDigits) {
                System.out.println("Wrong input lengths");
                break;
            } else {
                for (int j = 0; j < firstValue.length(); j++) {
                    int difference = Math.abs(Integer.valueOf(firstValue.charAt(j))-
                            Integer.valueOf(secondValue.charAt(j)));
                    sumPerDigit += difference;
                }
            }

            sumTotal += sumPerDigit;
        }
        return sumTotal;
    }

}

public class DifferenceTwo {
    public static void main(String[] args) throws IOException {
        List<Integer> one = Arrays.asList(1234, 4321);
        List<Integer> second = Arrays.asList(2345, 3214);
        System.out.println(Result.minimumMoves(one, second));

    }
}