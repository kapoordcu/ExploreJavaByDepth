package arrays;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayProblems {

    public int maxSubArrayProduct(int[] nums) {
        int max = 0;
        int prod = 0;
        for (int i = 0; i < nums.length; i++) {
            prod = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                prod = prod * nums[j];
                if(prod >= max) {
                    max = prod;
                }
            }
        }
        return Math.max(max, prod);
    }

    @Test
    public void testMaxSubArrayProduct1() {
        ArrayProblems subarray = new ArrayProblems();
        int[] nums0 = {-2,0,-1};
        int[] nums = {2,3, 2,-4};
        int[] nums1 = {6, -3, -10, 0, 2};
        int[] nums2 = {-1, -3, -10, 0, 60};
        int[] nums3 = {-2, -40, 0, -2, -3};

        assertTrue(subarray.maxSubArrayProduct(nums0)==0);
        assertTrue(subarray.maxSubArrayProduct(nums)==12);
        assertTrue(subarray.maxSubArrayProduct(nums1)==180);
        assertTrue(subarray.maxSubArrayProduct(nums2)==60);
        assertTrue(subarray.maxSubArrayProduct(nums3)==80);
    }

    public int maxSubArraySum(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum > max) {
                max = sum;
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    @Test
    public void testMaxSubArray1() {
        ArrayProblems subarray = new ArrayProblems();
        int[] nums = {-5, 4, 6, -3, 8, -1};
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {1};
        int sum = subarray.maxSubArraySum(nums);
        int sum1 = subarray.maxSubArraySum(nums1);
        int sum2 = subarray.maxSubArraySum(nums2);
        assertTrue(sum==15);
        assertTrue(sum1==6);
        assertTrue(sum2==1);
    }

    @Test
    public void testMaxSubArray4() {
        ArrayProblems subarray = new ArrayProblems();
        int[] nums = {5,4,-1,7,8};
        int sum = subarray.maxSubArraySum(nums);
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
