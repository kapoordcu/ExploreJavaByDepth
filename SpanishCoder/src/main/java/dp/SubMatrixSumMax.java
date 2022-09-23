package dp;

import arrays.KadaneProblem;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class SubMatrixSumMax {
    private KadaneProblem kadane = new KadaneProblem();

    @Test
    public void test01() {
        int[][] M = {
                {1, -3, -2, 4},
                {-4, 5, -1, 2},
                {6, 0, 2, 7}
        };
        int maxSum = findMaxSumOfSubMatrix(M[0].length, M.length, M);
        assertTrue(maxSum==17);
    }

    @Test
    public void test001() {
        int[][] M = { { 0, -2, -7, 0 },
                { 9, 2, -6, 2 },
                { -4, 1, -4, 1 },
                { -1, 8, 0, -2 } };

        int maxSum = findMaxSumOfSubMatrix(M[0].length, M.length, M);
        assertTrue(maxSum==15);
    }
    @Test
    public void test02() {
        int[][] M = {
                {-1, -3, -2, -4},
                {-4, -5, -1, -2},
                {-6, 0, -2, -7}
        };
        int maxSum = findMaxSumOfSubMatrix(M[0].length, M.length, M);
        assertTrue(maxSum==0);
    }

    private int findMaxSumOfSubMatrix(int cols, int rows, int[][] M) {
        int soFarMax = Integer.MIN_VALUE;
        int dp[] = new int[rows];
        for (int start = 0; start < cols; start++) {
            Arrays.fill(dp, 0);
            for (int end = start; end < cols; end++) {
                for (int r = 0; r < rows; r++) {
                    dp[r] += M[r][end];
                }
                int kadaneSum = kadane.findKadaneSum(dp);
                soFarMax = Math.max(soFarMax, kadaneSum);
            }
        }
        return soFarMax;
    }
}
