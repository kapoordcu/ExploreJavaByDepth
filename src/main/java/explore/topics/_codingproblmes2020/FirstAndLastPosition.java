package explore.topics._codingproblmes2020;

import java.util.Arrays;

//Find First and Last Position of Element in Sorted Array
public class FirstAndLastPosition {
    public static void main(String[] args) {
        Comparable[] arr = {1, 2, 5, 7, 7, 7, 7, 7, 9, 13};
        FirstAndLastPosition pos = new FirstAndLastPosition();
        Comparable key = 7;
        int[] result = new int[2];
        result[0] = pos.findPosition(arr, key, true);
        result[1] = pos.findPosition(arr, key, false);
        System.out.println(result[0] + " : " + result[1]);
    }

    private int findPosition(Comparable[] arr, Comparable key, boolean first) {
        int low = 0;
        int high = arr.length-1;
        int index = -1;
        while (low<=high) {
            int mid = (low+high)/2;
            int comp = key.compareTo(arr[mid]);
            if(comp==0) {
                index=mid;
                if(first) {
                    high = mid -1;
                } else {
                    low = mid +1;
                }

            } else if(comp<0) {
                high = mid-1;
            } else if(comp>0) {
                low=mid+1;
            }
        }
        return index;
    }
}
