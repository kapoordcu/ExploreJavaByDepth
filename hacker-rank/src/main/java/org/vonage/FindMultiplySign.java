package org.vonage;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FindMultiplySign {

    @Test
    public void testOne() {
        int[] arr1 = {-11, -5, 6};
        int solution = FindMultiplySign.multiplyArrayElement(arr1);
        assertEquals(solution, 1);
    }

    public static int multiplyArrayElement(int[] A) {
        int result = Arrays.stream(A).reduce(1, Math::multiplyExact);
        if(result == 0) {
            return 0;
        }
        return result > 0 ? 1 : -1;
    }
}
