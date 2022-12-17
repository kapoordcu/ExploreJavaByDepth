package org.zalando;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrefixAndSuffix {
    @Test
    public void test01() {
       String s = "aabcdaabc";
        int solution = PrefixAndSuffix.solution(s);
        assertEquals(solution, 4);
    }

    @Test
    public void test04() {
        String s = "aadcaabd";
        int solution = PrefixAndSuffix.solution(s);
        assertEquals(solution, 2);
    }
    @Test
    public void test02() {
        String s = "aaaa";
        int solution = PrefixAndSuffix.solution(s);
        assertEquals(solution, 3);
    }

    @Test
    public void test03() {
        String s = "codility";
        int solution = PrefixAndSuffix.solution(s);
        assertEquals(solution, 0);
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
                    tempArray[j] = 0;
                    j++;
                } else {
                    i = tempArray[i-1];
                }
            }
        }
        return tempArray[n-1];
    }
    /*


        if s[end_prefix] != s[end_suffix]:
            if end_suffix != n-1:
                end_suffix = n-1  # reset end_suffix
            else:
                end_prefix -= 1
        else:
            end_suffix -= 1
            end_prefix -= 1

    # The longest common suffix and prefix is s[end+1:]
    return n-end_suffix-1
     */
}
