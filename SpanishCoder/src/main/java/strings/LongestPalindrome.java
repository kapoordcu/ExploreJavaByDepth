package strings;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        return null;
    }

    @Test
    public void test01() {
        String s = "babad";
        assertTrue(longestPalindrome(s)=="bab");
    }

    @Test
    public void test02() {
        String s = "cbbd";
        assertTrue(longestPalindrome(s)=="bb");
    }
}
