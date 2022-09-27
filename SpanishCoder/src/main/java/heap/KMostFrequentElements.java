package heap;

import org.junit.jupiter.api.Test;

import java.util.*;
import static org.junit.Assert.assertTrue;

public class KMostFrequentElements {

    public int[] topKFrequentOn(int[] nums, int k) {

        return null;
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        Map<Integer, Integer> unsortedMap = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();

        for (int i = 0; i < nums.length; i++) {
            unsortedMap.compute(nums[i], (key, val) -> val==null? 1 : val+1);
        }
        unsortedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
        int start = 0;

        for (Map.Entry<Integer, Integer> entry:         sortedMap.entrySet()) {
            if(start++<k) {
                minHeap.offer(entry.getKey());
            }
        }
        for (int i = 0; i < k; i++) {
            arr[i] = minHeap.poll();
        }
        return arr;
    }

    @Test
    public void test012() {
        int[] array =  {4,1,-1,2,-1,2,3};
        List<Integer> result = List.of(-1, 2);
        int k = 2;
        int[] actual = topKFrequent(array, k);
        for (int i = 0; i < actual.length; i++) {
            assertTrue(result.contains(actual[i]));
        }
    }

    @Test
    public void test01() {
        int[] array = {1,1,1,2,2,3};
        List<Integer> result = List.of(1, 2);
        int k = 2;
        int[] actual = topKFrequent(array, k);
        for (int i = 0; i < actual.length; i++) {
            assertTrue(result.contains(actual[i]));
        }
    }

    @Test
    public void test02() {
        int[] array = {1};
        List<Integer> result = List.of(1);
        int k = 1;
        int[] actual = topKFrequent(array, k);
        for (int i = 0; i < actual.length; i++) {
            assertTrue(result.contains(actual[i]));
        }
    }
}
