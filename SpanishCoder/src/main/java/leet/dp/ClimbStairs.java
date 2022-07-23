package leet.dp;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class ClimbStairs {

    public static int climbStairs(int n) {
        int one = 1;
        int two = 1;
        for (int i = n - 1; i > 0 ; i--) {
            int t = one;
            one = one + two;
            two = t;
        }
        return one;
    }

    @Test
    public void target2() {
        int n = 2;
        int steps = ClimbStairs.climbStairs(n);
        assertTrue(steps==2);
    }

    @Test
    public void target3() {
        int n = 3;
        int steps = ClimbStairs.climbStairs(n);
        assertTrue(steps==3);
    }

    @Test
    public void target5() {
        int n = 5;
        int steps = ClimbStairs.climbStairs(n);
        assertTrue(steps==8);
    }

}

/*
70. Climbing Stairs
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


Constraints:

1 <= n <= 45
 */