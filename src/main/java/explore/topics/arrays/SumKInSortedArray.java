package explore.topics.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumKInSortedArray {
    public static void main(String[] args) {
        int[] array = { 0, 1,3, 5, 6,8,9,11,14 };
        SumKInSortedArray sore = new SumKInSortedArray();
        sore.findIndicesUsingLowHighPointers(array, 14);
        sore.findIndicesUsingHash(array, 14);
        System.out.println();
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

    private int findIndicesUsingHash(int[] array, int target) {
        Set<Integer> sumMap = new HashSet<>();
        int numberPairs = 0;
        for (int i = 0; i < array.length; i++) {
            if(sumMap.contains(target-array[i])) {
                numberPairs++;
            }
            sumMap.add(array[i]);
        }
        return numberPairs;
    }

}
