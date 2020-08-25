package ds.own.my;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HashMapGK<K, V> {
    private static final int CAPACITY = 16;
    private int initCapacity;
    private int size;
    private HMNode<K, V>[] bucket;

    public HashMapGK() {
        this.initCapacity = CAPACITY;
        this.bucket = new HMNode[CAPACITY];
    }

    public void put(K key, V value) {
        int hashcode = calculateHash(key);
        int index = hashcode & (CAPACITY-1);
        HMNode  node = new HMNode(hashcode, key, value);
        HMNode<K, V> currentBucket = bucket[index];
        if(currentBucket==null) {
            bucket[index] = node;
            size++;
        } else {
            while (currentBucket.next!=null) {
                if(currentBucket.key.equals(key)) {
                    currentBucket.value = value;
                    return;
                }
                currentBucket = currentBucket.next;
            }
            if(currentBucket.key.equals(key)) {
                currentBucket.value = value;
                return;
            } else {
                currentBucket.next = node;
                size++;
            }
        }
    }

    public V get(K key) {
        int hashcode = calculateHash(key);
        int index = hashcode & (CAPACITY-1);
        HMNode<K, V> currentBucket = bucket[index];
        while(currentBucket!=null) {
            if(currentBucket.key.equals(key)) {
                return currentBucket.value;
            }
            currentBucket = currentBucket.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    private int calculateHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }


    @Test
    public void testMyMap() {
        HashMapGK<String, String> myMap = new HashMapGK<>();
        myMap.put("USA", "Washington DC");
        myMap.put("Nepal", "Kathmandu");
        myMap.put("India", "New Delhi");
        myMap.put("Australia", "Sydney");
        myMap.put("Australia", "Sydney1");
        assertNotNull(myMap);
        assertEquals(4, myMap.size());
        assertEquals("Kathmandu", myMap.get("Nepal"));
        assertEquals("Sydney1", myMap.get("Australia"));
        assertEquals(null, myMap.get("Australiass"));
    }
}

class HMNode<K, V> {
    int hashcode;
    final K key;
    V value;
    HMNode<K, V> next;

    public HMNode(int hashcode, K key, V value) {
        this.hashcode = hashcode;
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
