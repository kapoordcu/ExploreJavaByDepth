package strings;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;

public class LongestPalindrome {
    int maxLength;
    int startFrom;
    public String longestPalindromeDP(String s) {
        maxLength = 0;
        startFrom = 0;
        if(s.length()<2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            expandRange(s, i, i);
            expandRange(s, i, i+1);
        }
        return s.substring(startFrom, startFrom + maxLength);
    }

    private void expandRange(String s, int begin, int end) {
        while(begin>=0 &&
                end<s.length() &&
                s.charAt(begin)==s.charAt(end)) {
            begin--;
            end++;
        }

        if(maxLength<end-begin-1) {
            maxLength = end-begin-1;
            startFrom = begin + 1;
        }
    }

    public int longestPalindrome(String s) {
        return lps(s, 0, s.length()-1);
    }

    public int lps(String s, int left, int right) {
        if(left==right) {
            return 1;
        }

        if(right == left+1 && s.charAt(left)==s.charAt(right)) {
            return 2;
        }

        if(s.charAt(left)==s.charAt(right)) {
            return 2 + lps(s, left+1, right-1);
        } else {
            return Math.max(lps(s, left+1, right), lps(s, left, right-1));
        }
    }

    @Test
    public void test01() {
        String s = "babad";
        assertTrue(longestPalindrome(s)==3);
        assertTrue(longestPalindromeDP(s).equals("bab"));
    }

    @Test
    public void test02() {
        String s = "cbbd";
        assertTrue(longestPalindrome(s)==2);
        assertTrue(longestPalindromeDP(s).equals("bb"));
    }
}
