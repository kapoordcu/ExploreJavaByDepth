package org.dp.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Given a string and a dictionary of words, determine if string can be segmented
 * into a space-separated sequence of one or more dictionary words.
 */
public class WordBreak {

    @Test
    public void wbTest3() {
        List<String> dict = Arrays.asList("this", "th", "is", "famous", "Word",
                "break", "b", "r", "e", "a", "k", "br",
                "bre", "brea", "ak", "problem");
        String str = "Wordbreakproblem";
        assertTrue(checkWordBreak(str, dict));
        Map<String, Boolean> memorizationMap = new HashMap<>();
        assertTrue(checkWordBreakMemo(str, dict, memorizationMap));
        assertTrue(checkWordBreakTabular(str, dict));
    }

    @Test
    public void wbTest1() {
        String input = "code";
        List<String> keys  = List.of("c", "od", "e", "x");
        assertTrue(checkWordBreak(input, keys));

        Map<String, Boolean> memorizationMap = new HashMap<>();
        assertTrue(checkWordBreakMemo(input, keys, memorizationMap));

        assertTrue(checkWordBreakTabular(input, keys));
    }


    @Test
    public void wbTest2() {
        String input = "code";
        List<String> keys  = List.of("c", "od", "m", "x");
        assertFalse(checkWordBreak(input, keys));

        Map<String, Boolean> memorizationMap = new HashMap<>();
        assertFalse(checkWordBreakMemo(input, keys, memorizationMap));

        assertFalse(checkWordBreakTabular(input, keys));
    }

    private boolean checkWordBreakMemo(String str, List<String> keys, Map<String, Boolean> memorizationMap) {
        if(str.length()==0) { return true;}
        if(memorizationMap.containsKey(str)) {
            return memorizationMap.get(str);
        }
        for (int i = 1; i <= str.length(); i++) {
            if(keys.contains(str.substring(0, i))
                    && checkWordBreakMemo(str.substring(i), keys, memorizationMap)) {
                memorizationMap.put(str.substring(i), true);
                return true;
            }
        }
        memorizationMap.put(str, false);
        return false;
    }

    private boolean checkWordBreakTabular(String input, List<String> keys) {
        boolean[] dp = new boolean[input.length()+1];
        dp[0] = true;
        for (int len = 1; len <= input.length(); len++) {
            for (int i = 0; i < len; i++) {
                if(dp[i] && keys.contains(input.substring(i, len))) {
                    dp[len] = true;
                }
            }
        }
        return dp[input.length()];
    }

    private boolean checkWordBreak(String input, List<String> keys) {
        if(input.length()==0) {
            return true;
        }
        for (int i = 1; i <= input.length(); i++) {
            String prefix = input.substring(0, i);
            if(keys.contains(prefix) && checkWordBreak(input.substring(i), keys)) {
                return true;
            }
        }
        return false;
    }
}
