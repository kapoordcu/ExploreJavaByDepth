package dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class MinCoin {
    static int minCoins(int coins[], int total, int[] dp) {
        if(total == 0) return 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if(total - coins[i] >= 0) {
                int subAnswer = 0;
                if(dp[total-coins[i]] != -1) {
                    subAnswer = dp[total-coins[i]];
                } else {
                    subAnswer = minCoins(coins, total - coins[i], dp);
                }
                if(subAnswer != Integer.MAX_VALUE &&
                        subAnswer + 1 < ans) {
                    ans = subAnswer + 1;
                }
            }
        }
        return dp[total] = ans;
    }

    @Test
    public void solution7() {
        int[] arr = {7, 5, 1};
        int amount = 18;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int min2 = minCoins(arr, amount, dp);
        assertTrue(min2==4);
    }

    @Test
    public void solution1() {
        int[] arr = {5, 10, 25};
        int amount = 30;

        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int min = minCoins(arr, amount, dp);
        assertTrue(min==2);
    }

    @Test
    public void solution3() {
        int[] arr = {2, 5, 6, 9};
        int amount = 11;

        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;


        int min = minCoins(arr, amount, dp);
        assertTrue(min==2);
    }

    @Test
    public void solution2() {
        int[] arr = {4, 6, 9,25};
        int amount = 41;

        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int min = minCoins(arr, amount, dp);
        assertTrue(min==4);
    }
}
