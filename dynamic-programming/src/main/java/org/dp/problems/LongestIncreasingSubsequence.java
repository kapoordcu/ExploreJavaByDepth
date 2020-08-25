package org.dp.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class LongestIncreasingSubsequence {

    /**
     * O(n*n) longest Increasing Sequence
     */
    public List<List<Integer>> calculateLIS(int[] arr) {
        int[] subsequenceDP = new int[arr.length];
        Arrays.fill(subsequenceDP, 1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j]<arr[i] && subsequenceDP[j] <= subsequenceDP[i]) {
                    subsequenceDP[i] = Math.max(subsequenceDP[j] + 1, subsequenceDP[i]);
                }
            }
        }
        int maxlengthOfSubsequence = 1;
        for (int i = 0; i < subsequenceDP.length; i++) {
            if(subsequenceDP[i] > maxlengthOfSubsequence) {
                maxlengthOfSubsequence = subsequenceDP[i];
            }
        }
        List<List<Integer>> subsequenceLIC = findSubsequence(arr, subsequenceDP, maxlengthOfSubsequence);
        return subsequenceLIC;
    }

    private List<List<Integer>> findSubsequence(int[] arr, int[] subsequenceDP, int maxlengthOfSubsequence) {
        List<List<Integer>> subseqList = new ArrayList<>();

        List<Integer> licList = new ArrayList<>();
        int next = 0;
        for (int i = 0; i < subsequenceDP.length; i++) {
            if(subsequenceDP[i] == next + 1) {
                licList.add(arr[i]);
                next += 1;
            }
        }
        return new ArrayList<>();
    }

    public static int[] LICLogN(int[] arr) {
        int[] LIC = new int[arr.length];
        Arrays.fill(LIC, Integer.MIN_VALUE);

        LIC[0] = arr[0];
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < LIC[0]) {
                LIC[0] = arr[i];
            } else if(arr[i] > LIC[max-1]) {
                LIC[max++] = arr[i];
            } else {
                int ceiling = findPosition(LIC, 0, max, arr[i]);
                LIC[ceiling] = arr[i];
            }
        }
        return Arrays.stream(LIC).filter(n-> n!=Integer.MIN_VALUE).toArray();
    }

    /**
     *
     Ceiling in a sorted array
     Given a sorted array and a value x, the ceiling of x is the smallest element in array greater
     than or equal to x, and the floor is the greatest element smaller than or equal to x.
     it requires log n time to find the ceiling
     */
    private static int findPosition(int[] LIC, int start, int end, int valueToInput) {
        while (end-start>1) {
            int mid  = start + (end-start)/2;
            if(LIC[mid]>=valueToInput) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return end;

    }

    @Test
    public void LICTest1() {
        int[] arr = {-2, 1, 0, 5, 6, 2, 3};
        List<List<Integer>> subsequence = calculateLIS(arr);
        assertTrue(subsequence.get(0).size()==4);
    }

    @Test
    public void LICTest1_LogN() {
        int[] arr = {-2, 1, 0, 5, 6, 2, 3};
        int subsequence[] = LongestIncreasingSubsequence.LICLogN(arr);
        assertTrue(subsequence.length==4);
    }

    @Test
    public void LICTest2() {
        int[] arr = {1, 3, 4, 5, 6, 5, 4, 7, 2, 7};
        List<List<Integer>> solution = calculateLIS(arr);
        assertTrue(solution.get(0).size()==6);
    }

    @Test
    public void LICTest2_LogN() {
        int[] arr = {1, 3, 4, 5, 6, 5, 4, 7, 2, 7};
        int subsequence[] = LongestIncreasingSubsequence.LICLogN(arr);
        assertTrue(subsequence.length==6);
    }

    @Test
    public void LICTestSingleElement() {
        int[] arr = {1};
        List<List<Integer>> solution = calculateLIS(arr);
        assertTrue(solution.get(0).size()==1);
    }

    @Test
    public void LICTestSingleElement_LogN() {
        int[] arr = {1};
        int solution[] = LongestIncreasingSubsequence.LICLogN(arr);
        assertTrue(solution.length==1);
    }

    @Test
    public void LICTestTwoElementDecreasing() {
        int[] arr = {1, -1};
        List<List<Integer>> solution = calculateLIS(arr);
        assertTrue(solution.get(0).size()==1);
    }

    @Test
    public void LICTestTwoElementDecreasing_LogN() {
        int[] arr = {1, -1};
        int solution[] = LongestIncreasingSubsequence.LICLogN(arr);
        assertTrue(solution.length==1);
    }

    @Test
    public void LICTestTwoElementIncreasing() {
        int[] arr = {1, 2};
        List<List<Integer>> solution = calculateLIS(arr);
        assertTrue(solution.get(0).size()==2);
    }

    @Test
    public void LICTestTwoElementIncreasing_LogN() {
        int[] arr = {1, 2};
        int solution[] = LongestIncreasingSubsequence.LICLogN(arr);
        assertTrue(solution.length==2);
    }
}
