package explore.topics._dynamicprog;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LongestPalindromeSubstring {
    public int len = 0;
    public int indexStart = 0;
    public static void main(String[] args) {
        LongestPalindromeSubstring substring = new LongestPalindromeSubstring();
        String str = "abaabc";
        String str2 = "jingolnkiddikng";

        substring.findPalidromeSubstringN2ON(str);
        System.out.println();
        substring.findPalidromeSubstringN2O1(str2);
        System.out.println();
        substring.findPalidromeSubstringN2ON(str);
        System.out.println();
        substring.findPalidromeSubstringN2O1(str2);
        System.out.println();

    }

    @Test
    public void test1() {
        String a = "geeksforgeeks";
        String lps = longestPalidromeSubstr(a);
        assertTrue(lps.equals("ee"));


        String a2 = "geekskeeg";
        String lps2 = longestPalidromeSubstr(a2);
        assertTrue(lps2.equals("geekskeeg"));
    }

    private String longestPalidromeSubstr(String str) {
        if(str==null || str.length() < 2) {
            return str;
        }

        for (int start = 0; start < str.length()-1; start++) {
            expandRange(str, start, start);
            expandRange(str, start, start+1);
        }
        return str.substring(indexStart, indexStart+len);
    }

    private void expandRange(String str, int begin, int end) {
        while(begin>=0 && end<=str.length() &&
                str.charAt(begin)==str.charAt(end)) {
            --begin;
            ++end;
        }
        if(len < end-begin-1) {
            len = end-begin-1;
            indexStart = begin +1;
        }
    }

    /**
     * We can find the longest palindrome substring in (n^2) time with O(1) extra space.
     * The idea is to generate all even length and odd length palindromes and keep track
     * of the longest palindrome seen so far.
     */

    /**
     * Time complexity: O ( n^2 )
     * Auxiliary Space: O ( 1 )
     */
    private void findPalidromeSubstringN2O1(String str) {
        int n = str.length();
        int start = 0;
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            int low = i-1;
            int high = i;
            while (low>=0 && high<n && str.charAt(low)==str.charAt(high)) {
                if(high - low + 1>maxLength) {
                    start = low;
                    maxLength = high-low+1;
                }
                --low;
                ++high;
            }

            low = i-1;
            high = i + 1;
            while (low>=0 && high<n && str.charAt(low)==str.charAt(high)) {
                if(high - low + 1>maxLength) {
                    start = low;
                    maxLength = high-low+1;
                }
                --low;
                ++high;
            }
        }
        System.out.print("Longest palindrome substring is of length " +
                maxLength + " and is " + str.substring(start, start + maxLength));
    }

    /**
     * Time complexity: O ( n^2 )
     * Auxiliary Space: O ( n^2 )
     */
    private void findPalidromeSubstringN2ON(String str) {
        int maxLength = 1;
        int start = 0;
        int N = str.length();
        boolean[][] DP = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            DP[i][i] = true;
        }
        for (int i = 0; i < N-1; i++) {
            if(str.charAt(i)==str.charAt(i+1)) {
                DP[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int len = 3; len <= N ; len++) {
            for (int i = 0; i < N-len+1; i++) {
                int j = i + len -1;
                if(str.charAt(i)==str.charAt(j) &&
                        DP[i+1][j-1]==true)    {
                    DP[i][j] = true;
                    if(len>maxLength) {
                        maxLength = len;
                        start = i;
                    }
                }
            }
        }
        System.out.print("Longest palindrome substring is of length " +
                maxLength + " and is " + str.substring(start, start + maxLength));
    }
}
