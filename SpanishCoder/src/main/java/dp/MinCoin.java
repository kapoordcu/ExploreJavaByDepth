package dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class MinCoin {
    static int minCoins(int a[], int total, int[] dp) {
        if(total==0) {
            return 0;
        }
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if(total - a[i] >= 0) {
                int subAns = 0;
                if(dp[total-a[i]] != -1) {
                    subAns = dp[total-a[i]];
                } else {
                    subAns = minCoins(a, total-a[i], dp);
                }
                if(subAns != Integer.MAX_VALUE
                        && subAns + 1 < answer) {
                    answer = subAns + 1;
                }
            }
        }
        return dp[total] = answer;
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
