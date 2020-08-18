package explore.topics._dynamicprog;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class MinimumCoind {
    @Test
    public void DP() {
        int[] A0 = { 1, 5, 6, 8};
        int[] A1 = { 1, 2, 5, 10, 20, 50, 100, 200, 500};

        int[] D2 = { 5, 9, 6, 1 };
        int[] D3 = { 4, 3, 1};

        int coins = selectByDP(A0, 11);
        assertTrue(coins==2); // WRONG (6,5) not (8,1,1)

        coins = selectByDP(A1, 43);
        assertTrue(coins==4);

        coins = selectByDP(D2, 9);
        assertTrue(coins==1);

        coins = selectByDP(D3, 10);
        assertTrue(coins==3);
    }

    private int selectByDP(int[] coins, int amt) {
        int w = amt + 1;

        int[] dp = new int[w];
        Arrays.sort(coins);
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < w; j++) {
                if(coins[i] <= j) {
                    dp[j] = Math.min(1 + dp[j-coins[i]], dp[j]);
                }
            }
        }
        return  dp[w-1];
    }


    @Test
    public void greedy() {
        int[] A0 = { 1, 5, 6, 8};
        int[] A1 = { 1, 2, 5, 10, 20, 50, 100, 200, 500};

        int coins = selectMaxGreedy(A0, A0.length - 1, 11);
        assertTrue(coins==4); // WRONG (6,5) not (8,1,1)

        coins = selectMaxGreedy(A1, A1.length - 1, 43);
        assertTrue(coins==4);
    }

    private int selectMaxGreedy(int[] A, int high, int amt) {
        int coins = 0;
        for (int i = high; i >= 0 ; i--) {
            if(amt/A[i]!=0) {
                int coinsCurrentDenomination = amt/A[i];
                amt -= coinsCurrentDenomination*A[i];

                coins += coinsCurrentDenomination;
                if(amt==0) {
                    return coins;
                }
            }
        }
        return (amt!=0) ? -1 : coins;
    }

}
