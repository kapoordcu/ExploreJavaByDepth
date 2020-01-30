package explore.topics._arrays;

import java.util.Arrays;

public class DutchFlagProblem {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 0, 1, 1, 0, 0};

        dutchFlag(arr, 0, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //Time complexity is O(n).
    //Space complexity is O(1).
    private static void dutchFlag(int[] arr, int lo, int mid, int hi) {
        while (mid<=hi) {
            if(arr[mid]==0) {
                swap(arr, lo++, mid++);
            } else if(arr[mid]==1) {
                mid++;
            } else if(arr[mid]==2){
                swap(arr, mid, hi--);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }
}

/**
 Given `N' objects coloured red, white or blue, sort them so that objects of the same colour are adjacent,
 with the colours in the order red, white and blue.
 */