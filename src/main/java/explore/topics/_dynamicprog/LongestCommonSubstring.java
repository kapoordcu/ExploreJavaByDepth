package explore.topics._dynamicprog;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class LongestCommonSubstring {

    /**
     *
     Time Complexity: O(m*n)
     Auxiliary Space: O(m*n)
     */
    private int lcsubstr(char[] A, char[] B) {
        int m = A.length + 1;
        int n = B.length + 1;

        int[][] memo = new int[m][n];
        int max = Integer.MIN_VALUE;

        for(int i=1; i < m; i++){
            for(int j=1; j < n; j++){
                if(A[i-1] == B[j-1]){
                    memo[i][j] = memo[i-1][j-1] +1;
                    if(memo[i][j] > max) {
                        max = memo[i][j];
                    }
                }
            }
        }
        return max;
    }

    @Test
    public void test1() {
        String a = "ABCDGH";
        String b = "ACDGHR";
        int lcs = lcsubstr(a.toCharArray(), b.toCharArray());
        assertEquals(4, lcs);
    }

    @Test
    public void test2() {
        String a = "abcdaf";
        String b = "zbcdf";
        int lcs = lcsubstr(a.toCharArray(), b.toCharArray());
        assertEquals(3, lcs);
    }
}
