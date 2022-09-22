package dp;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class RodeCutProfitProblem {
    int maxProfit = 0;

    @Test
    public void testRode() {
        int amount = 8;
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] profits = {1, 5, 6, 9, 11, 12, 14, 16};
        int profitMax = findMaxProfit(numbers, profits);

        assertTrue(profitMax == 20);
    }

    private int findMaxProfit(int[] numbers, int[] profits) {
        int[] dp = new int[numbers.length+1];
        for (int i = 1; i <= numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], profits[j] + dp[i-j-1]);
            }
        }
        return dp[numbers.length];
    }
}
