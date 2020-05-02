package org.vonage;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Siblings {

    public static int solution(int N) {
        String numberString = Integer.toString(N);
        int maxDigitValue = 0;
        int leftShift = 1;
        int freqArray[] = new int[10];

        for(int i=0; i <  numberString.length(); i++) {
            freqArray[numberString.charAt(i)-'0']++;
        }

        for (int i = 0; i <10; i++) {
            while (freqArray[i] > 0) {
                maxDigitValue = maxDigitValue + (i * leftShift);
                leftShift = leftShift * 10;
                freqArray[i]--;
            }
        }
        return maxDigitValue;
    }

    @Test
    public void testOne() {
        int solution = Siblings.solution(213);
        assertEquals(solution, 321);
    }

    @Test
    public void testTwo() {
        int solution = Siblings.solution(553);
        assertEquals(solution, 553);
    }
}
