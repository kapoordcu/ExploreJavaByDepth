package org.zalando;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class PrefixAndSuffix {
    @Test
    public void test00() {
        String s = "aabaa";
        int solution = PrefixAndSuffix.solution(s);
        int solutionNormal = PrefixAndSuffix.solutionNormal(s);
        assertEquals(solutionNormal, 2);
        assertEquals(solution, 2);
    }
    @Test
    public void test01() {
       String s = "aabcdaabc";
        int solution = PrefixAndSuffix.solution(s);
        int solutionNormal = PrefixAndSuffix.solutionNormal(s);
        assertEquals(solutionNormal, 4);
        assertEquals(solution, 4);
    }

    @Test
    public void test04() {
        String s = "aadcaabd";
        int solution = PrefixAndSuffix.solution(s);
        int solutionNormal = PrefixAndSuffix.solutionNormal(s);
        assertEquals(solutionNormal, 0);
        assertEquals(solution, 0);
    }
    @Test
    public void test02() {
        String s = "aaaa";
        int solution = PrefixAndSuffix.solution(s);
        int solutionNormal = PrefixAndSuffix.solutionNormal(s);
        assertEquals(solutionNormal, 3);
        assertEquals(solution, 3);
    }

    @Test
    public void test03() {
        String s = "codility";
        int solution = PrefixAndSuffix.solution(s);
        int solutionNormal = PrefixAndSuffix.solutionNormal(s);
        assertEquals(solutionNormal, 0);
        assertEquals(solution, 0);
    }

    public static int solutionNormal(String S) {
        Set<String> wordSet = new HashSet<>();
        int maxLen = 0;
        for (int i = 0; i < S.length(); i++) {
            String word = S.substring(0, i + 1);
            wordSet.add(word);
        }
        for (int i = S.length()-1; i >=0 ; i--) {
            String word = S.substring(i );
            if(wordSet.contains(word) &&
                    word.length() < S.length())  {
                maxLen = Math.max(maxLen, word.length());
            }
        }
        return maxLen;
    }

    public static int solution(String S) {
        if(S==null){
            return 0;
        }
        int n = S.length();
        int[] tempArray = new int[n];
        int i = 0;
        int j = 1;
        while (j<n) {
            if(S.charAt(i) == S.charAt(j)) {
                tempArray[j] = i + 1;
                i++;
                j++;
            } else {
                if(i==0) {
                    j++;
                } else {
                    i = tempArray[i-1];
                }
            }
        }
        return tempArray[n-1];
    }
}
