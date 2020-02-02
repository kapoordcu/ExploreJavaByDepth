package explore.topics._ds.week4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HeapSort<Key extends Comparable<Key>> {
    private Comparable[] arr;
    private int N;

    public HeapSort(Comparable[] arr) {
        this.arr = arr;
        N = arr.length;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

        Comparable[] arr = {13, 2, 6, 15, 1, 8, 3, 19, 11};
        HeapSort heapObj = new HeapSort(arr);
        for (int i = heapObj.N/2; i >=0 ; i--) {
           heapObj.sink(arr, i, heapObj.N);
        }
        heapObj.startHeapSort(heapObj.arr, heapObj.N);
        System.out.println(Arrays.toString(arr));
    }

    private void startHeapSort(Comparable[] arr, int N) {
        for (int i = 0; i < N; i++) {
            deleteMax();
        }
    }

    private Comparable deleteMax() {
        Comparable deletedMax = arr[0];
        exchange(0, N-1);
        sink(arr,0, --N);
        return deletedMax;
    }

    private void sink(Comparable[] arr, int K, int N) {
        int greaterChild = 2*K + 1;
        if(greaterChild<N) {
            if(greaterChild+1 < N && less(greaterChild, greaterChild+1)) {
                greaterChild++;
            }
            if(less(K, greaterChild)) {
                exchange(K, greaterChild);
                sink(arr, greaterChild, N);
            }
        }
    }

    public boolean less(int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    public void exchange(int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
