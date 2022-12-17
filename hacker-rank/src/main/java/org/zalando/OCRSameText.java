package org.zalando;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OCRSameText {

    @Test
    public void test01() {
        String S = "A2Le";
        String T = "2pL1";
        assertTrue(OCRSameText.solution(S, T));
    }

    @Test
    public void test02() {
        String S = "a10";
        String T = "10a";
        assertTrue(OCRSameText.solution(S, T));
    }

    @Test
    public void test03() {
        String S = "ba1";
        String T = "1Ad";
        assertFalse(OCRSameText.solution(S, T));
    }

    @Test
    public void test04() {
        String S = "3x2x";
        String T = "8";
        assertFalse(OCRSameText.solution(S, T));
    }

    public static boolean solution(String S, String T) {
        if(S.isEmpty() || T.isEmpty()) {
            return false;
        }
        if(S.length() != T.length()) {
            return false;
        }
        List<Character> first = createPlaceHolderList(S);
        List<Character> second = createPlaceHolderList(T);
        for (int i = 0; i < first.size(); i++) {
            if(Character.isLetter(first.get(i)) &&
                    Character.isLetter(second.get(i))) {
                if(first.get(i) != second.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static List<Character> createPlaceHolderList(String s) {
        List<Character> placeholder = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            Boolean digit = Character.isDigit(curr);
            if(digit) {
                for (int j = 0; j < Character.getNumericValue(curr); j++) {
                    placeholder.add('?');
                }
            } else {
                placeholder.add(curr);
            }
        }
        return placeholder;
    }


}
