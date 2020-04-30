package org.check24;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MinimumUniqueSum {
    public static int getMinimumUniqueSum(List<Integer> arr) {
        List<Integer> storeResults = new ArrayList<Integer>();
        int sum = 0;
        storeResults.add(arr.get(0));

        for (int i = 1; i < arr.size(); i++) {

            int val = arr.get(i);

            while (storeResults.contains(val)) {
                val++;
            }
            storeResults.add(val);
        }
        for (int i = 0; i < storeResults.size(); i++) {
            sum += storeResults.get(i);
        }

        return sum;
    }

    public static int getMinimumUniqueSumJava8(List<Integer> arr) {
        List<Integer> storeResults = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            int val = arr.get(i);
            while (storeResults.contains(val)) {
                val++;
            }
            storeResults.add(val);
        }
        Integer sum = storeResults.stream().reduce(0, Integer::sum);
        return sum;
    }

    @Test
    public void testUniqueSum0() {
        List<Integer> numbers = List.of(3, 2, 1, 2, 7);
        int minimumUniqueSum = MinimumUniqueSum.getMinimumUniqueSum(numbers);
        int minimumUniqueSumJava8 = MinimumUniqueSum.getMinimumUniqueSumJava8(numbers);
        assertTrue(minimumUniqueSum==17);
        assertTrue(minimumUniqueSumJava8==17);
    }

    @Test
    public void testUniqueSum1() {
        List<Integer> numbers = List.of(2, 2, 2);
        int minimumUniqueSum = MinimumUniqueSum.getMinimumUniqueSum(numbers);
        int minimumUniqueSumJava8 = MinimumUniqueSum.getMinimumUniqueSumJava8(numbers);
        assertTrue(minimumUniqueSum==9);
        assertTrue(minimumUniqueSumJava8==9);
    }

    @Test
    public void testUniqueSum2() {
        List<Integer> numbers = List.of(5);
        int minimumUniqueSum = MinimumUniqueSum.getMinimumUniqueSum(numbers);
        int minimumUniqueSumJava8 = MinimumUniqueSum.getMinimumUniqueSumJava8(numbers);
        assertTrue(minimumUniqueSum==5);
        assertTrue(minimumUniqueSumJava8==5);
    }
}
