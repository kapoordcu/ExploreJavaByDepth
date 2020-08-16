package explore.topics._dynamicprog;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ReachNFromZero {
    public int steps(int n) {
        int[] saveSteps = new int[n];
        saveSteps[0]=1;
        for (int i = 1; i < n; i++) {
            if(i%2!=0) {
                saveSteps[i] = Math.min(saveSteps[i-1], saveSteps[i/2]) + 1;
            } else {
                saveSteps[i] = saveSteps[i-1] + 1;
            }
        }
        return saveSteps[n-1];
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
