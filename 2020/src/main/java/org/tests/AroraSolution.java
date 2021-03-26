package org.tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AroraSolution {

    public int solution(int [][] A) {
        int result = 0;
        int row = A.length;
        int column = A[0].length;

        if(row ==1 && column ==1) {
            return 1;
        }
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(A[i][j] != Integer.MIN_VALUE) {
                    result++;
                    markAllDirection(A, i, j,A[i][j]);
                }
            }
        }
        return result;
    }

    public void markAllDirection(int [][]A ,int i, int j,int curr) {
        int row = A.length;
        int column = A[0].length;
        if(i< row && j < column) {
            A[i][j] = Integer.MIN_VALUE;
        }
        if(i < 0 || i >= row || j <0||j>=column) {
            return;
        }

        if((i < row-1 ) && A[i+1][j] == curr) {
            int tempRow = A[i+1][j];
            A[i+1][j]= Integer.MIN_VALUE;
            markAllDirection(A, i+2, j,tempRow);
            markAllDirection(A, i+1, j+1,tempRow);
            markAllDirection(A, i, j+1,tempRow);
        }

        if((j < column-1 ) && A[i][j+1] == curr) {
            int tempColumn = A[i][j+1];
            A[i][j+1]= Integer.MIN_VALUE;
            markAllDirection(A, i, j+2,tempColumn);
            markAllDirection(A, i+1, j+1,tempColumn);
            markAllDirection(A, i+1, j,tempColumn);
        }
    }


    @Test
    public void one() {
        int[][] A = {
                {5, 4, 4},
                {4, 3, 4},
                {3, 2, 4},
                {2, 2, 2},
                {3, 3, 4},
                {1, 4, 4},
                {4, 1, 1}
        };
        AroraSolution countriesCount = new AroraSolution();
        assertTrue(countriesCount.solution(A)==11);
    }

    @Test
    public void two() {
        int[][] A = {
                {5, 4, 4},
                {4, 3, 4}
        };
        AroraSolution countriesCount = new AroraSolution();
        assertTrue(countriesCount.solution(A)==3);
    }

    @Test
    public void three() {
        int[][] A = {
                {5, 4, 4},
                {4, 3, 4},
                {3, 2, 4}
        };
        AroraSolution countriesCount = new AroraSolution();
        assertTrue(countriesCount.solution(A)==6);
    }
}
