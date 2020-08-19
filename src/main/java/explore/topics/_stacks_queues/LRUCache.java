package explore.topics._stacks_queues;


import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LRUCache {
    private int capacity = 3;
    Set<Integer> cache = new LinkedHashSet<>();

    @Test
    public void lru() {
        push(7);
        push(0);
        push(1);
        push(2);
        push(0);
        push(3);
        push(0);
        push(4);
        push(2);
        push(3);
        push(0);
        push(3);
        push(2);
        push(1);
        push(2);

        boolean peek0 = hit(0);
        boolean peek1 = hit(1);
        boolean peek2 = hit(2);
        boolean peek3 = hit(3);
        boolean peek4 = hit(4);
        boolean peek5 = hit(7);
        assertFalse(peek0);
        assertTrue(peek1);
        assertTrue(peek2);
        assertTrue(peek3);
        assertFalse(peek4);
        assertFalse(peek5);
    }

    private boolean hit(int key) {
        return cache.contains(key);
    }

    private void push(int key) {
        if (cache.contains(key)) {
            cache.remove(key);
        }
        if (cache.size() == capacity) {
            int firstKey = cache.iterator().next();
            cache.remove(firstKey);
        }
        cache.add(key);
    }
}
