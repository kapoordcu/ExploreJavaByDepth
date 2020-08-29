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
    }

    /*
    Time Complexity: O(d log d), where d is the count of distinct elements in the array.
    To sort the array O(d log d) time is needed.
    Auxiliary Space: O(d), where d is the count of distinct elements in the array.
    To store the elements in HashMap O(d) space complexity is needed.
     */
    private List<Integer> topKElementsInArraySimpleHashMap(int[] arr, int k) {
        Map<Integer, Integer> mapCount = new HashMap<>();
        for (int elem:   arr) {
            if(mapCount.containsKey(elem)) {
                mapCount.put(elem, mapCount.get(elem)+1);
            } else {
                mapCount.put(elem, 1);
            }
        }
        return mapCount.entrySet()
                .stream()
                .sorted(comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());
    }
}
