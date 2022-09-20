package dp;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class StaircaseProblem {

    @Test
    public void testStaircase0() {
        int steps = finMinStepsToReachTop(5);
        assertTrue(steps==3);
    }

    @Test
    public void testStaircase1() {
        int steps = finMinStepsToReachTop(8);
        assertTrue(steps==4);
    }

    private int finMinStepsToReachTop(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i-2] + 1, dp[i-1] + 1);
        }
        return dp[n];
    }
}
