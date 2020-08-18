package explore.topics._strings;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ReverseString {
    @Test
    public void check1() {
        String str1 = "gaurav";
        String strRev = reverseStr(str1);
        assertTrue("varuag".equals(strRev));

        String str2 = "wow";
        String strRev2 = reverseStr(str2);
        assertTrue("wow".equals(strRev2));
    }

    private String reverseStr(String str1) {
        char[] temparray = str1.toCharArray();

        for (int i = 0, j=temparray.length-1; i < j; i++, j--) {
            char temp = temparray[i];
            temparray[i] = temparray[j];
            temparray[j]=temp;
        }
        return new String(temparray);
    }
}
