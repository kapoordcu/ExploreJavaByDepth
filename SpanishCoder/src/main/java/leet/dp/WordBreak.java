package leet.dp;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordBreak {
    Set<String> dictionary = new HashSet<>();

    private boolean wordBreakPossibleTabularDP(String s, String[] wordDict) {
        dictionary = Stream.of(wordDict).collect(Collectors.toSet());
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length() ; i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if(dp[j] && dictionary.contains(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    private boolean wordBreakPossibleCached(String s, int pos, String[] wordDict, Map<String, Boolean> cache) {
        dictionary = Stream.of(wordDict).collect(Collectors.toSet());
        String word = s.substring(pos);
        if(word.isEmpty()) {
            return true;
        }
        if(cache.containsKey(word)) {
            return cache.get(word);
        }
        for (int i = pos; i < s.length(); i++) {
            word = s.substring(pos, i+1);
            if(dictionary.contains(word) &&
                    wordBreakPossibleRecursion(s, i+1, wordDict)) {
                cache.put(word, true);
                return true;
            }
        }
        return false;
    }

    private boolean wordBreakPossibleRecursion(String s, int pos, String[] wordDict) {
        dictionary = Stream.of(wordDict).collect(Collectors.toSet());
        String word = s.substring(pos);
        if(word.isEmpty()) {
            return true;
        }
        for (int i = pos; i < s.length(); i++) {
            word = s.substring(pos, i+1);
            if(dictionary.contains(word) &&
                    wordBreakPossibleRecursion(s, i+1, wordDict)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void ExampleABCD() {
        String s = "abcd";
        String[] wordDict = {"ab","bc","cd"};
        assertTrue(wordBreakPossibleRecursion(s, 0, wordDict));
        assertTrue(wordBreakPossibleCached(s, 0, wordDict, new HashMap<>()));
        assertTrue(wordBreakPossibleTabularDP(s, wordDict));
    }

    @Test
    public void Exampleleetcode() {
        String s = "leetcode";
        String[] wordDict = {"l","code","ee","t"};
        assertTrue(wordBreakPossibleRecursion(s, 0, wordDict));
        assertTrue(wordBreakPossibleCached(s, 0, wordDict, new HashMap<>()));
        assertTrue(wordBreakPossibleTabularDP(s, wordDict));
    }
    @Test
    public void Exampleabcd() {
        String s = "abcd";
        String[] wordDict = {"a","b","c","ab","bc","abc"};
        assertFalse(wordBreakPossibleRecursion(s, 0, wordDict));
        assertFalse(wordBreakPossibleCached(s, 0, wordDict, new HashMap<>()));
        assertFalse(wordBreakPossibleTabularDP(s, wordDict));
    }

    @Test
    public void Example1() {
        String s = "leetcode";
        String[] wordDict = {"leet","code"};
        assertTrue(wordBreakPossibleRecursion(s, 0, wordDict));
        assertTrue(wordBreakPossibleCached(s, 0, wordDict, new HashMap<>()));
        assertTrue(wordBreakPossibleTabularDP(s, wordDict));
    }

    @Test
    public void Example2() {
        String s = "applepenapple";
        String[] wordDict = {"apple","pen"};
        assertTrue(wordBreakPossibleRecursion(s, 0, wordDict));
        assertTrue(wordBreakPossibleCached(s, 0, wordDict, new HashMap<>()));
        assertTrue(wordBreakPossibleTabularDP(s, wordDict));
    }

    @Test
    public void Example3() {
        String s = "catsandog";
        String[] wordDict = {"cats","dog","sand","and","cat"};
        assertFalse(wordBreakPossibleRecursion(s, 0, wordDict));
        assertFalse(wordBreakPossibleCached(s, 0, wordDict, new HashMap<>()));
        assertFalse(wordBreakPossibleTabularDP(s, wordDict));
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
