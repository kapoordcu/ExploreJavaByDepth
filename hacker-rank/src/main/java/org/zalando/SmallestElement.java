package org.zalando;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmallestElement {
    @Test
    public void testOne2() {
        int A[] = {1, -2, 6, -9};
        int solution = SmallestElement.solution(A);
        assertEquals(solution, -9);
    }

    @Test
    public void testOne1() {
        int A[] = {1, 2, 6, 9};
        int solution = SmallestElement.solution(A);
        assertEquals(solution, 1);
    }

    @Test
    public void testOne3() {
        int A[] = {-1, -2, -6, -9};
        int solution = SmallestElement.solution(A);
        assertEquals(solution, -9);
    }

    private static int solution(int[] A) {

        int ans = A[0];
        for (int i = 1; i < A.length; i++) {
            if (ans > A[i]) {
                ans = A[i];
            }
        }
        return ans;
    }
}
