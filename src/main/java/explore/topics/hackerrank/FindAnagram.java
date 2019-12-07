package explore.topics.hackerrank;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertTrue;

public class FindAnagram {

    @Test
    public void usingSorting_O_nLogn() {
        String a = "Gaurav";
        String b = "avGaur";
        char first[] = a.toCharArray();
        char second[] = b.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        assertTrue(Arrays.equals(first, second));
    }

    @Test
    public void usingPlusMinus_auxilarryArray_O_N_O_1() {
        String a = "Gaurav";
        String b = "avGaur";
        int count[] = new int[256];
        for (int i = 0; i < a.length() && i< b.length(); i++) {
            count[a.charAt(i)] ++;
            count[b.charAt(i)] --;
        }
        assertTrue(Arrays.equals(count, new int[256]));
    }

    @Test
    public void usingBitwise_O_N_O_1() {
        String a = "Gaurav";
        String b = "avGaur";
        assertTrue(a.length() == b.length());
        int value = 0;
        for (int i = 0; i < a.length(); i++) {
            value ^= a.charAt(i);
            value ^= b.charAt(i);
        }
        assertTrue(value==0);
    }
}
