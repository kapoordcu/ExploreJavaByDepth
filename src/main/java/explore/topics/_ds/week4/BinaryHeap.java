package explore.topics._ds.week4;

import java.util.Arrays;

public class BinaryHeap<Key extends Comparable<Key>> {
    private Key[] arrClazz;
    private int N;

    public BinaryHeap(int capacity) {
        this.arrClazz = (Key[])new Comparable[capacity+1];
        N = 0;
    }

    public static void main(String[] args) {
//        Comparable[] arraySwim = {"-", "S", "P", "R", "N", "T", "O", "A", "E", "I", "H", "C"};
//        BinaryHeap heapSwim = new BinaryHeap(arraySwim);
//        heapSwim.swim(5);
//        heapSwim.insert("Q");
        BinaryHeap priorityQueue = new BinaryHeap(16);
        priorityQueue.insert("T");
        priorityQueue.insert("H");
        priorityQueue.insert("R");
        priorityQueue.insert("P");
        priorityQueue.insert("S");
        priorityQueue.insert("O");
        priorityQueue.insert("A");
        priorityQueue.insert("E");
        priorityQueue.insert("I");
        priorityQueue.insert("N");
        priorityQueue.insert("C");
        System.out.println(priorityQueue.deleteMax());
        System.out.println(Arrays.toString(priorityQueue.arrClazz));
    }

    //Insertion in a heap
    // Add node at end, then swim it up.
    // Cost. At most 1 + lg N compares.
    public void insert(Key value) {
        arrClazz[++N] = value;
        swim(N);
    }

    /**
     *                              T
     *                      S               R
     *                  I       P       O       A
     *               E    H   N    C   ~  ~    ~   ~
     */
    public Key deleteMax() {
        Key key = arrClazz[1];
        exchange(N, 1);
        sink(1);
        arrClazz[N--] = null;
        return key;
    }

    //Promotion in a heap:
    // Child's key becomes larger key than its parent's key
    public void swim(int K) {
        while (K>1 && less(K/2, K)) {
            exchange(K, K/2);
            K = K/2;
        }
    }

    //Demotion in a heap
    //Parent's key becomes smaller than one (or both) of its children's.
    public void sink(int K) { // Parent smaller than Child
        while (2*K<N) {
            int child = 2*K;
            if(child<N && less(child, child+1)) {
                child++;
            }
            if(!less(K, child)) {
                break;
            }
            exchange(K, child);
            K = child;
        }
    }

    public boolean less(int i, int j) {
        return arrClazz[i].compareTo(arrClazz[j]) < 0;
    }

    public void exchange(int i, int j) {
        Key temp = arrClazz[i];
        arrClazz[i] = arrClazz[j];
        arrClazz[j] = temp;
    }
}
