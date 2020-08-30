package ds.own.my;

public class MaxHeap<Key extends Comparable<Key>> {
    private Comparable[] pq;
    private int N;

    public MaxHeap(int capacity) {
        this.pq = new Comparable[capacity+1];
    }

    public boolean isEmpty() { return N==0;}

    public int size() {return N;}

    // At most 1+logN compares
    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    // when child become greater than parent
    private void swim(int n) {
        while (n>1 && less(n/2, n)) {
            exchange(n/2, n);
            n = n/2;
        }
    }

    // when parent become smaller than any of children
    private void sink(int k) {
        while(2*k < N) {
            int left = 2*k;
            if(left< N && less(left, left+1)) {
                left++;
            }
            if(!less(k, left)) { break;}
            exchange(k, left);
            k = left;
        }
    }

    // atmost 2*LogN compares
    public Comparable delMax() {
        Comparable max = pq[1];
        exchange(1, N--);
        sink(1);
        pq[N+1] = null;
        return max;
    }

    private void exchange(int parent, int child) {
        Comparable temp = pq[parent];
        pq[parent] = pq[child];
        pq[child] = temp;
    }

    private boolean less(int parent, int child) {
        return pq[parent].compareTo(pq[child])<0;
    }
}
