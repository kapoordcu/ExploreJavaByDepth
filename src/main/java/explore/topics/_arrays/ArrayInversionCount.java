package explore.topics._arrays;

import java.util.Arrays;

public class ArrayInversionCount {

    public static void main(String[] args) {
        int[] arr = {1,4, 3, 5, 6, 2, 0, 2};
        int[] twoSortedArray = {1, 3, 5, 2, 6, 7};
        ArrayInversionCount arrayInversionCount = new ArrayInversionCount();

        System.out.println(arrayInversionCount.arrayInversionCountNaive(arr));
        System.out.println(arrayInversionCount.arrayInversionCountNaive(twoSortedArray));

        System.out.println(arrayInversionCount.arrayInversionCountMergeSort(arr, 0, arr.length - 1));
        System.out.println(arrayInversionCount.arrayInversionCountMergeSort(twoSortedArray, 0, twoSortedArray.length - 1));

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(twoSortedArray));
    }

    private int arrayInversionCountNaive(int[] arr) {
        int inver = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    inver++;
                }
            }
        }
        return inver;
    }

    //Time Complexity: O(N log N)
    //Algorithmic Paradigm: Divide and Conquer
    private int arrayInversionCountMergeSort(int[] arr, int low, int high) {
        int inv_count = 0;
        if(low<high) {
            int mid = (low+high)/2;
            inv_count += arrayInversionCountMergeSort(arr, low, mid);
            inv_count += arrayInversionCountMergeSort(arr, mid+1, high);
            inv_count += merge(arr, low, mid, high);
        }
        return inv_count;
    }

    private int merge(int[] arr, int low, int mid, int high) {
        int inv_count = 0;
        int[] left = Arrays.copyOfRange(arr, low, mid + 1);
        int[] right = Arrays.copyOfRange(arr, mid+1, high+1);
//
//        // Creating temporary subarrays
//        int left[] = new int[mid - low + 1];
//        int right[] = new int[high - mid];
//
//        // Copying our subarrays into temporaries
//        for (int i = 0; i < left.length; i++)
//            left[i] = arr[low + i];
//        for (int i = 0; i < right.length; i++)
//            right[i] = arr[mid + i + 1];

        int i=0;
        int j=0;
        int k=low;
        while (i<left.length && j<right.length) {
            if(left[i]>right[j]) {
                inv_count += ((mid-low)-i+1) ;
                arr[k++] = right[j++];
            } else {
                arr[k++] = left[i++];
            }
        }
        for (; i < left.length; i++) {
            arr[k++] = left[i++];
        }
        for (; i < right.length; i++) {
            arr[k++] = right[j++];
        }
        return inv_count;
    }
}
