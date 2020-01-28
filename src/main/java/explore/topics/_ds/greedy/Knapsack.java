package explore.topics._ds.greedy;

import explore.topics.design.factory.Wallet;

public class Knapsack {
    public static void main(String[] args) {
        Knapsack kn = new Knapsack();
        int profits[] = new int[]{60, 100, 120};
        int wts[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = profits.length;
        System.out.println(kn.knspNaive(W, wts, profits, n-1));
        System.out.println(kn.knspSmart(W, wts, profits, n));
    }

    //  Time Complexity: O(nW) where n is the number of items and W is the capacity of knapsack.
    public int knspSmart(int W, int[] wts, int[] profits, int N) {
        int[][] K = new int[N+1][W+1];
        for (int i = 0; i <=N ; i++) {
            for (int w = 0; w <= W; w++) {
                if(i==0 || w==0) {
                    K[i][w] = 0;
                } else if(wts[i-1]> W) {
                    K[i][w] = K[i-1][w];
                } else {
                    K[i][w] = Math.max(
                            profits[i-1] + K[i-1][W-wts[i-1]],
                            K[i-1][w]
                    );
                }
            }
        }
        return K[N][W];
    }

    //  Time complexity of this naive recursive solution is exponential (2^n).
    public int knspNaive(int W, int[] wts, int[] profits, int n) {
        if(W==0 || n==0) {
            return 0;
        }
        if(wts[n-1]>W) {
            // If weight of the nth item is more than Knapsack capacity W,
            // then this item cannot be included in the optimal solution
            return knspNaive(W, wts, profits, n-1);
        } else {
            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
            return Math.max(profits[n]+knspNaive(W-wts[n], wts, profits, n-1),
                    knspNaive(W, wts, profits, n-1));
        }
    }
}
