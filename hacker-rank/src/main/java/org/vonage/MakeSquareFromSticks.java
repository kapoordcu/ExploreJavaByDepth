package org.vonage;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MakeSquareFromSticks {
    @Test
    public void test0() {
        MakeSquareFromSticks s = new MakeSquareFromSticks();
        int solution = s.sticksmakingSquare(10, 21);
        assertEquals(solution, 7);
    }

    @Test
    public void test1() {
        MakeSquareFromSticks s = new MakeSquareFromSticks();
        int solution = s.sticksmakingSquare(13, 11);
        assertEquals(solution, 5);
    }

    @Test
    public void test2() {
        MakeSquareFromSticks s = new MakeSquareFromSticks();
        int solution = s.sticksmakingSquare(2, 1);
        assertEquals(solution, 0);
    }

    @Test
    public void test3() {
        MakeSquareFromSticks s = new MakeSquareFromSticks();
        int solution = s.sticksmakingSquare(1, 8);
        assertEquals(solution, 2);
    }

    public int sticksmakingSquare(int A, int B) {
        int max = Math.max(A, B);
        int[][] save = new int[2][max];
        fillSaveForStick(save[0], A);
        fillSaveForStick(save[1], B);
        for (int i = max; i > 0; i--) {
            if(save[0][i-1] + save[1][i-1] >= 4) {
                return i;
            }
        }
        return 0;
    }

    private void fillSaveForStick(int[] save, int value) {
        for (int i = 0; i < value; i++) {
            save[i] = value/(i+1);
        }
    }

}
