package org.tests;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class TreeDepth {

    public int solution(int[] X, int[] Y) {
        if(Y.length == 0 || (X.length != Y.length)) {
            return 0;
        }
        Arrays.sort(X);
        int widestPossiblePath = 0;
        for (int index = 1; index < X.length; index++) {
            int currentPossiblePath = X[index] - X[index-1];
            if(widestPossiblePath < currentPossiblePath) {
                widestPossiblePath = currentPossiblePath;
            }
        }
        return widestPossiblePath;

    }

    @Test
    public void set1() {
        int[] X = {1, 8, 7, 3, 4, 1, 8};
        int[] Y = {6, 4, 1, 8, 5, 1, 7};
        TreeDepth depth = new TreeDepth();
        int widest = depth.solution(X, Y);
        assertTrue(widest==3);
    }


    @Test
    public void set2() {
        int[] X = {5, 5, 5, 7, 7, 7};
        int[] Y = {3, 4, 5, 1, 3, 7};
        TreeDepth depth = new TreeDepth();
        int widest = depth.solution(X, Y);
        assertTrue(widest==2);
    }

    @Test
    public void set3() {
        int[] X = {6, 10, 1, 4, 3};
        int[] Y = {2, 5, 3, 1, 6};
        TreeDepth depth = new TreeDepth();
        int widest = depth.solution(X, Y);
        assertTrue(widest==4);
    }

    @Test
    public void set4() {
        int[] X = {4, 1, 5, 4};
        int[] Y = {4, 5, 1, 3};
        TreeDepth depth = new TreeDepth();
        int widest = depth.solution(X, Y);
        assertTrue(widest==3);
    }
}
