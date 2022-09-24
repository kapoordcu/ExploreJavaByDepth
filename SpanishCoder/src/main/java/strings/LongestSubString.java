package strings;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class LongestSubString {
    public int lengthOfLongestSubstringOn(String s) {
        Set<Character> elements = new HashSet<>();
        int max = 0;
        int start = 0, end = 0;
        while (end < s.length()) {
            if(elements.contains(s.charAt(end))) {
                elements.remove(s.charAt(start++));
            } else {
                elements.add(s.charAt(end++));
                max = Math.max(max, elements.size());
            }
        }
        return max;
    }
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> uniqueSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char n = s.charAt(j);
                if(uniqueSet.contains(n)) {
                    j = s.length();
                } else {
                    uniqueSet.add(n);
                }
                max = Math.max(uniqueSet.size(), max);
            }
            uniqueSet.clear();
        }
        return max;
    }

    @Test
    public void test01() {
        int l1 = lengthOfLongestSubstringOn("abcabcbb");
        int l2 = lengthOfLongestSubstringOn("pwwkew");
        int l3 = lengthOfLongestSubstringOn("bbbb");
        assertTrue(l1==3);
        assertTrue(l2==3);
        assertTrue(l3==1);

    }
}
