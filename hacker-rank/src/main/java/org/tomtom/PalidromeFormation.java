package org.tomtom;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalidromeFormation {

    public String solution(String S) {
        StringBuilder result = new StringBuilder(S.length());
        if(S==null || S.length()==0) {
            return "NO";
        }
        for(int i=0, j=S.length()-1; i< j ; i++, j--)  {
            if(S.charAt(i) == '?' && S.charAt(j) == '?') {
                result.append('a');
            } else if(S.charAt(i) == '?' && S.charAt(j) != '?') {
                result.append(S.charAt(j));
            } else if(S.charAt(i) != '?' && S.charAt(j) == '?') {
                result.append(S.charAt(i));
            } else if(S.charAt(i) == S.charAt(j)) {
                result.append(S.charAt(i));
            } else {
                return "NO";
            }
        }
        if(S.length()%2 !=0) {
            return result.toString() + S.charAt(S.length()/2) + result.reverse().toString();
        }
        return result + result.reverse().toString();
    }

    @Test
    public void test01() {
        String s = "?ab??a";

        String yes = solution(s);
        assertTrue(!yes.isEmpty());
        assertEquals(yes, "aabbaa");
    }

    @Test
    public void test02() {
        String s = "bab??a";

        String yes = solution(s);
        assertTrue(!yes.isEmpty());
        assertEquals(yes, "NO");
    }

    @Test
    public void test03() {
        String s = "?a?";

        String yes = solution(s);
        assertTrue(!yes.isEmpty());
        assertEquals(yes, "aaa");
    }
}
