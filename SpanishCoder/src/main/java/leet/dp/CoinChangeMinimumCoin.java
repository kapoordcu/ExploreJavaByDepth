package leet.dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


import static org.junit.Assert.assertTrue;

public class CoinChangeMinimumCoin {
    public static int coinChangeTwoDim(int[] coins, int amount) {
        int n = coins.length;
        int[][] memorize = new int[n][amount+1];
        initializeBasicMem(coins, amount, n, memorize);
        for (int j = 1; j <= amount ; j++) {
            for (int i = 1; i < n; i++) {
                if(coins[i] > j) {
                    memorize[i][j] = memorize[i-1][j];
                } else {
                    int prev = memorize[i-1][j];
                    int newSumAfterTakingACoin = memorize[i][j-coins[i]];
                    if(newSumAfterTakingACoin == -1) {
                        memorize[i][j] = memorize[i-1][j];
                    } else if(prev == -1) {
                        memorize[i][j] = 1 + newSumAfterTakingACoin;
                    } else {
                        memorize[i][j] = Math.min(memorize[i-1][j], 1 + newSumAfterTakingACoin) ;
                    }
                }
            }
        }
        return memorize[coins.length-1][amount];
    }

    private static void initializeBasicMem(int[] coins, int amount, int n, int[][] memorize) {
        for (int j = 0; j <= amount; j++) {
            if(j % coins[0] == 0) {
                memorize[0][j] = j / coins[0];
            } else {
                memorize[0][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            memorize[i][0] = 0;
        }
    }

    public static int coinChangeOneDim(int[] coins, int amount) {
        int[] dpSum = new int[amount+1];
        Arrays.sort(coins);
        dpSum[0] = 0;
        for (int i = 1; i < dpSum.length; i++) {
            dpSum[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <=amount ; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i >= coins[j]) {
                    int remaining = dpSum[i-coins[j]];
                    if(remaining != Integer.MAX_VALUE && remaining + 1 < dpSum[i]) {
                        dpSum[i] = remaining + 1;
                    }
                }
            }
        }
        return dpSum[amount];
    }

    @Test
    public void solution0() {
        int[] arr = {1, 5, 6, 9};
        int amount = 11;
        int min = coinChangeOneDim(arr, amount);
        int min2 = coinChangeTwoDim(arr, amount);
        assertTrue(min==2);
        assertTrue(min2==2);
    }

    @Test
    public void solution7() {
        int[] arr = {1, 2, 3};
        int amount = 7;
        int min2 = coinChangeTwoDim(arr, amount);
        assertTrue(min2==3);
    }

    @Test
    public void solution1() {
        int[] arr = {5, 10, 25};
        int amount = 30;
        int min = coinChangeOneDim(arr, amount);
        int min2 = coinChangeTwoDim(arr, amount);
        assertTrue(min==2);
        assertTrue(min2==2);
    }

    @Test
    public void solution3() {
        int[] arr = {2, 5, 6, 9};
        int amount = 11;
        int min = coinChangeOneDim(arr, amount);
        int min2 = coinChangeTwoDim(arr, amount);
        assertTrue(min==2);
        assertTrue(min2==2);
    }

    @Test
    public void solution2() {
        int[] arr = {4, 6, 9,25};
        int amount = 41;
        int min = coinChangeOneDim(arr, amount);
        int min2 = coinChangeTwoDim(arr, amount);
        assertTrue(min==4);
        assertTrue(min2==4);
    }
}
/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1


Example 2:
Input: coins = [2], amount = 3
Output: -1


Example 3:
Input: coins = [1], amount = 0
Output: 0


Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */