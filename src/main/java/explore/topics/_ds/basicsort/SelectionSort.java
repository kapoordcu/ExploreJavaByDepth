package explore.topics._ds.basicsort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();

        sort.selectionSort(SortUtils.arr1);
        System.out.println(Arrays.toString(SortUtils.arr1));
    }

    private void selectionSort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j <arr.length ; j++) {
                if (SortUtils.less(arr[j] , arr[min])) {
                    min = j;
                }
            }
            SortUtils.exchange(arr, i, min);
        }
        System.out.println("Exchanged called for " + SortUtils.numbertimesExchangeCalled
                + ", and less called for " + SortUtils.numbertimesLessCalled);
    }



}
