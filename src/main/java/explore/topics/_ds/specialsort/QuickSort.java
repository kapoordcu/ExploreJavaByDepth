package explore.topics._ds.specialsort;

import java.util.Arrays;

public class QuickSort {

    private void quickSort(Comparable[] arr, int low, int high) {
        if (low < high) {
            int j = partition(arr, low, high);
            quickSort(arr, low, j-1);
            quickSort(arr, j+1, high);
        }
    }

    static int partition(Comparable arr[], int low, int high) {
        Comparable pivot = arr[high];
        for (int i=low; i<high; i++) {
            if (arr[i].compareTo(pivot)<0) {
                swap(arr, low++, i);
            }
        }
        swap(arr, low, high);
        return low;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();

        Comparable arr[] = {12, 11, 13, 5, 6, 7};
        Comparable[] arr1 = {7, 3, 2, 5, 1, 4, 6};
        Comparable[] arr1Duplicate = {7, 3, 2, 5, 1, 4, 6, 2, 3};
        Comparable[] arr2 = {3, 6, 0, 5, 2, 7, 9};
        Comparable[] arr2Duplicate = {3, 6, 0, 9, 2, 7, 0, 9, 9};

        sort.quickSort(arr, 0, arr.length-1);
        sort.quickSort(arr1, 0, arr1.length-1);
        sort.quickSort(arr1Duplicate, 0, arr1Duplicate.length-1);
        sort.quickSort(arr2, 0, arr2.length-1);
        sort.quickSort(arr2Duplicate, 0, arr2Duplicate.length-1);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr1Duplicate));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr2Duplicate));
    }
}
