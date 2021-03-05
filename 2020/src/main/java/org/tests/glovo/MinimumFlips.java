package org.tests.glovo;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class MinimumFlips {

    public int solution(int[] A) {
        // write your code in Java SE 8
        StringBuilder originalNumber = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            originalNumber.append(A[i]);
        }
        int numbnerStarting0 = getFlipsRequired(originalNumber.toString(), 0);
        int numbnerStarting1 = getFlipsRequired(originalNumber.toString(), 1);
        return Math.min(numbnerStarting0, numbnerStarting1);
    }

    private int getFlipsRequired(String originalNumber, int start) {
        int flips = 0;
        for (int i = 0; i < originalNumber.length(); i++) {
            if(Integer.parseInt(originalNumber.substring(i, i+1)) != start) {
                flips++;
            }
            start = (start==1? 0:1);
        }
        return flips;
    }

    @Test
    public void set1() {
        int[] A = {1,0,1,0,1,1};
        MinimumFlips depth = new MinimumFlips();
        int widest = depth.solution(A);
        assertTrue(widest==1);
    }

    @Test
    public void set2() {
        int[] A = {1,1,0,1,1};
        MinimumFlips depth = new MinimumFlips();
        int widest = depth.solution(A);
        assertTrue(widest==2);
    }

    @Test
    public void set3() {
        int[] A = {0,1,0};
        MinimumFlips depth = new MinimumFlips();
        int widest = depth.solution(A);
        assertTrue(widest==0);
    }

    @Test
    public void set4() {
        int[] A = {0,1,1,0};
        MinimumFlips depth = new MinimumFlips();
        int widest = depth.solution(A);
        assertTrue(widest==2);
    }
}
