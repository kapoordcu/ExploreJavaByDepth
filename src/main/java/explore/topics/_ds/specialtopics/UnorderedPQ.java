package explore.topics._ds.specialtopics;

import explore.topics._ds.basicsort.SortUtils;

public class UnorderedPQ<K extends Comparable<K>> {

    public static void main(String[] args) {
        UnorderedPQ<String> priorityQueue = new UnorderedPQ(10);
        priorityQueue.insert("P");
        priorityQueue.insert("Q");
        priorityQueue.insert("E");
        System.out.println(priorityQueue.delMax());
        priorityQueue.insert("X");
        priorityQueue.insert("A");
        priorityQueue.insert("M");
        System.out.println(priorityQueue.delMax());
        priorityQueue.insert("P");
        priorityQueue.insert("L");
        priorityQueue.insert("E");
        System.out.println(priorityQueue.delMax());
    }

    private Comparable[] pq;
    private int No;

    public UnorderedPQ(int capacity) {
        this.pq = new Comparable[capacity];
    }

    public boolean isEmpty() {
        return No==0;
    }

    public void insert(Comparable value) {
        if(No>pq.length) {
            throw new ArrayIndexOutOfBoundsException("Beyond capacity");
        }
        pq[No++] = value;
    }

    public Comparable delMax() {
        int max = 0;
        for (int i = 0; i < No; i++) {
            if(SortUtils.less(pq[max], pq[i])) {
                max = i;
            }
        }
        SortUtils.exchange(pq, max, No-1);
        return pq[--No];
    }
}
