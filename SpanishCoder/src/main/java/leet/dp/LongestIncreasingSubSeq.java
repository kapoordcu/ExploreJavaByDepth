package leet.dp;

import org.junit.jupiter.api.Test;

import java.util.*;


import static org.junit.Assert.assertTrue;

public class LongestIncreasingSubSeq {

    /*
        Time Complexity: O(n2).
        As nested loop is used.
        Auxiliary Space: O(n).
        Use of any array to store LIS values at each index.
    */
    private int LICnSquare(int[] arr) {
        int[] LIC = new int[arr.length];
        Arrays.fill(LIC, 1);
        for (int i = arr.length-1; i >=0; i--) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    LIC[i] = Math.max(LIC[i], 1 + LIC[j]);
                }
            }
        }
        return Arrays.stream(LIC).max().getAsInt();
    }

    private TreeSet<Integer> LICnLogn(int[] arr) {
        TreeSet<Integer> piles = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            Integer ciel = piles.ceiling(arr[i]);
            if(ciel != null) {
                piles.remove(ciel);
            }
            piles.add(arr[i]);
        }
        return piles;
    }


    @Test
    public void solution0() {
        int[] arr = {10,9,2,5,3,7,101,18};
        int longest = LICnSquare(arr);
        TreeSet<Integer> longest2 = LICnLogn(arr);
        assertTrue(longest==4);
        assertTrue(!longest2.isEmpty());
        assertTrue(longest2.equals(Set.of(2, 3, 7, 18)));
    }

    @Test
    public void solution1() {
        int[] arr = {0,1,0,3,2,3};
        int longest = LICnSquare(arr);
        TreeSet<Integer>  longest2 = LICnLogn(arr);
        assertTrue(longest==4);
        assertTrue(!longest2.isEmpty());
        assertTrue(longest2.equals(Set.of(0, 1, 2, 3)));
    }

    @Test
    public void solution2() {
        int[] arr = {7,7,7,7,7,7,7};
        int longest = LICnSquare(arr);
        TreeSet<Integer>  longest2 = LICnLogn(arr);
        assertTrue(longest==1);
        assertTrue(!longest2.isEmpty());
        assertTrue(longest2.equals(Set.of(7)));
    }

    @Test
    public void solution4() {
        int[] arr = {3, 10, 2, 11};
        int longest = LICnSquare(arr);
        TreeSet<Integer>  longest2 = LICnLogn(arr);
        assertTrue(longest==3);
        assertTrue(!longest2.isEmpty());
        assertTrue(longest2.equals(Set.of(2, 10, 11)));
    }

    @Test
    public void solution5() {
        int[] arr = {-2, 3, 0, 1, -1, 5, 6,3, -4};
        int longest = LICnSquare(arr);
        TreeSet<Integer>  longest2 = LICnLogn(arr);
        assertTrue(longest==5);
        assertTrue(!longest2.isEmpty());
        assertTrue(longest2.equals(Set.of(-4,-1, 1, 3, 6)));
    }

}

/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].



Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1


Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104


Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
