package explore.topics._ds.specialsort;

import explore.topics._ds.basicsort.SortUtils;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] arr = {7,3, 2, 5, 1,4, 6};
        int[] arrCopy = arr.clone();

        sort.mergeSort(arr, arrCopy,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr, int[] auxilarryArray, int low, int high) {
        System.out.println("Merge sort of " + low + ", " + high);
        if(low<high) {
            int mid = (low + high)/2;
            mergeSort(arr, auxilarryArray, low, mid);
            mergeSort(arr, auxilarryArray, mid+1, high);
            mergeTwoHalves(arr, auxilarryArray, low, mid, high);
        }
    }

    public void mergeTwoHalves(int[] arr, int[] arrCopy, int low, int mid, int high) {
        System.out.println("Merging " + low + ", " + mid + " ," + high);

        int i = low;
        int j = mid + 1;

        for (int k = low; k < high; k++) {
            if(i>mid) {
                arr[k] = arrCopy[j++];
            } else if(j>=high) {
                arr[k] = arrCopy[i++];
            } else if(SortUtils.less(arrCopy[j], arrCopy[i])) {
                arr[k] = arrCopy[j++];
            } else {
                arr[k] = arrCopy[i++];
            }
        }
    }

    private boolean assertSortedArray(Comparable[] arr, int low, int high) {
        boolean sorted = true;
        for (int i = low; i < high -1 ; i++) {
            if(arr[i].compareTo(arr[i+1])>0) {
                sorted &= false;
            }
        }
        return sorted;
    }

}
