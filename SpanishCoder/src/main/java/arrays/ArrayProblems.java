package arrays;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayProblems {

    public int maxSubArray(int[] nums) {
        int max_so_far = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if(currentSum > max_so_far) {
                max_so_far = currentSum;
            }
            if(currentSum < 0) {
                currentSum = 0;
            }
        }
        return max_so_far;
    }


    @Test
    public void testMaxSubArray1() {
        ArrayProblems subarray = new ArrayProblems();
        int[] nums = {-5, 4, 6, -3, 8, -1};
        int sum = subarray.maxSubArray(nums);
        assertTrue(sum==15);
    }

    @Test
    public void testMaxSubArray2() {
        ArrayProblems subarray = new ArrayProblems();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int sum = subarray.maxSubArray(nums);
        assertTrue(sum==6);
    }

    @Test
    public void testMaxSubArray3() {
        ArrayProblems subarray = new ArrayProblems();
        int[] nums = {1};
        int sum = subarray.maxSubArray(nums);
        assertTrue(sum==1);
    }

    @Test
    public void testMaxSubArray4() {
        ArrayProblems subarray = new ArrayProblems();
        int[] nums = {5,4,-1,7,8};
        int sum = subarray.maxSubArray(nums);
        assertTrue(sum==23);
    }

    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        products[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            products[i] = products[i-1] * nums[i-1];
        }
        int result = 1;
        for (int i = products.length-1; i >=0 ; i--) {
            products[i] = result * products[i];
            result = result * nums[i];
        }
        return products;
    }

    @Test
    public void testProductExceptSelf1() {
        ArrayProblems prods = new ArrayProblems();
        int[] nums = {1,2,3,4};
        int[]  expected = {24,12,8,6};
        int[] result  = prods.productExceptSelf(nums);
        assertTrue(expected.length == result.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    public void testProductExceptSelf2() {
        ArrayProblems prods = new ArrayProblems();
        int[] nums = {-1,1,0,-3,3};
        int[]  expected = {0,0,9,0,0};
        int[] result  = prods.productExceptSelf(nums);
        assertTrue(expected.length == result.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    static int maxProfitLocalMinima(int prices[]) {
        int maxProfit = 0;
        int localMinima = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            localMinima = Math.min(localMinima, prices[i]);
            maxProfit = Math.max(prices[i] - localMinima, maxProfit);
        }
        return maxProfit;
    }
    public int maxProfit(int[] prices) {
        int min = 0;
        for (int i = prices.length-1; i >0 ; i--) {
            for (int j = i-1; j >=0 ; j--) {
                min = Math.max(prices[i] - prices[j], min);
            }
        }
        return min;
    }

    @Test
    public void testMaxProfitLocalMinima1() {
        ArrayProblems arrayProblems = new ArrayProblems();
        int[] prices = {7,1,5,3,6,4};
        int profit = arrayProblems.maxProfit(prices);
        int profit2 = arrayProblems.maxProfitLocalMinima(prices);
        assertEquals(profit, 5);
        assertEquals(profit2, 5);
    }

    @Test
    public void testMaxProfitLocalMinima2() {
        ArrayProblems arrayProblems = new ArrayProblems();
        int[] prices = {7,6,4,3,1};
        int profit = arrayProblems.maxProfit(prices);
        int profit2 = arrayProblems.maxProfitLocalMinima(prices);
        assertEquals(profit, 0);
        assertEquals(profit2, 0);
    }

    public int[] twoSum(int[] nums, int target) {
        Set<Integer> uniques = new HashSet<>();
        int[] returnArr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(uniques.contains(nums[i])) {
                returnArr[0] = indexof(nums, target - nums[i]);
                returnArr[1] = i;
                return returnArr;
            }
            uniques.add(target - nums[i]);
        }
        return returnArr;
    }

    private Integer indexof(int[] nums, int number) {
        for (int i = 0; i < nums.length; i++) {
            if(number == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void testTwoSum1() {
        ArrayProblems sum = new ArrayProblems();
        int[] nums = {2,7,11,15};
        int target = 9;
        int[]  expected = {0,1};
        int[] result  = sum.twoSum(nums, target);
        assertTrue(expected.length == result.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    public void testTwoSum2() {
        ArrayProblems sum = new ArrayProblems();
        int[] nums = {3,2,4};
        int target = 6;
        int[]  expected = {1,2};
        int[] result  = sum.twoSum(nums, target);
        assertTrue(expected.length == result.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    public void testTwoSum3() {
        ArrayProblems sum = new ArrayProblems();
        int[] nums = {3,3};
        int target = 6;
        int[]  expected = {0,1};
        int[] result  = sum.twoSum(nums, target);
        assertTrue(expected.length == result.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }
}
