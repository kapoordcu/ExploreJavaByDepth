package org.check24;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class Palindrome {
    public static int countPalindrome(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                StringBuilder tempReverse = new StringBuilder(substring).reverse();
                if(tempReverse.toString().compareTo(substring) == 0) {
                    count++;
                    tempReverse.setLength(0);
                }
            }
        }
        return count;
    }

    @Test
    public void testPalindrome1() {
        int count = Palindrome.countPalindrome("abaac");
        assertEquals(count, 7);
    }

    @Test
    public void testPalindrome2() {
        int count = Palindrome.countPalindrome("aaa");
        assertEquals(count, 6);
    }

    @Test
    public void testPalindrome3() {
        int count = Palindrome.countPalindrome("abcdef");
        assertEquals(count, 6);
    }
}
