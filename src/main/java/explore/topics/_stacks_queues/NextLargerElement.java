package explore.topics._stacks_queues;

import java.util.Arrays;
import java.util.Stack;

public class NextLargerElement {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4};
        int[] arr2 = { 4, 3, 2, 1};
        int[] arr3 = { 1, 2, 5, 4};

        findNextLargerWithoutStack(arr1);
        findNextLargerWithoutStack(arr2);
        findNextLargerWithoutStack(arr3);
//
//        findNextLarger(arr1);
//        findNextLarger(arr2);
//        findNextLarger(arr3);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }

    private static void findNextLargerWithoutStack(int[] arr) {
        int arrLen = arr.length;
        int max = arr[arrLen-1];
        int temp = 0;
        arr[arrLen-1] = -1;
        for (int i = arrLen-2; i >= 0 ; i--) {
            if(arr[i] < max) {
                temp = arr[i];
                arr[i] = max;
                max = Math.min(temp, max);
            } else {
                max = Math.min(arr[i], max);
                arr[i] = -1;
            }
        }
    }

    //Time Complexity: O(n).
    private static void findNextLarger(int[] arr) {
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length-1; i >= 0 ; i--) {
            if(s.isEmpty()) {
                s.push(arr[i]);
                arr[i] = -1;
            } else {
                Integer pop = s.pop();
                if(pop>arr[i]) {
                    s.push(arr[i]);
                    arr[i] = pop;
                } else {
                    s.push(pop);
                    arr[i] =   -1;
                }
            }
        }
    }
}
