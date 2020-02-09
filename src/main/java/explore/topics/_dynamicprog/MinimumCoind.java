package explore.topics._dynamicprog;

import java.util.Arrays;

public class MinimumCoind {
    private static int coinCount = 0;
    public static void main(String[] args) {
        MinimumCoind coins = new MinimumCoind();
        int[] D1 = { 1, 2, 5, 10, 20, 50, 100, 200, 500};
        coins.greedyApproach(D1, 43);
        System.out.println(coinCount);

        int[] D2 = { 5, 9, 6, 1 };
        int[] D3 = { 4, 3, 1};
        System.out.println(coins.findMinimumCoinsRandomArray(D2, 17));
        System.out.println(coins.findMinimumCoinsRandomArray(D2, 11));
        System.out.println(coins.findMinimumCoinsRandomArray(D2, 9));
        System.out.println(coins.findMinimumCoinsRandomArray(D2, 10));
        System.out.println(coins.findMinimumCoinsRandomArray(D3, 7));

    }

    private int findMinimumCoinsRandomArray(int[] coins, int amount) {
        int V = amount + 1;
        int table[] = new int[V];

        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;
        for (int i = 1; i < V; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < table[i]) {
                        table[i] = sub_res + 1;
                    }
                }
            }
        }
        return table[V-1];
    }

    private int floor(int[] A, int value) {
        int highest = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            if(A[i] < value) {
                highest = Math.max(highest, A[i]);
            }
        }
        return highest;
    }

    private void greedyApproach(int[] A, int amt) {
        while(amt!=0) {
            amt = selectMax(A, A.length - 1, 0, amt);
        }
    }

    private int selectMax(int[] A, int end, int start, int amt) {
        int i = end;
        while (i>=start) {
            while (A[i] > amt) {
                if(A[i]/amt==0) {
                    coinCount = A[i]/amt;
                    return 0;
                } else {
                    i--;
                }
            }
            amt -= A[i];
            coinCount++;
            i=start-1;
        }
        return amt;
    }
}
