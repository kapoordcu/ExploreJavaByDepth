package specials;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class HeaviestSet {

    @Test
    public void testHj() {
        List<Integer> array = List.of(3, 7, 5, 6, 2);
        List<Integer> swaps = HeaviestSet.minimalHeaviestSetA(array);
        assertTrue(swaps.size()==2);
        assertTrue(swaps.get(0)==6);
        assertTrue(swaps.get(1)==7);
    }

    @Test
    public void testSameElementsEven() {
        List<Integer> array = List.of(3,3,3,3);
        List<Integer> swaps = HeaviestSet.minimalHeaviestSetA(array);
        assertTrue(swaps.size()==3);
        assertTrue(swaps.get(0)==3);
        assertTrue(swaps.get(1)==3);
        assertTrue(swaps.get(1)==3);
    }

    @Test
    public void testSameElementsOdd() {
        List<Integer> array = List.of(3,3,3,3, 3);
        List<Integer> swaps = HeaviestSet.minimalHeaviestSetA(array);
        assertTrue(swaps.size()==3);
        assertTrue(swaps.get(0)==3);
        assertTrue(swaps.get(1)==3);
        assertTrue(swaps.get(1)==3);
    }

    @Test
    public void testEmptyList() {
        List<Integer> array = List.of();
        List<Integer> swaps = HeaviestSet.minimalHeaviestSetA(array);
        assertTrue(swaps.size()==0);
    }

    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        // Write your code here
        if(arr == null) {
            return new ArrayList<>();
        }
        List<Integer> sortedWeights  = arr.stream().sorted().collect(Collectors.toList());
        List<Integer> subsetA = new ArrayList<>();
        int sumA = 0;
        int sumTotal = arr.stream().mapToInt(a -> a).sum();
        for (int i = sortedWeights.size() - 1; i >=0 ; i--) {
            Integer weight = sortedWeights.get(i);
            subsetA.add(weight);
            sumA += weight;
            sumTotal -= sortedWeights.get(i);
            if(sumTotal< sumA) {
                Collections.sort(subsetA);
                return subsetA;
            }
        }
        return sortedWeights;
    }
}
