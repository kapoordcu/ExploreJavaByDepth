package org.tests;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class FindNumberMul {

    public static void main(String[] args) {
        final Set<String> set2;
       final Set<String> set =new HashSet<>( Arrays.asList("one", "twpo"));
       set.add("89");
       set.remove("one");
    }
    public int solution(int D, String S) {
        Map<String, Integer> mapping = new HashMap<>();
        mapping.put("one", 1);
        mapping.put("two", 2);
        mapping.put("three", 3);
        mapping.put("four", 4);
        mapping.put("five", 5);

        if(mapping.containsKey(S.toLowerCase())) {
            return D*mapping.get(S.toLowerCase());
        }
        // write your code in Java SE 8
        return D;
    }

    @Test
    public void three() {
        int[][] A = {
                {5, 4, 4},
                {4, 3, 4},
                {3, 2, 4}
        };
        AroraSolution countriesCount = new AroraSolution();
        assertTrue(countriesCount.solution(A)==6);
    }
}
