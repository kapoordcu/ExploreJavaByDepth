package org.vonage;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DoubleSumDigit {

    @Test
    public void testOne2() {
        int N = 14;
        int solution = DoubleSumDigit.doubleSumDigit(N);
        assertEquals(solution, 19);
    }

    @Test
    public void testOne3() {
        int N = 99;
        int solution = DoubleSumDigit.doubleSumDigit(N);
        assertEquals(solution, 9999);
    }

    @Test
    public void testOne4() {
        int N = 10;
        int solution = DoubleSumDigit.doubleSumDigit(N);
        assertEquals(solution, 11);
    }

    public static int doubleSumDigit(int N) {
        int totalSUm = sumDigits(N);
        int requiredSum = 2*totalSUm;
        int start = N + 1;
        while(true) {
            int sum = sumDigits(start);
            if( sum == requiredSum) {
                return start;
            }
            start++;
        }
    }

    public static int sumDigits(int number) {
        return String.valueOf(number)
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }

}
