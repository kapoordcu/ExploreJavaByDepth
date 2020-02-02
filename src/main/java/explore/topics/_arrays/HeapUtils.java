package explore.topics._arrays;

import java.util.Arrays;

public class HeapUtils<Key extends Comparable<Key>> {
    private Key[] arr;
    private int size;

    public HeapUtils(int capacity) {
        this.arr = (Key[]) new Comparable[capacity];
        size = 0;
    }

    public static void main(String[] args) {
        HeapUtils<Integer> heapUtils = new HeapUtils(16);
        heapUtils.insert(11);
        heapUtils.insert(3);
        heapUtils.insert(5);
        heapUtils.insert(9);
        heapUtils.insert(13);
        heapUtils.insert(16);
        heapUtils.insert(2);
        heapUtils.insert(8);
        System.out.println(Arrays.toString(heapUtils.arr));
        System.out.println(heapUtils.deleteMax());
        System.out.println(heapUtils.deleteMax());
        System.out.println(heapUtils.deleteMax());
    }

    //Insertion in a heap
    // Add node at end, then swim it up.
    // Cost. At most 1 + lg N compares.
    private void insert(Key key) {
        arr[size++] = key;
        swim(size);
    }

    //Promotion in a heap:
    // Child's key becomes larger key than its parent's key
    private void swim(int n) {
        while(n>1 && less(n/2-1, n-1)) {
            swap(n/2-1, n-1);
            n = n/2;
        }
    }

    /**
     *                              T
     *                      S               R
     *                  I       P       O       A
     *               E    H   N    C   ~  ~    ~   ~
     */
    private Key deleteMax() {
        Key deletedMax = arr[0];
        swap(0, size-1);
        arr[size-1] = null;
        sink(0);
        size--;
        return deletedMax;
    }

    //Demotion in a heap
    //Parent's key becomes smaller than one (or both) of its children's.
    private void sink(int index) {
        while(2*index + 1<size) {
            int greaterChild = 2*index + 1;
            if(greaterChild+1 < size && less(greaterChild, greaterChild+1)) {
                greaterChild++;
            }
            if(less(greaterChild, index)) {
                break;
            }
            swap(greaterChild, index);
            index = greaterChild;
        }
    }

    private void swap(int parent, int child) {
        Key temp = arr[parent];
        arr[parent] = arr[child];
        arr[child] = temp;
    }

    private boolean less(int parent, Integer child) {
        return arr[parent].compareTo(arr[child]) < 0;
    }
}
