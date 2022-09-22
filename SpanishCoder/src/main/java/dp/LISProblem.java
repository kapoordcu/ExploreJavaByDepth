package dp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

public class LISProblem {

    private List<Integer> findLISNLogN(int[] nums) {
        int size = nums.length;
        int[] lisArr = new int[size];
        List<Integer> numbers = new ArrayList<>();
        Arrays.fill(lisArr, Integer.MAX_VALUE);
        lisArr[0] = nums[0];
        for (int i = 1; i < size; i++) {
            if(nums[i] > lisArr[i-1]) {
                lisArr[i] = nums[i];
            } else {
                findAndReplaceElement(nums[i], lisArr, i);
            }
        }
        for (int i = 0; i < lisArr.length; i++) {
            if(lisArr[i] != Integer.MAX_VALUE) {
                numbers.add(lisArr[i]);
            }
        }
        return numbers;
    }

    private void findAndReplaceElement(int newNumber, int[] lisArr, int i) {
        int left = 0;
        int right = i;
        while(left<right) {
            int mid  = (left + right)/2;
            if(lisArr[mid] == newNumber) {
                break;
            }
            if(lisArr[mid] > newNumber) {
                right--;
            } else {
                left++;
            }
        }
        lisArr[left] = newNumber;
    }

    @Test
    public void testLIS00() {
        int[] nums = {1, 2, 4, 3};
        List<Integer> list = findLISNLogN(nums);
        assertTrue(list.size()==3);
    }

    @Test
    public void testLIS() {
        int[] nums = {10,9,2,5,3,7,101,18};
        int length = findLIS(nums);
        assertTrue(length==4);
    }

    @Test
    public void testLIS0() {
        int[] nums = {0,1,0,3,2,3};
        int length = findLIS(nums);
        List<Integer> numbers = findLISNLogN(nums);
        assertTrue(length==4);
        assertTrue(numbers.size()==4);
    }


    @Test
    public void testLIS1() {
        int[] nums = {7,7,7,7,7,7,7};
        int length = findLIS(nums);
        List<Integer> numbers = findLISNLogN(nums);
        assertTrue(length==1);
        assertTrue(numbers.size()==1);
    }

    @Test
    public void testLIS2() {
        int[] nums = {4, -1, 2, 1, 5};
        int length = findLIS(nums);
        List<Integer> numbers = findLISNLogN(nums);
        assertTrue(length==3);
        assertTrue(numbers.size()==3);
    }

    private int findLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    LIS[i] = Math.max(LIS[j] + 1,  LIS[i]);
                }
            }
        }
        return IntStream.of(LIS).max().getAsInt();
    }
}
