package org.dp.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class FactorialDP {
    List<Integer> dpCache = new ArrayList<>();

    public int factorialRecurssion(int n) {
        if(n==0) {
            return 1;
        } else {
            return n*factorialRecurssion(n-1);
        }
    }

    public int factorialTopDown(int n) {
        if(n==0) {
            return 1;
        } else {
            int fact = n*factorialTopDown(n-1);
            dpCache.add(fact);
            return fact;
        }
    }

    //Tabulation Method – Bottom Up Dynamic Programming
    //dp table is being populated sequentially and we are directly
    // accessing the calculated states from the table itself and hence,
    // we call it tabulation method.
    public int factorialDPBottomUp(int n) {
        int dpp[] = new int[n+1];// 0  1  2  3  4
        dpp[0]=1;
        for (int i = 1; i <= n; i++) {
            dpp[i] = i * dpp[i-1];
        }
        return dpp[n];
    }



    @Test
    public void factRecursion() {
        int n = 9;
        int result = 362880;
        int xR = factorialDPBottomUp(n);
        int xDP_TD = factorialTopDown(n);
        int xDP_BT = factorialRecurssion(n);
        assertTrue(xR==result);
        assertTrue(xDP_TD==result);
        assertTrue(xDP_BT==result);
    }
}
