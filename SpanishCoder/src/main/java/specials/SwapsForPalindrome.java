package specials;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class SwapsForPalindrome {
    private static int swaps = 0;


    private static int minimumSwapsNeededForMakingAStringPalindrome(String str) {
        int size = str.length();
        char[] charArray = str.toCharArray();
        int i = 0;
        int j = size -1 ;

        return 0;
    }

    private static int swapsForPalindrome(String str) {
        if(diffIsOddForEvenDigits(str)) {
            return -1;
        }
        int size = str.length();
        char[] charArray = str.toCharArray();
        int i = 0;
        int j = size -1 ;
        while (i<j) {
            if(charArray[i] != charArray[j]) {
                String newStr = findMatchingCharAndSwap(charArray, i, j);
                return swapsForPalindrome(newStr);
            } else {
                i++; j--;
            }
        }
        return swaps;
    }

    private static boolean diffIsOddForEvenDigits(String str) {
        Map<Character, Integer> characterCounts = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            characterCounts.merge(str.charAt(i), 1, (oldV, newV) -> oldV +1);
        }
        Integer zero = characterCounts.getOrDefault('0', 0);
        Integer one = characterCounts.getOrDefault('1', 0);
        if(str.length()%2==0 && Math.abs(zero-one)%2==0) {
            return true;
        }
        return false;
    }

    private static String findMatchingCharAndSwap(char[] charArray, int l, int r) {
        char matching = charArray[l];
        for (int i = r; i > l ; i--) {
            if(charArray[i] == matching) {
                swaps++;
                return swapAndReturnSubString(charArray, i, l, r);
            }
        }
        return null;
    }

    private static String swapAndReturnSubString(char[] charArray, int i, int l, int r) {
        char c = charArray[i];
        charArray[i] = charArray[r];
        charArray[r] = c;
        return createSubString(charArray, l+1, r-1);
    }

    private static String createSubString(char[] charArray, int l, int r) {
        StringBuilder builder = new StringBuilder();
        for (int i = l; i <= r; i++) {
            builder.append(charArray[i]);
        }
        return builder.toString();
    }

    @Test
    public void testHj() {
        swaps = 0;
        String evenNumbers = "1001010";
        int swaps = SwapsForPalindrome.swapsForPalindrome(evenNumbers);
        assertTrue(swaps==1);
    }

    @Test
    public void testOne() {
        swaps = 0;
        String evenNumbers = "10101";
        int swaps = SwapsForPalindrome.swapsForPalindrome(evenNumbers);
        assertTrue(swaps==0);
    }

    @Test
    public void testAlreadyPalindrom1() {
        swaps = 0;
        String str = "1111";
        int swaps = SwapsForPalindrome.swapsForPalindrome(str);
        assertTrue(swaps==0);
    }

    @Test
    public void testAlreadyPalindrom2() {
        swaps = 0;
        String str = "1010";
        int swaps = SwapsForPalindrome.swapsForPalindrome(str);
        assertTrue(swaps==1);
    }

    @Test
    public void testEvenDifference() {
        swaps = 0;
        String str = "0001";
        int swaps = SwapsForPalindrome.swapsForPalindrome(str);
        assertTrue(swaps==-1);
    }

    @Test
    public void testNotPossible() {
        swaps = 0;
        String str = "1001010";
        int swaps = SwapsForPalindrome.swapsForPalindrome(str);
        assertTrue(swaps==1);
    }

    @Test
    public void testNotPossible2() {
        swaps = 0;
        String str = "1101";
        int swaps = SwapsForPalindrome.swapsForPalindrome(str);
        assertTrue(swaps==-1);
    }
}
