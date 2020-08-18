package explore.topics._arrays;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Add1ToArrayDigits {
    @Test
    public void addOne() {
        int[] number = {1, 2, 3};
        int[] plusOne = addOneImpl(number);
        assertTrue(plusOne[0]==1);
        assertTrue(plusOne[1]==2);
        assertTrue(plusOne[2]==4);
    }

    @Test
    public void addOne2() {
        int[] number = {1, 2, 9};
        int[] plusOne = addOneImpl(number);
        assertTrue(plusOne[0]==1);
        assertTrue(plusOne[1]==3);
        assertTrue(plusOne[2]==0);
    }

    @Test
    public void addOne3() {
        int[] number = {9, 9};
        int[] plusOne = addOneImpl(number);
        assertTrue(plusOne[0]==1);
        assertTrue(plusOne[1]==0);
        assertTrue(plusOne[2]==0);
    }

    private int[] addOneImpl(int[] number) {
        for (int i = number.length-1; i >=0 ; i--) {
            if(number[i] < 9) {
                number[i]++;
                return number;
            }
            number[i] = 0;
        }

        int[] result = new int[number.length+1];
        result[0] = 1;
        return result;
    }
}
