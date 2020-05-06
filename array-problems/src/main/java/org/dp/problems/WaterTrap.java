package org.dp.problems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WaterTrap {
    /**
     * Time Complexity: O(n2).
     * There are two nested loops traversing the array, So time Complexity is O(n2).
     * Space Complexity: O(1).
     * No extra space required.
     */
    public static int maxWaterNaive(int arr[], int n) {
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += findStoredByIndividualBar(arr, i, n);
        }
        return totalWater;
    }

    private static int findStoredByIndividualBar(int[] arr, int curr, int n) {
        int currValue = arr[curr];
        int leftMax = 0;
        for (int i = 0; i < curr; i++) {
            leftMax = Math.max(leftMax, arr[i]);
        }
        int rightMax = 0;
        for (int i = curr+1; i < n; i++) {
            rightMax = Math.max(rightMax, arr[i]);
        }

        if(leftMax>currValue && rightMax>currValue){
            return Math.min(leftMax, rightMax) - currValue;
        }
        return 0;
    }

    /**
     * Time Complexity: O(n).
     * Only one traversal of the array is needed, So time Complexity is O(n).
     * Space Complexity: O(n).
     * Two extra array is needed each of size n.
     */
    public static int maxWaterExtraSpace(int arr[], int n) {
        int totalWater = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        rightMax[n-1] = arr[n-1];
        for (int i = n-2; i >=0 ; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }
        return totalWater;
    }

    /**
     * Complexity Analysis:
     * Time Complexity: O(n).
     * Only one traversal of the array is needed.
     * Auxiliary Space: O(1).
     * As no extra space is required.
     */
    public static int maxWaterSpaceOptimization(int arr[], int n) {
        int totalWater = 0;
        int lo = 0;
        int hi = n-1;
        int leftMax = 0;
        int rightMax = 0;
        while (lo <= hi) {
            if(arr[lo] < arr[hi]) {
                if(arr[lo] > leftMax) {
                    leftMax = arr[lo];
                } else {
                    totalWater += leftMax - arr[lo];
                }
                lo++;
            } else {
                if(arr[hi] > rightMax) {
                    rightMax = arr[hi];
                } else {
                    totalWater += rightMax - arr[hi];
                }
                hi--;
            }
        }
        return totalWater;
    }
    @Test
    public void getValue1() {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trapped = WaterTrap.maxWaterNaive(arr, arr.length);
        int trappedExtraSpace = WaterTrap.maxWaterExtraSpace(arr, arr.length);
        int trappedExtraSpaceOptimization = WaterTrap.maxWaterSpaceOptimization(arr, arr.length);
        assertEquals(trapped, 6);
        assertEquals(trappedExtraSpace, 6);
        assertEquals(trappedExtraSpaceOptimization, 6);
    }

    @Test
    public void getValue2() {
        int arr[] = {3,0,0,2,0,4};
        int trapped = WaterTrap.maxWaterNaive(arr, arr.length);
        int trappedExtraSpace = WaterTrap.maxWaterExtraSpace(arr, arr.length);
        int trappedExtraSpaceOptimization = WaterTrap.maxWaterSpaceOptimization(arr, arr.length);
        assertEquals(trapped, 10);
        assertEquals(trappedExtraSpace, 10);
        assertEquals(trappedExtraSpaceOptimization, 10);
    }
}

