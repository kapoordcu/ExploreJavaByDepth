package explore.topics.sortingalgos;

import java.util.Arrays;
// https://www.youtube.com/watch?v=ak-pz7tS5DE
// Merging is done in post order
//PROS
    // Very Large Size List (1 million)
    // Suitable for LinkedList (two LL can be mergegd by just changing the links , No ned to create third list)
    // Merge sort supports external sorting
    // Stable (Duplicate elements should have same order)

//CONS
    // Not in-place sorting algorithms, need extra space (for arrays, not linked list)
    // No small problem , small size list its much slower, waste a lot of time in recursion (n < 15)
    // Take help of Insertion sort(stable) , other Stable sort: bubble Sort O(n^2)
    // recursive algorithm(use stack) --> max size = logN at a time
    // Extra space (n "auxillary" + logN "stack")
public class MergeSortApp {
    static int[] unsortedNumbers = {10, 16, 12, 15, 6, 3, 9, 8};
    static int[] a1 = {2, 5, 9};
    static int[] a2 = {3, 6};
    public static void main(String[] args) {
        mergeSort(0, unsortedNumbers.length-1);
        System.out.println(Arrays.toString(unsortedNumbers));
    }

    private static void mergeSort(int low, int high) {
        if(low<high) {
            int mid = (low + high)/2;
            mergeSort(low, mid);
            mergeSort(mid+1, high);
            merge(low, mid, high);
        }
    }

    private static void merge(int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = unsortedNumbers[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = unsortedNumbers[m + 1+ j];
        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while(i < n1 && j < n2) {
            if(L[i] > R[j]) {
                unsortedNumbers[k++] = R[j++];
            } else {
                unsortedNumbers[k++] = L[i++];
            }
        }
        for(;i<n1; i++) {
            unsortedNumbers[k++] = L[i];
        }
        for(;j<n2; j++) {
            unsortedNumbers[k++] = R[j];
        }
    }

    private static void swapThem(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    private static int[] mergeArray(int[] array1, int[] array2) {
        int l1 = array1.length;
        int l2 = array2.length;
        int[] returnMegedArray = new int[l1+l2];
        int i = 0, j=0, k = 0;
        while(i < l1 && j < l2) {
            if(array1[i] > array2[j]) {
                returnMegedArray[k++] = array2[j++];
            } else {
                returnMegedArray[k++] = array1[i++];
            }
        }
        for(;i<l1; i++) {
            returnMegedArray[k++] = array1[i];
        }
        for(;j<l2; j++) {
            returnMegedArray[k++] = array2[j];
        }
        return returnMegedArray;
    }
}
