package explore.topics._ds.basicsort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static java.util.Collections.*;

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        Comparable[] arr = {7, 10, 5, 3, 8, 4, 2, 9, 6};
        Comparable[] arr2 = {1, 2, 3, 4, 5, 6, 7};

        sort.insertionSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    private void insertionSort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >0 ; j--) {
                if (SortUtils.less(arr[j] , arr[j-1])) {
                    SortUtils.exchange(arr, j-1, j);
                }
            }
        }
        System.out.println(SortUtils.numbertimes);
    }


}
