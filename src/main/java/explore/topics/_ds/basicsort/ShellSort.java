package explore.topics._ds.basicsort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        sort.shellSort(SortUtils.arr3);
        System.out.println(Arrays.toString(SortUtils.arr3));
    }

    private void shellSort(Comparable[] arr) {
        int len = arr.length;
        int h = 1;
        while(h<len/3) {
            h = 3*h + 1;
        }
        while(h>=1) {
            hSort(arr, h);
            h = (h-1)/3;
        }
        System.out.println("Exchanged called for " + SortUtils.numbertimesExchangeCalled
                + ", and less called for " + SortUtils.numbertimesLessCalled);
    }

    private void hSort(Comparable[] arr, int h) {
        for (int i = h; i < arr.length; i++) {
            for (int j = i; j >=h && SortUtils.less(arr[j], arr[j-h]); j=j-h) {
                SortUtils.exchange(arr, j, j-h);
            }
        }

    }
}
