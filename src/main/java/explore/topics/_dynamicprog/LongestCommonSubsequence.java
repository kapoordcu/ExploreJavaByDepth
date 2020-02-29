package explore.topics._dynamicprog;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        LongestCommonSubsequence commonSubsequence = new LongestCommonSubsequence();
        String A = "abcdefghij";
        String B = "ecdgi";
        System.out.println(commonSubsequence.LCSUsingRecursion(A, B, 0, 0));
        System.out.println(commonSubsequence.LCSUsingDP(A, B, A.length(), B.length()));
    }

    /**
     *
        Exponential Time taking problem
     */
    private int LCSUsingRecursion(String A, String B, int i, int j) {
        if(i>= A.length() || j>=B.length()) {
            return 0;
        } else if(A.charAt(i) == B.charAt(j)) {
            return  1 + LCSUsingRecursion(A, B, i+1, j+1);
        } else {
            return Math.max(LCSUsingRecursion(A, B, i+1, j), LCSUsingRecursion(A, B, i, j+1));
        }
    }

    /**
     *
     Dynamic Programminhg
     */
    private int LCSUsingDP(String A, String B, int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (A.charAt(i)==B.charAt(j)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        System.out.println(findSubSequence(memo, A, B, m, n));
        return memo[A.length() - 1][B.length() - 1];
    }

    private String findSubSequence(int[][] memo, String A, String B, int m, int n) {
        StringBuilder builder = new StringBuilder();
        int i = m-1;
        int j = n-1;
        while (i>0 && j>0) {
            if(A.charAt(i)==B.charAt(j)) {
                builder.append(A.charAt(i));
                i--;
                j--;
            } else if(memo[i-1][j] > memo[i][j-1]){
                i--;
            } else {
                j--;
            }
        }
        return builder.reverse().toString();
    }
}
