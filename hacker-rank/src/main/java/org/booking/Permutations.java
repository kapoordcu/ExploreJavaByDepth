package org.booking;

import org.junit.Test;

import java.util.*;
import static org.junit.Assert.assertTrue;

public class Permutations {

    static String[] findCombis(char[] chars,int length){
        List<String> combis = new ArrayList<>();
        StringBuilder singleCombination = new StringBuilder();
        if(chars.length!=0) {
            for (int i = 0; i < chars.length; i++) {
                char candidate = chars[i];
                char[] remainingChar = findOtherChar(chars, candidate);
                String[] combinations = findCombis(remainingChar, --length);
                for (String combi : combinations) {
                    singleCombination.append(candidate + combi);
                    if(singleCombination.length()==length) {
                        combis.add(singleCombination.toString());
                    }
                }
            }
            return (String[])combis.toArray();
        }
        return (String[])combis.toArray();
    }

    private static char[] findOtherChar(char[] chars, char candidate) {
        char[] charsClone = new char[chars.length-1];
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]!=candidate) {
                charsClone[i-1] = chars[i];
            }
        }

        return charsClone;
    }

    @Test
    public void testA() {
        char[] arr = {'a', 'b', 'c'};
        int length = 3;
        String[] combis = findCombis(arr, length);
        assertTrue(combis.length==6);
        assertTrue(Arrays.asList(combis).contains("abc"));
        assertTrue(Arrays.asList(combis).contains("acb"));
        assertTrue(Arrays.asList(combis).contains("bca"));
        assertTrue(Arrays.asList(combis).contains("bac"));
        assertTrue(Arrays.asList(combis).contains("cab"));
        assertTrue(Arrays.asList(combis).contains("cba"));
    }
}

