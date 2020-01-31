package explore.topics._arrays;


import java.util.Arrays;

public class ReverseArrayInKGroups {
    public static void main(String[] args) {
        int[] arr = {6,9,1,3,4,6,5,7,2,1,3};
        int groupSize = 3;
        reverse(arr, groupSize);
        System.out.println(Arrays.toString(arr));
    }

    //Time complexity of above solution is O(n).
    //Auxiliary space used by the program is O(1).
    private static void reverse(int[] arr, int k) {
        if(k>arr.length) {
            return;
        }
        int i = 0;
        for (; i < arr.length; i+=k) {
            reverse(arr, i, Math.min(i+k-1, arr.length-1)) ;
        }
    }

    private static void reverse(int[] arr, int start, int end) {
        int i = start;
        int j = end;
        while (i<=j) {
            swap(arr, i++, j--);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
