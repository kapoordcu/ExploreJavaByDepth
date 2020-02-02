package explore.topics._arrays;

import java.util.Arrays;

public class FindTripletInArray {
    public static void main(String[] args) {
        FindTripletInArray find = new FindTripletInArray();
        int arr[] = {3, 1, 4, 6, 5};
        int arr2[] = {10, 4, 6, 12, 5};
        //System.out.println(find.findTripletNaiveON2(arr));
        //System.out.println(find.findTripletNaiveON2(arr2));
        System.out.println(find.checkTriplet(arr, arr.length));
        System.out.println(find.checkTriplet(arr2, arr2.length));
    }

    private boolean findTripletNaiveON2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= arr[i];
        }
        Arrays.sort(arr);
        for (int i = arr.length-1; i >=0 ; i--) {
            int fixed = arr[i];
            int low = 0;
            int high = i-1;
            while (low<high) {
                if(arr[low] + arr[high] == fixed) {
                    return true;
                } else if(arr[low] + arr[high] > fixed) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return false;
    }

    public boolean checkTriplet(int arr[], int n) {
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(arr[i]*arr[i] > maximum) {
                maximum = arr[i]*arr[i];
            }
        }
        boolean[] hash = new boolean[maximum + 1];
        for (int i = 0; i < n; i++) {
            int square = arr[i]*arr[i];
            hash[square]=true;
        }
        for (int i = 1; i < maximum + 1; i++) {
            if (hash[i]) {
                for (int j = 1; j < maximum + 1; j++) {
                    if (i != j && hash[i] && hash[j] && ((i+j) < maximum+1)) {
                        if(hash[i+j]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
