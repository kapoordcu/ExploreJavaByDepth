package explore.topics._dynamicprog;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class LongestIncreasingSubsequence {
    /**
     * O(n*n) longest Increasing Sequence
     * Will only print the LENGTH, Not the sequence
     */
    public static int[] longestIncreasingSubSequence(int[] arr) {
        List<Integer> licList = new ArrayList<>();
        int[] len = new int[arr.length];
        Arrays.fill(len, 1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                if(arr[i] > arr[j]) {
                    len[i] = Math.max(len[i], len[j]+1);
                }
            }
        }
        int next = 0;
        for (int i = 0; i < len.length; i++) {
            if(len[i] == next + 1) {
                licList.add(arr[i]);
                next += 1;
            }
        }
        return licList.stream().mapToInt(i-> i).toArray();
    }

    public static int[] LICLogN(int[] arr) {
        int[] LIC = new int[arr.length];
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
        return Arrays.stream(LIC).filter(n-> n!=0).toArray();
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
    public void LICTest() {
        int[] arr = {1, 3, 4, 5, 6, 5, 4, 7, 2, 7};
        int[] solution = LongestIncreasingSubsequence.longestIncreasingSubSequence(arr);
        assertTrue(solution.length==6);
    }

    @Test
    public void LICTestLICLogN() {
        int[] arr = {1, 3, 4, 5, 6, 5, 4, 7, 2, 7};
        int[] solution = LongestIncreasingSubsequence.LICLogN(arr);
        assertTrue(solution.length==6);
    }

    @Test
    public void LICTestSingleElement() {
        int[] arr = {1};
        int solution[] = LongestIncreasingSubsequence.longestIncreasingSubSequence(arr);
        assertTrue(solution.length==1);
    }

    @Test
    public void LICTestSingleElementLogN() {
        int[] arr = {1};
        int solution[] = LongestIncreasingSubsequence.LICLogN(arr);
        assertTrue(solution.length==1);
    }

    @Test
    public void LICTestTwoElementDecreasing() {
        int[] arr = {1, -1};
        int solution[] = LongestIncreasingSubsequence.longestIncreasingSubSequence(arr);
        assertTrue(solution.length==1);
    }

    @Test
    public void LICTestTwoElementDecreasingLogN() {
        int[] arr = {1, -1};
        int solution[] = LongestIncreasingSubsequence.LICLogN(arr);
        assertTrue(solution.length==1);
    }

    @Test
    public void LICTestTwoElementIncreasing() {
        int[] arr = {1, 2};
        int solution[] = LongestIncreasingSubsequence.longestIncreasingSubSequence(arr);
        assertTrue(solution.length==2);
    }

    @Test
    public void LICTestTwoElementIncreasingLogN() {
        int[] arr = {1, 2};
        int solution[] = LongestIncreasingSubsequence.LICLogN(arr);
        assertTrue(solution.length==2);
    }
}
