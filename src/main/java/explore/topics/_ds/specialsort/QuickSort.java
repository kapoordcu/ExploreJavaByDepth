package explore.topics._ds.specialsort;

import explore.topics._ds.basicsort.SortUtils;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        Comparable[] arr = {7, 3, 2, 5, 1, 4, 6};
        sort.quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private void quickSort(Comparable[] arr, int low, int high) {
        if(high<=low) {
            return;
        }
        int j = partition(arr, low, high);
        quickSort(arr, low, j-1);
        quickSort(arr, j+1, high);
    }

    public static int partition(Comparable[] arr, int low, int high) {
        int pivotPoistion = (low+high)/2;
        Comparable pivot = arr[pivotPoistion];
        int i = low;
        int j = high;
        while(i<j) {
            boolean greaterOnLeft = SortUtils.less(pivot, arr[i]);
            boolean lesserOnRight = SortUtils.less(arr[j], pivot);
            if(greaterOnLeft && lesserOnRight) {
                SortUtils.exchange(arr, i, j);
            } else if(greaterOnLeft) {
                j--;
            } else if(lesserOnRight) {
                i++;
            } else {
                i++; j--;
            }
        }
        SortUtils.exchange(arr, pivotPoistion, j);
        return j;
    }
}
