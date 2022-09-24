package strings;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        int have = 0;
        int need = t.length();
        int l = 0;
        int r = 0;

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            countT.compute(t.charAt(i), (k,v) -> v==null? 1 : v+1);
        }

        for (r = 0; r < s.length(); r++) {
           char c = s.charAt(r);
           window.compute(c, (k,v) -> v==null? 1 : v+1);
           if(countT.containsKey(c) && window.get(c)<=countT.get(c)) {
               have++;
           }
           while (have == need) {
               minLen = Math.min(minLen, r-l+1);
               char lh = s.charAt(l);
               window.put(lh, window.get(lh)-1);
               if(countT.containsKey(lh) &&
                       window.get(lh) < countT.get(lh)) {
                   have--;
               }
               l++;
           }
        }
        return s.substring(l-1, r);
    }

    @Test
    public void test01() {
        String l1 = minWindow("ADOBECODEBANC", "ABC");
        assertTrue(l1.equals("BANC"));
        String l2 = minWindow("a", "a");
        assertTrue(l2.equals("a"));
        String l3 = minWindow("a", "aa");
        assertTrue(l3.equals(""));
        String l4 = minWindow("aa", "aa");
        assertTrue(l4.equals("aa"));
        String l5 = minWindow("aaaaaa", "aa");
        assertTrue(l5.equals("aa"));
    }
}
