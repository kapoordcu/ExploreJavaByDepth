package explore.topics._arrays;

import java.util.Arrays;

public class RearrangeArray {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
        reArrangeWithONSpace(arr);
        reArrangeWithO1Space(arr);
    }

    private static void reArrangeWithO1Space(int[] arr) {
        int min = arr[0];
        int max = arr[arr.length-1];
        for (int i = 0; i < arr.length; i++) {
            if(i%2==0) {
                arr[i] = max--;
            } else {
                arr[i] = min++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void reArrangeWithONSpace(int[] arr) {
        int[] copy = new int[arr.length];
        int i = 0;
        int j = arr.length-1;

        for (int k = 0; i<j && k < arr.length;) {
            copy[k++] = arr[j--];
            copy[k++] = arr[i++];
        }
        if(arr.length%2!=0) {
            copy[arr.length-1] = arr[i];
        }
        System.out.println(Arrays.toString(copy));
    }
}

/**
 Given a sorted array of positive integers.
 Your task is to rearrange  the array elements alternatively i.e first element should be max value,
 second should be min value, third should be second max, fourth should be second min and so on...

 Note: O(1) extra space is allowed. Also, try to modify the input array as required.
 */