package explore.topics._arrays;

import java.util.Arrays;

public class DistributeChoco {

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 9, 56, 7, 9, 12};
        int[] arr2 = {7, 3, 2, 4, 9, 12, 56};
        int arr3[] = {12, 4, 7, 9, 2, 23, 25, 41,
                30, 40, 28, 42, 30, 44, 48,
                43, 50};
        System.out.println(minDifference(arr, 5));
        System.out.println(minDifference(arr2, 3));
        System.out.println(minDifference(arr3, 7));
    }

    private static int minDifference(int[] arr, int totalStudents) {
        Arrays.sort(arr);
        int min = arr[arr.length-1]-arr[0];
        for (int i = 0; i < arr.length-totalStudents+1; i++) {
            min = Math.min(min, arr[i+totalStudents-1]-arr[i]);
        }
        return min;
    }
}
