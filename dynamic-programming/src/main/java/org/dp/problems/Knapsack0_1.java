package org.dp.problems;

public class Knapsack0_1 {
    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;

        Knapsack0_1 kp = new Knapsack0_1();
        System.out.println(kp.findMaxProfitExponential(val, wt, W, val.length));
        System.out.println(kp.findMaxProfitDP(val, wt, W, val.length));
    }

    //  Time Complexity: O(nW) where n is the number of items and W is the capacity of knapsack.
    private int findMaxProfitDP(int[] val, int[] wt, int W, int N) {
        int[][] K = new int[N+1][W+1];
        for (int i = 0; i <=N ; i++) {
            for (int w = 0; w <= W; w++) {
                if(i==0 || w==0) {
                    K[i][w] = 0;
                } else if(wt[i-1]> W) {
                    K[i][w] = K[i-1][w];
                } else {
                    K[i][w] = Math.max(
                            val[i-1] + K[i-1][W-wt[i-1]],
                            K[i-1][w]
                    );
                }
            }
        }
        return K[N][W];
    }

    //  Time complexity of this naive recursive solution is exponential (2^n).
    private int findMaxProfitExponential(int[] val, int[] wt, int W, int n) {
        if(W==0 || n==0) {
            return 0;
        }
        if(wt[n-1]>W) {
            return findMaxProfitExponential(val, wt, W-wt[n-1], n-1);
        } else {
            return Math.max( (val[n-1] + findMaxProfitExponential(val, wt, W-wt[n-1], n-1)),
                    findMaxProfitExponential(val, wt, W, n-1)
            );

        }
    }

}
