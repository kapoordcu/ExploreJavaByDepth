package explore.topics._arrays;

//Given an unsorted array of size N. Find the first element in array such that
// all of its left elements are smaller and all right elements to it are greater than it.

public class DivideBySmallerAndGreater {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 4, 5, 6, 7, 7, 8};
        System.out.println(findIndexSmallerGreater(arr));
        System.out.println(findIndexSmallerGreaterUsingRightMax(arr));
    }

    private static int findIndexSmallerGreater(int[] arr) {
        int size = arr.length;
        int leftMax[] = new int[size];
        int rightMin = Integer.MAX_VALUE;
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i - 1]);
        }
        for (int i = size-1; i >=0; i--) {
            if (leftMax[i] < arr[i] && rightMin > arr[i]) {
                return i;
            }
            rightMin = Math.min(rightMin, arr[i]);
        }
        return -1;
    }


    private static int findIndexSmallerGreaterUsingRightMax(int[] arr) {
        int size = arr.length;
        int rightMin[] = new int[size];
        rightMin[size-1] = Integer.MAX_VALUE;
        for (int i = size-2; i >=0; i--) {
           rightMin[i] = Math.min(arr[i+1], rightMin[i+1]);
        }

        int leftMax = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if(arr[i] < rightMin[i] && arr[i] > leftMax) {
                return i;
            }
            leftMax = Math.max(arr[i], leftMax);
        }
        return -1;
    }
}
