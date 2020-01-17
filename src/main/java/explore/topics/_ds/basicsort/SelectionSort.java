package explore.topics._ds.basicsort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        Comparable[] arr = {7, 10, 5, 3, 8, 4, 2, 9, 6};
        Comparable[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        sort.selectionSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    private void selectionSort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if (SortUtils.less(arr[j] , arr[i])) {
                    SortUtils.exchange(arr, i, j);
                }
            }
        }
        System.out.println(SortUtils.numbertimes);
    }



}
