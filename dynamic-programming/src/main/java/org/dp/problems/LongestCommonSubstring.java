package org.dp.problems;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LongestCommonSubstring {

    /**
     *
     Time Complexity: O(m*n)
     Auxiliary Space: O(m*n)
     */
    private String lcsubstr(char[] A, char[] B) {
        int mX = A.length + 1;
        int mY = B.length + 1;
        int table[][] = new int[mX][mY];
        int len = 0;
        int row = 0, col = 0;
        for (int i = 1; i < mX; i++) {
            for (int j = 1; j < mY; j++) {
                if(A[i-1]==B[j-1]) {
                    table[i][j] = 1 + table[i-1][j-1];
                    if (len < table[i][j]) {
                        len = table[i][j];
                        row = i;
                        col = j;
                    }
                }
            }
        }
        String resultStr = new String();
        while (table[row][col] != 0) {
            resultStr = A[row-1] + resultStr;
            --len;
            row--;
            col--;
        }
        return resultStr;
    }

    @Test
    public void test1() {
        String a = "ABCDGH";
        String b = "ACDGHR";
        String lcs = lcsubstr(a.toCharArray(), b.toCharArray());
        assertTrue(lcs.equals("CDGH"));
        assertEquals(4, lcs.length());
    }

    @Test
    public void test2() {
        String a = "abcdaf";
        String b = "zbcdf";
        String lcs = lcsubstr(a.toCharArray(), b.toCharArray());
        assertTrue(lcs.equals("bcd"));
        assertEquals(3, lcs.length());
    }
}
