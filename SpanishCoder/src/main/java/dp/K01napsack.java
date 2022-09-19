package dp;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class K01napsack {

    @Test
    public void testKnapSack1() {
        int[] weights = {1, 3, 4, 6};
        int[] profits = {20, 30, 10, 50};
        int W = 10;

        int profit = knapSack(W, weights, profits);
        assertTrue(profit==100);
    }

    @Test
    public void testKnapSack2() {
        int[] weights = {1, 1, 1};
        int[] profits = {10, 20, 30};
        int W = 2;

        int profit = knapSack(W, weights, profits);
        assertTrue(profit==50);
    }

    @Test
    public void testKnapSack3() {
        int[] weights = {1, 2, 3};
        int[] profits = {10, 15, 40};
        int W = 6;

        int profit = knapSack(W, weights, profits);
        assertTrue(profit==65);
    }

    static int knapSack(int W, int weights[], int profits[]) {
        int[][] dp = new int[weights.length+1][W+1];
        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= W ; j++) {
                if(j >= weights[i-1]) {
                    dp[i][j] = Math.max(profits[i-1] + dp[i-1][j-weights[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[weights.length][W];
    }
}
