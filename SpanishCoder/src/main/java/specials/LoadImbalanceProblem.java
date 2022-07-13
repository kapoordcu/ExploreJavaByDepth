package specials;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoadImbalanceProblem {


    @Test
    public void testOne() {
        int[] weights = {1,3,6};
        int combis = LoadImbalanceProblem.findComibations(weights, 3);
        assertTrue(combis==5);
    }

    @Test
    public void testTwo() {
        int[] weights = {1, 2, 4, 6};
        int combis = LoadImbalanceProblem.findComibations(weights, 3);
        assertTrue(combis==8);
    }

    @Test
    public void testNullArray() {
        int[] weights = null;
        int combis = LoadImbalanceProblem.findComibations(weights, 3);
        assertTrue(combis==0);
    }

    @Test
    public void testEmptyArray() {
        int[] weights = new int[0];
        int combis = LoadImbalanceProblem.findComibations(weights, 3);
        assertTrue(combis==0);
    }
    private static int findComibations(int[] weights, int k) {
        if(weights == null || weights.length == 0) {
            return 0;
        }
        int total = 0;
        int i = 0, j = 0;
        int min = 0, max = 0;
        int size = weights.length;
        while (i < size) {
            j = i;
            min = weights[i];
            max = weights[j];
            while (j < size) {
                min = Math.min(min, weights[j]);
                max = Math.max(max, weights[j]);
                if(max-min<=k) {
                    total++;
                }
                j++;
            }
            i++;
        }
        return total;
    }

}
