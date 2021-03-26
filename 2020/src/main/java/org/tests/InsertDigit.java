package org.tests;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class InsertDigit {
    public int solution(int N) {
        StringBuilder result = new StringBuilder();
        String originalNumber = String.valueOf(N);

        if(Integer.parseInt(originalNumber)<0) {
            result.append(originalNumber.charAt(0)).append(5).append(originalNumber.substring(1));
        } else {
            for (int i = 0; i < originalNumber.length(); i++) {
                int number = Integer.parseInt(originalNumber.substring(i, i+1));
                if(number < 5) {
                    result.append(5);
                    result.append(originalNumber.substring(i));
                    break;
                } else {
                    result.append(number);
                    continue;
                }
            }
        }

        return Integer.parseInt(result.toString());
    }

    @Test
    public void set1() {
        int N = 268;
        InsertDigit depth = new InsertDigit();
        int widest = depth.solution(N);
        assertTrue(widest==5268);
    }

    @Test
    public void set2() {
        int N = 670;
        InsertDigit depth = new InsertDigit();
        int widest = depth.solution(N);
        assertTrue(widest==6750);
    }

    @Test
    public void set3() {
        int N = 0;
        InsertDigit depth = new InsertDigit();
        int widest = depth.solution(N);
        assertTrue(widest==50);
    }

    @Test
    public void set4() {
        int N = -999;
        InsertDigit depth = new InsertDigit();
        int widest = depth.solution(N);
        assertTrue(widest==-5999);
    }
}
