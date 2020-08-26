package ds.own.my;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapGK<K, V> {
    private static final int CAPACITY = 16;
    private int initCapacity;
    private int size;
    private Entry<K, V>[] buckets;

    public HashMapGK() {
        this.initCapacity = CAPACITY;
        this.buckets = new Entry[CAPACITY];
    }

    @Test
    public void testMyMapWithStringInteger() {
        HashMapGK<String, Integer> myMap = new HashMapGK<>();
        myMap.put("Mumbai", 420001);
        myMap.put("Bangalore", 560100);
        myMap.put("Delhi", 110001);
        myMap.put("Chandigarh", 340001);
        myMap.put("Kerala", 990398);
        myMap.put("Kerala", 990378);

        assertNotNull(myMap);
        assertEquals(5, myMap.size());
        assertTrue(myMap.get("Mumbai")==420001);
        assertTrue(myMap.get("Bangalore")==560100);
        assertTrue(myMap.get("Delhi")==110001);
        assertTrue(myMap.get("Kerala")==990378);
        assertNull(myMap.get("djdk"));
    }


    @Test
    public void testMyMapWithString() {
        HashMapGK<String, String> myMap = new HashMapGK<>();
        myMap.put("USA", "Washington DC");
        myMap.put("Nepal", "Kathmandu");
        myMap.put("India", "New Delhi");
        myMap.put("Australia", "Sydney");
        myMap.put("Australia", "Sydney1");
        myMap.put("FB", "Facebook");
        myMap.put("Ea", "EA Games");
        assertNotNull(myMap);
        assertEquals(6, myMap.size());
        assertEquals("Kathmandu", myMap.get("Nepal"));
        assertEquals("Sydney1", myMap.get("Australia"));
        assertEquals("Facebook", myMap.get("FB"));
        assertEquals("EA Games", myMap.get("Ea"));
        assertEquals(null, myMap.get("EA"));
        assertEquals(null, myMap.get("Australiass"));
    }

    private V get(K key) {
        int hash = getHash(key);
        int bucketIndex = hash & (CAPACITY-1);
        Entry<K, V> bucket = buckets[bucketIndex];
        while (bucket!=null) {
            if(bucket.key.equals(key)) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }

    private void put(K key, V value) {
        int hash = getHash(key);
        int bucketIndex = hash & (CAPACITY-1);
        Entry<K, V> bucket = buckets[bucketIndex];
        Entry addNode = new Entry(hash, key, value);
        if(bucket==null) {
            buckets[bucketIndex] = addNode;
            size++;
            return;
        }
        while (bucket.next!=null) {
            if(bucket.key.equals(key)) {
                bucket.value = value;
            }
            bucket = bucket.next;
        }
        if(bucket.key.equals(key)) {
            bucket.value = value;
            return;
        }
        bucket.next = addNode;
        size++;
    }

    private int getHash(K key) {
        return key==null ? 0 : key.hashCode();
    }

    private int size() {
        return size;
    }
}

class Entry<K, V> {
    int hashcode;
    final K key;
    V value;
    Entry<K, V> next;

    public Entry(int hashcode, K key, V value) {
        this.hashcode = hashcode;
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
