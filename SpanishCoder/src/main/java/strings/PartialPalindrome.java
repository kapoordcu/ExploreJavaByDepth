package strings;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PartialPalindrome {
    public boolean isPalindrome(String s) {
        String plainStr = removeRedundantChars(s).toLowerCase();
        int start = 0;
        int end = plainStr.length();
        while (end>=0 && start< plainStr.length() && start<end) {
            if(plainStr.charAt(start) != plainStr.charAt(end-1)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private String removeRedundantChars(String s) {
        return s.replaceAll("[^a-zA-Z0-9]", "");
    }

    @Test
    public void test01() {
        String s = "A man, a plan, a canal: Panama";
        assertTrue(isPalindrome(s));
    }

    @Test
    public void test02() {
        String s = "race a car";
        assertFalse(isPalindrome(s));
    }
}
