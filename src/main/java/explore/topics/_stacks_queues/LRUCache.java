package explore.topics._stacks_queues;

import java.util.ArrayList;
import java.util.List;

public class LRUCache {
    private List<Entry> entries;

    public LRUCache(int capacity) {
        entries = new ArrayList<>(capacity);
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(5);
        lru.set(1, 101);
        lru.set(2, 202);
        lru.set(3, 303);
        lru.set(4, 404);
        lru.set(5, 505);
        lru.set(6, 606);
        lru.set(7, 707);
        lru.set(8, 808);
        lru.set(9, 909);
        lru.set(10, 1001);


    }

    private void set(int key, int value) {
        Entry set = new Entry(key);
        set.value = value;
        set.accessCount++;
        if(entries.size() > 5) {

        }
        entries.add(set);
    }

    private int get(int key) {
        for (int i = 0; i < entries.size(); i++) {
            if(entries.get(i).key==key) {
                return entries.get(i).value;
            }
        }
        return -1;
    }

    static class Entry {
        public Integer key;
        public Integer value;
        public Integer accessCount;

        public Entry(Integer key) {
            this.key = key;
        }

    }
}
