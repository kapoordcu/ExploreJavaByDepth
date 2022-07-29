package leet.dp;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordBreak {
    Set<String> collect = new HashSet<>();
    @Test
    public void Example0() {
        String s = "abcd";
        String[] wordDict = {"a","b","c","ab","bc","bcd"};
        assertTrue(wordBreakPossible(s, 0, wordDict));
    }

    @Test
    public void Example1() {
        String s = "leetcode";
        String[] wordDict = {"leet","code"};
        assertTrue(wordBreakPossible(s, 0, wordDict));
    }

    @Test
    public void Example2() {
        String s = "applepenapple";
        String[] wordDict = {"apple","pen"};
        assertTrue(wordBreakPossible(s, 0, wordDict));
    }

    @Test
    public void Example3() {
        String s = "catsandog";
        String[] wordDict = {"cats","dog","sand","and","cat"};
        assertFalse(wordBreakPossible(s, 0, wordDict));
    }

    private boolean wordBreakPossible(String s, int start, String[] wordDict) {
        collect = Stream.of(wordDict).collect(Collectors.toSet());
        if (start == s.length()) {
            return true;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String word = s.substring(start, i);
            if (collect.contains(word) &&
                    wordBreakPossible(s, i, wordDict)) {
                return true;
            }
        }
        return false;
    }

}

/*

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false


Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
 */