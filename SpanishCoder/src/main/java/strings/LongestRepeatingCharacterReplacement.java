package strings;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int maxFreq = 0;
        int l = 0;
        int r = 0;
        Map<Character, Integer> alphaMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            alphaMap.put((char)(65+i), 0);
        }

        while (r<s.length()) {
            char ch = s.charAt(r);
            Integer freq = alphaMap.get(ch) + 1;
            alphaMap.put(ch, freq);
            maxFreq = Math.max(maxFreq, freq);
            if((r-l+1) - maxFreq <=k) {
                maxLen = Math.max(maxLen, r-l+1);
                r++;
            } else {
                l++;
            }

        }
        return maxLen;
    }

    @Test
    public void test01() {
        int maxLen = characterReplacement("ABABCB", 2);
        assertTrue(maxLen==5);
    }

    @Test
    public void test02() {
        int maxLen = characterReplacement("AAAA", 2);
        assertTrue(maxLen==4);
    }

    @Test
    public void test03() {
        int maxLen = characterReplacement("ABCA", 2);
        assertTrue(maxLen==4);
    }
}
