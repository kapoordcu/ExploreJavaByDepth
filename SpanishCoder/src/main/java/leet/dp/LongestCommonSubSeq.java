package leet.dp;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class LongestCommonSubSeq {

    /*
        Time Complexity: O(mn).
        As nested loop is used.
        Auxiliary Space: O(mn).
        Use of any array to store LCS values at each index.
    */
    private String LCSmxn(String text1, String text2) {
        char[][] lcs = new char[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            lcs[i][0] = text1.charAt(i-1);
        }

        for (int i = 1; i <= text2.length(); i++) {
            lcs[0][i] = text2.charAt(i-1);
        }
        for (int i = 1; i < lcs.length; i++) {
            for (int j = 1; j < lcs[i].length; j++) {
                if(lcs[i][0]==lcs[0][j]) {
                    lcs[i][j] = '1';
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = lcs.length - 1; i > 0 ; i--) {
            for (int j = lcs[i].length - 1; j > 0 ; j--) {
                if(lcs[i][j] == '1') {
                    builder.append(lcs[i][0]);
                }
            }
        }
        return builder.reverse().toString();
    }

    @Test
    public void solution0() {
        String text1 = "abcde", text2 = "ace";
        String lcs = LCSmxn(text1, text2);
        assertTrue("ace".equals(lcs));
    }

    @Test
    public void solution1() {
        String text1 = "abc", text2 = "abc";
        String lcs = LCSmxn(text1, text2);
        assertTrue("abc".equals(lcs));
    }



    @Test
    public void solution2() {
        String text1 = "abc", text2 = "def";
        String lcs = LCSmxn(text1, text2);
        assertTrue("".equals(lcs));
    }

}

/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.



Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.


Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
 */
