package org.zalando;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OCRSameText {

    @Test
    public void test01() {
        String S = "A2Le"; // A _ _ L e
        String T = "2pL1"; // _ _ p L _
        assertTrue(OCRSameText.solution(S, T));
    }

    @Test
    public void test011() {
        String S = "A1Le"; // A _ L e
        String T = "2L1";  // _ _ L _
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
        String T = "7";
        assertTrue(OCRSameText.solution(S, T));
    }

    public static boolean solution(String S, String T) {
        if(S.isEmpty() || T.isEmpty()) {
            return false;
        }
        List<Character> first = createPlaceHolderList(S);
        List<Character> second = createPlaceHolderList(T);
        if(first.size() != second.size()) {
            return false;
        }
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
