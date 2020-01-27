package explore.topics.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SumKInSortedArray {
    public static void main(String[] args) {
        int[] array = { 1, 5, 3, 2, 4};
        //shuffle(array);
        SumKInSortedArray sore = new SumKInSortedArray();
        sore.findIndicesUsingLowHighPointers(array, 14);
        sore.findIndicesUsingHash(array, 5);
        System.out.println();
    }

    private static void shuffle(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int random = i + new Random().nextInt(array.length-i);
            swap(array, i, random);
        }
    }

    private static void swap(int[] array, int i, int random) {
        int temp = array[i];
        array[i] = array[random];
        array[random] = temp;
    }

    private List<String> findIndicesUsingLowHighPointers(int[] array, int target) {
        List<String> indices = new ArrayList<>();
        int low = 0;
        int high = array.length-1;

        while (low<high) {
            int value = array[low] + array[high];
            if(value==target) {
                indices.add(low++ + ":" + high);
            } else if(value<target) {
                low++;
            } else if(value>target) {
                high--;
            }
        }
        return indices;
    }

     /*
        Time Complexity: O(n)
        Auxiliary Space: O(n) where n is size of array.
     */
    private List<String> findIndicesUsingHash(int[] array, int target) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        List<String> indices = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if(sumMap.containsKey(target-array[i])) {
                indices.add(sumMap.get(target-array[i]) + ":" + i);
            }
            sumMap.put(array[i], i);
        }
        return indices;
    }

}
