package explore.topics._ds.basicsort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        sort.insertionSort(SortUtils.arr3);
        System.out.println(Arrays.toString(SortUtils.arr3));
    }

    private void insertionSort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >0; j--) {
                if(SortUtils.less(arr[j], arr[j-1])) {
                    SortUtils.exchange(arr, j, j-1);
                }
            }
        }

        System.out.println("Exchanged called for " + SortUtils.numbertimesExchangeCalled
                + ", and less called for " + SortUtils.numbertimesLessCalled);
    }


}
