package strings;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class AlgorithmString {

    public Boolean subArrayWithZeroSumExists(int arr[])
    {
        // Creates an empty hashset hs
        Set<Integer> hs = new HashSet<Integer>();

        // Initialize sum of elements
        int sum = 0;

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++)
        {
            // Add current element to sum
            sum += arr[i];

            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash set
            if (arr[i] == 0
                    || sum == 0
                    || hs.contains(sum))
                return true;

            // Add sum to hash set
            hs.add(sum);
        }

        // We reach here only when there is
        // no subarray with 0 sum
        return false;
    }

    public Character firstNonRepeatedCharOn(String original) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c:  original.toCharArray()) {
            frequencyMap.merge(c, 1, Integer::sum);
        }
        for(Character c : original.toCharArray()) {
            if(frequencyMap.containsKey(c) && frequencyMap.get(c)==1) {
                return c;
            }
        }
        return null;
    }

    public Character firstNonRepeatedCharOnO1(String original) {
        Map<Character, CountIndex> frequencyMap = new HashMap<>(256);
        for (int i = 0; i < original.length(); i++) {
            frequencyMap.merge(original.charAt(i),
                    new CountIndex(i, 1),
                    (v1, v2) -> new CountIndex(v1.index, v1.count+1));
        }
        for(char c : original.toCharArray()) {
            if(frequencyMap.containsKey(c)) {
                if(frequencyMap.get(c).count==1) {
                    return original.charAt(frequencyMap.get(c).index);
                }
            }
        }
        return null;
    }

    @Test
    public void testSumOfSubArray() {
        int arr[] = { -3, 2, 3, 1, 6 };
        assertTrue(subArrayWithZeroSumExists(arr));
    }

    @Test
    public void testSumOfSubArrayZero() {
        int arr[] = { -3, 1, 5, -6, 6 };
        assertTrue(subArrayWithZeroSumExists(arr));
    }

    @Test
    public void testOne() {
        AlgorithmString algorithmString = new AlgorithmString();

        Character c = algorithmString.firstNonRepeatedCharOn("auravkapoor");
        Character c2 = algorithmString.firstNonRepeatedCharOnO1("auravkapoor");
        assertTrue(c=='u');
        assertTrue(c2=='u');
    }

    @Test
    public void testEmptyString() {
        AlgorithmString algorithmString = new AlgorithmString();

        Character c = algorithmString.firstNonRepeatedCharOn("");
        Character c2 = algorithmString.firstNonRepeatedCharOnO1("");
        assertTrue(c==null);
        assertTrue(c2==null);
    }

    @Test
    public void testUniqueChar() {
        AlgorithmString algorithmString = new AlgorithmString();

        Character c = algorithmString.firstNonRepeatedCharOn("lmnopq");
        Character c2 = algorithmString.firstNonRepeatedCharOnO1("lmnopq");
        assertTrue(c=='l');
        assertTrue(c2=='l');
    }

    class CountIndex {

        private int index;

        private int count;

        public CountIndex(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}
