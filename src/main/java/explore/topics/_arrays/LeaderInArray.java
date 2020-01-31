package explore.topics._arrays;

import java.util.*;

public class LeaderInArray {
    public static void main(String[] args) {
        int arr1[] = {16, 17, 4, 3, 5, 2};
        int arr2[] = {1, 2, 3, 4, 0};
        int arr3[] = {7, 4, 5, 7, 3};
        System.out.println(Arrays.toString(numberOfLeader(arr1).toArray()));
        System.out.println(Arrays.toString(numberOfLeader(arr2).toArray()));
        System.out.println(Arrays.toString(numberOfLeader(arr3).toArray()));
    }

    private static List<Integer> numberOfLeader(int[] arr) {
        List<Integer> result = new ArrayList<Integer>();
        int currentMax = arr[arr.length-1];
        result.add(currentMax);
        for (int i = arr.length-1; i >0 ; i--) {
            if(arr[i-1]>=currentMax) {
                result.add(arr[i-1]);
                currentMax = Math.max(currentMax, arr[i-1]);
            }
        }
        return result;
    }
}
