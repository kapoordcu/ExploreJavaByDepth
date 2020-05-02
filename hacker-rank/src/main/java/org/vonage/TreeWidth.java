package org.vonage;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class TreeWidth {

    public static int solution(int[] X, int[] Y) {
        int maxX = IntStream.of(X).max().getAsInt();
        int maxY = IntStream.of(Y).max().getAsInt();
        int[][] grid = new int[maxX][maxY];
        if(X.length!=Y.length) {
            return 0;
        }

        for (int i = 0; i < X.length; i++) {
            int x = X[i];
            int y = Y[i];
            grid[x-1][y-1] = 1;
        }

        return 0;
    }

    public static int solution2(int []X, int [] Y) {
        int [] copyArray = X;
        Arrays.sort(copyArray);

        int left = copyArray[0];
        int right = copyArray[X.length-1];

        int i = 0;
        int k = X.length-1;

        while(i<k) {
            if((X[i] >= left) &&(X[i] <= right)) {
                int leftDiff = X[i]-left;
                int rightDiff = right - X[i];
                if(leftDiff < rightDiff) {
                    left = X[i];
                } else {
                    right = X[i];
                }
            }
            i++;
        }
        return (right-left);
    }

    @Test
    public void testThree() {
        int[] X = {1,8,7,3,4,1,8};
        int[] Y = {6,4,1,8,5,1,7};
        int solution = TreeWidth.solution2(X, Y);
        assertEquals(solution, 3);
    }

    @Test
    public void testTwo() {
        int[] X = {5,5,5,7,7,7};
        int[] Y = {3,4,5,1,3,7};
        int solution = TreeWidth.solution2(X, Y);
        assertEquals(solution, 2);
    }

    @Test
    public void testFour() {
        int[] X = {6,10,1,4,3};
        int[] Y = {2,5,3,1,6};
        int solution = TreeWidth.solution2(X, Y);
        assertEquals(solution, 4);
    }

    @Test
    public void testThreee2() {
        int[] X = {4,1,5,4};
        int[] Y = {4,5,1,3};
        int solution = TreeWidth.solution2(X, Y);
        assertEquals(solution, 3);
    }
}
