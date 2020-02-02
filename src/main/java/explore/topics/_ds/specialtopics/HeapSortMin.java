package explore.topics._ds.specialtopics;

public class HeapSortMin<Key extends Comparable<Key>> {

    private Comparable[] arr;
    private int size;

    public HeapSortMin(Comparable[] arr) {
        this.arr = arr;
        size = arr.length;
    }

    public static void main(String[] args) {
        Comparable[] arr = {13, 2, 6, 15, 1, 8, 3, 19, 11};
        HeapSortMin minHeap = new HeapSortMin(arr);
        for (int i = minHeap.size/2; i >=0 ; i--) {
            minHeap.sink(arr, i, minHeap.size);
        }
        for (int i = 0; i < minHeap.arr.length; i++) {
            Comparable deleteMin = minHeap.deleteMin();
            System.out.println(deleteMin);
        }
    }

    private Comparable deleteMin() {
        Comparable deletedMin = arr[0];
        swap(arr, 0, size-1);
        sink(arr, 0, --size);
        return deletedMin;
    }

    private void sink(Comparable[] arr, int index, int size) {
        int smallerChild = 2*index + 1;
        if(smallerChild < size) {
            if(smallerChild+1<size && less(arr, smallerChild+1, smallerChild)) {
                smallerChild++;
            }
            if(less(arr, smallerChild, index)) {
                swap(arr, index, smallerChild);
                sink(arr, smallerChild, size);
            }
        }

    }

    private void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean less(Comparable[] arr, int left, int right) {
        return arr[left].compareTo(arr[right]) < 0;
    }

}
