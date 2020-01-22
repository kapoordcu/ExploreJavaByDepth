package explore.topics._ds.week4;

import explore.topics._ds.basicsort.SortUtils;

public class BinaryHeap {
    private Comparable[] arr;
    private int N;
    public void swim(int key) {
        while(key>1 && SortUtils.less(key, key/2)) {
            SortUtils.exchange(arr, key, key/2);
            key = key/2;
        }
    }

    public void sink(int key) {
        while (2*key < N) {
            int j = (int)arr[2*key];
            if(j<N && SortUtils.less(j, j+1)) {
                j++;
            }
            if(!SortUtils.less(key, j)) {
                break;
            }
            SortUtils.exchange(arr, key, j);
            key = j;

        }
    }
}
