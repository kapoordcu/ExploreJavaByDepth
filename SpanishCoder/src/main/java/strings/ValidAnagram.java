package strings;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s != null && t!= null) {
            List<Character> collect = s.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList());
            List<Character> collect2 = t.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList());
            return collect.equals(collect2);

        }
        return s==t ? true : false;
    }

    public boolean isAnagramUsingOn(String s, String t) {
        if(s == null || t==null) {
            return false;
        }
        int max_chars = 256;
        int[] sCount = new int[max_chars];
        int[] tCount = new int[max_chars];
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i)]++;
        }
        if(s.length()!=t.length()) {
            return false;
        }
        int c = 0;
        while (c< max_chars) {
            if(sCount[c] != tCount[c]) {
                return false;
            }
            c++;
        }
        return true;
    }

    @Test
    public void test01() {
        String s = "anagram", t = "nagaram";
        assertTrue(isAnagram(s, t));
        assertTrue(isAnagramUsingOn(s, t));
    }

    @Test
    public void test02() {
        String s = "rat", t = "cat";
        assertFalse(isAnagram(s, t));
        assertFalse(isAnagramUsingOn(s, t));
    }

    @Test
    public void test03() {
        String s = "anagram", t = null;
        assertFalse(isAnagram(s, t));
        assertFalse(isAnagramUsingOn(s, t));
    }
}
