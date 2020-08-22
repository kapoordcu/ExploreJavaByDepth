package org.dp.problems;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ReachNFromZero {
    public int steps(int n) {
        int[] saveSteps = new int[n+1];
        saveSteps[0]=0;
        for (int i = 1; i < n+1; i++) {
            if(i%2==0) {
                saveSteps[i] = Math.min(saveSteps[i-1], saveSteps[i/2]) + 1;
            } else {
                saveSteps[i] = saveSteps[i-1] + 1;
            }
        }
        return saveSteps[n];
    }

    @Test
    public void factRecursionN5R5() {
        int n = 9;
        int result = 5;
        int calc = steps(n);
        assertTrue(calc==result);
    }

    @Test
    public void factRecursionN16R5() {
        int n = 16;
        int result = 5;
        int calc = steps(n);
        assertTrue(calc==result);
    }
}
