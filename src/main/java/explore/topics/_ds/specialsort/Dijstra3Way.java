package explore.topics._ds.specialsort;

import explore.topics._ds.basicsort.SortUtils;

import java.util.Arrays;

public class Dijstra3Way {
    public static void main(String[] args) {
        Dijstra3Way dijstra3Way = new Dijstra3Way();
        Comparable[] arr = {"P", "A", "B", "X", "W", "P", "P", "V", "P", "D", "P", "C", "Y", "Z"};
        dijstra3Way.sort(arr, 0, arr.length - 1);
        System.out.println();
    }

    private void sort(Comparable[] arr, int low, int high) {
        if(high<=low) {
            return;
        }
        int lt = low; int gt = high;
        int i = low;
        Comparable pivot = arr[low];
        while (i<=gt) {
            if(SortUtils.less(arr[i], pivot)) {
                SortUtils.exchange(arr, lt++, i++);
            } else if(SortUtils.less(pivot, arr[i])) {
                SortUtils.exchange(arr, gt--, i);
            } else {
                i++;
            }
        }
        sort(arr, low, lt-1);
        sort(arr, gt+1, high);
    }
}
