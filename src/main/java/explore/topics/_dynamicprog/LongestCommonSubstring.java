package explore.topics._dynamicprog;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        LongestCommonSubstring commonSubstring = new LongestCommonSubstring();
        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";
        System.out.println(commonSubstring
                .findLongestCommonSubstring
                        (X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
    }

    /**
     *
     Time Complexity: O(m*n)
     Auxiliary Space: O(m*n)
     */
    private int findLongestCommonSubstring(char[] A, char[] B, int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        int result = 0;  //
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (A[i-1] == B[j-1]) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                    result = Integer.max(result, memo[i][j]);
                } else {
                    memo[i][j] = 0;
                }
            }
        }
        return result;
    }
}
