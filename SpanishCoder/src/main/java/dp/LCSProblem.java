package dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class LCSProblem {

    @Test
    public void testMinimumInsertionAndDeletion() {
        String a = "abcab";
        String b = "aecb";
        int minimumInsertion = convertS1toS2(a, b);
        assertTrue(minimumInsertion==3);
    }

    @Test
    public void testminLengthOfSuperSequence() {
        String a = "abcab";
        String b = "aecb";
        int minimumInsertion = minLengthOfSuperSequence(a, b);
        assertTrue(minimumInsertion==6);
    }

    private int convertS1toS2(String a, String b) {
        int lcs = lcsBottomUpnWithDPSpaceOptimized(a, b, a.length(), b.length());
        return a.length() - lcs + b.length() - lcs;
    }

    private int minLengthOfSuperSequence(String a, String b) {
        int lcs = lcsBottomUpnWithDPSpaceOptimized(a, b, a.length(), b.length());
        return lcs +  a.length() - lcs + b.length() - lcs;
    }

    @Test
    public void testLCSProblem() {
        String a = "abcab";
        String b = "aecb";
        int lcsLength = lcsTopDownRecursion(a, b, a.length(), b.length());
        int lcsLength2 = lcsTopDownRecursionWithDP(a, b, a.length(), b.length());
        int lcsLength3 = lcsBottomUpnWithDP(a, b, a.length(), b.length());
        int lcsLength4 = lcsBottomUpnWithDPSpaceOptimized(a, b, a.length(), b.length());
        assertTrue(lcsLength==3);
        assertTrue(lcsLength2==3);
        assertTrue(lcsLength3==3);
        assertTrue(lcsLength4==3);
    }

    private int lcsBottomUpnWithDPSpaceOptimized(String a, String b, int m, int n) {
        int[] top = new int[m+1];
        int[] bottom = new int[m+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                if(b.charAt(i)==a.charAt(j)) {
                    bottom[j+1] = top[j] + 1;
                } else {
                    bottom[j+1] = Math.max(top[j], bottom[j]);
                }
            }
            top = Arrays.copyOf(bottom, bottom.length);
        }
        return bottom[m];
    }

    private int lcsBottomUpnWithDP(String a, String b, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        return lcsBottomUpnWithDP(a, b, m, n, dp);
    }

    private int lcsBottomUpnWithDP(String a, String b, int m, int n, int[][] dp) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(
                            dp[i-1][j], dp[i][j-1]
                    );
                }
            }
        }
        return dp[m][n];
    }
    private int lcsTopDownRecursionWithDP(String a, String b, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <=n ; j++) {
                dp[i][j] = -1;
            }
        }
        return lcsTopDownRecursion(a, b, m, n, dp);
    }

    private int lcsTopDownRecursion(String a, String b, int m, int n, int[][] dp) {
        if(m==0 || n == 0) return 0;
        if(dp[m][n] != -1) {
            return dp[m][n];
        }
        if(a.charAt(m-1)== b.charAt(n-1)) {
            return dp[m][n] = 1 + lcsTopDownRecursion(a, b, m-1, n-1, dp);
        } else {
            return dp[m][n] = Math.max(
                    lcsTopDownRecursion(a, b, m, n-1, dp),
                    lcsTopDownRecursion(a, b, m-1, n, dp)
            );
        }
    }

    private int lcsTopDownRecursion(String a, String b, int m, int n) {
        if(m==0 || n==0) {
            return 0;
        }
        if(a.charAt(m-1) == b.charAt(n-1)) {
            return 1 + lcsTopDownRecursion(a, b, m-1, n-1);
        } else {
            return Math.max(lcsTopDownRecursion(a, b, m-1, n), lcsTopDownRecursion(a, b, m, n-1));
        }
    }

}
