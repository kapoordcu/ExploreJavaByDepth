package leet.arr;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

public class TwoSum {
    private static int[] twoSum(int[] arr, int target) {
        int[] array = {-1,-1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                array[0] = map.get(arr[i]);
                array[1] = i;
            } else {
                map.put(target-arr[i], i);
            }
        }
        return array;
    }

    public static int[] twoSumNSquare(int[] nums, int target) {
        int[] array = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target) {
                    array[0] = i;
                    array[1] = j;
                }
            }
        }
        return array;
    }

    @Test
    public void target9() {
        int[] arr = {2,7,11,15};
        int target = 9;
        int[] sum = TwoSum.twoSum(arr, target);
        List<Integer> collect = IntStream.of(sum).boxed().collect(Collectors.toList());
        assertTrue(collect.contains(0));
        assertTrue(collect.contains(1));
    }

    @Test
    public void targetNoExist() {
        int[] arr = {2,7,11,15};
        int target = 1;
        int[] sum = TwoSum.twoSum(arr, target);
        List<Integer> collect = IntStream.of(sum).boxed().collect(Collectors.toList());
        assertTrue(collect.contains(-1));
    }

    @Test
    public void target6() {
        int[] arr = {3,2,4};
        int target = 6;
        int[] sum = TwoSum.twoSum(arr, target);
        List<Integer> collect = IntStream.of(sum).boxed().collect(Collectors.toList());
        assertTrue(collect.contains(2));
        assertTrue(collect.contains(1));
    }

    @Test
    public void target62() {
        int[] arr = {3,3};
        int target = 6;
        int[] sum = TwoSum.twoSum(arr, target);
        List<Integer> collect = IntStream.of(sum).boxed().collect(Collectors.toList());
        assertTrue(collect.contains(0));
        assertTrue(collect.contains(1));
    }
}


/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.


Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */