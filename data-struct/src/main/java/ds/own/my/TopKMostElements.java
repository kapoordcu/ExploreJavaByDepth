package ds.own.my;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.Map.Entry.comparingByValue;
import static org.junit.Assert.assertTrue;
/*
Given an array of n numbers and a positive integer k.
The problem is to find k numbers with most occurrences, i.e., the top k numbers having
the maximum frequency. If two numbers have the same frequency then the larger number
should be given preference. The numbers should be displayed in decreasing order of their frequencies.
 */
public class TopKMostElements {

    @Test
    public void topK_2() {
        int arr[] = {3, 1, 4, 4, 5, 2, 6, 1};
        int k = 2;
        List<Integer> topK = topKElementsInArraySimpleHashMap(arr, k);
        assertTrue(topK.contains(4));
        assertTrue(topK.contains(1));

        List<Integer> topKPQ = topKElementsInArrayPriorityQueue(arr, k);
        assertTrue(topKPQ.contains(4));
        assertTrue(topKPQ.contains(1));
    }

    @Test
    public void topK_4() {
        int arr[] = {7, 10, 11, 10, 5, 2, 10, 10, 5, 5, 7, 10, 11, 8, 9, 10};
        int k = 4;
        List<Integer> topK = topKElementsInArraySimpleHashMap(arr, k);
        assertTrue(topK.contains(10));
        assertTrue(topK.contains(7));
        assertTrue(topK.contains(11));
        assertTrue(topK.contains(5));

        List<Integer> topKPQ = topKElementsInArrayPriorityQueue(arr, k);
        assertTrue(topKPQ.contains(10));
        assertTrue(topKPQ.contains(7));
        assertTrue(topKPQ.contains(11));
        assertTrue(topKPQ.contains(5));
    }

    /**
    Time Complexity: O(d log d), where d is the count of distinct elements in the array.
    To sort the array O(d log d) time is needed.
    Auxiliary Space: O(d), where d is the count of distinct elements in the array.
    To store the elements in HashMap O(d) space complexity is needed.
     */
    private List<Integer> topKElementsInArraySimpleHashMap(int[] arr, int k) {
        Map<Integer, Integer> mapCount = new HashMap<>();
        for (int elem:   arr) {
            mapCount.put(elem, mapCount.getOrDefault(elem, 0) + 1);
        }
        return mapCount.entrySet()
                .stream()
                .sorted(comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());
    }

    /**
     Complexity Analysis:
     Time Complexity: O(k log d + d), where d is the count of distinct elements in the array.
     To remove the top of priority queue O(log d) time is required, so if k elements are removed then O(k log d) time is required and to traverse the distinct elements O(d) time is required.
     Auxiliary Space: O(d), where d is the count of distinct elements in the array.
     To store the elements in HashMap O(d) space complexity is needed.
     */
    private List<Integer> topKElementsInArrayPriorityQueue(int[] arr, int k) {
        List<Integer> topK = new ArrayList<>();

        Map<Integer, Integer> mapCount = new HashMap<>();
        for (int elem:   arr) {
            mapCount.put(elem, mapCount.getOrDefault(elem, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer> > pq =
                new PriorityQueue<>(
                        (a, b) -> a.getValue().equals(b.getValue()) ?
                                Integer.compare(b.getKey(), a.getKey()) :
                                Integer.compare(b.getValue(), a.getValue()));
        mapCount.entrySet()
                .forEach(entry -> pq.offer(entry));
        for (int i = 0; i < k; i++) {
            topK.add(pq.poll().getKey());
        }
        return topK;
    }
}
