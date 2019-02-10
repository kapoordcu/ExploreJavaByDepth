package explore.topics.hackerrank;

import java.util.Scanner;

public class PalindromeSum {

    public static void main(String[] args) {
        int lowerLimit = new Scanner(System.in).nextInt();
        int higherLimit = new Scanner(System.in).nextInt();

        calculateSum(lowerLimit, higherLimit);

    }

    private static void calculateSum(int lowerLimit, int higherLimit) {
        int sum = 0;
        for (int number = lowerLimit; number < higherLimit ; number++) {
            if(checkPalindrome(number)) {
                sum += number;
            }
        }
        System.out.println(sum);
    }

    public static boolean checkPalindrome(Integer value) {
        int reverseValue = 0;
        int currentValue = value;
        while (currentValue != 0) {
            int remainder = currentValue % 10;
            reverseValue = reverseValue * 10 + remainder;
            currentValue = currentValue / 10;
        }


        return value == reverseValue;

    }
}
