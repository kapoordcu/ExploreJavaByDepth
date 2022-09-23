package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class KadaneProblem {
    @Test
    public void test01() {
        int[] array = { 1, -3, 2, 1, -1};
        int sum = findKadaneSum(array);
        assertTrue(sum==3);
    }

    @Test
    public void test011() {
        int[] array = { -2, 11, -3, 7};
        int sum = findKadaneSum(array);
        assertTrue(sum==15);
    }

    @Test
    public void test02() {
        int[] array = { 1, -1, 2, -2, 0, -3};
        int sum = findKadaneSum(array);
        assertTrue(sum==2);
    }

    public int findKadaneSum(int[] array) {
        int globalSum = 0;
        int localSum = 0;
        for (int i = 1; i < array.length; i++) {
            localSum += array[i];
            if(localSum<0) {
                localSum = 0;
            }
            globalSum = Math.max(globalSum, localSum);
        }
        return Math.max(globalSum, localSum);
    }
}
