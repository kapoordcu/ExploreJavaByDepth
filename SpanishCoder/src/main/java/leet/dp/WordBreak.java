package leet.dp;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordBreak {
    Set<String> dictionary = new HashSet<>();
    @Test
    public void Example0() {
        String s = "abcd";
        String[] wordDict = {"a","b","c","ab","bc","abc"};
        assertFalse(wordBreakPossibleRecursion(s, 0, wordDict));
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
    public void Example1() {
        String s = "leetcode";
        String[] wordDict = {"leet","code"};
        assertTrue(wordBreakPossibleRecursion(s, 0, wordDict));
    }

    @Test
    public void Example2() {
        String s = "applepenapple";
        String[] wordDict = {"apple","pen"};
        assertTrue(wordBreakPossibleRecursion(s, 0, wordDict));
    }

    @Test
    public void Example3() {
        String s = "catsandog";
        String[] wordDict = {"cats","dog","sand","and","cat"};
        assertFalse(wordBreakPossibleRecursion(s, 0, wordDict));
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
