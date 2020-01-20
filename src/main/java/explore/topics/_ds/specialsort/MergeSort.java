package explore.topics._ds.specialsort;


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
public class MergeSort {

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] arr = {7, 3, 2, 5};
        sort.mergeSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr, int low, int high) {
        System.out.println("Merge sort of " + low + ", " + high);
        if(low<high) {
            int mid = (low + high)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] originalArr, int low, int mid, int high) {
        int leftSize = mid-low+1;
        int rightSize=high-mid;

        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArr[i] = originalArr[low+i];
        }
        for (int i = 0; i < rightSize; i++) {
            rightArr[i] = originalArr[mid+1+i];
        }

        int i=0,j=0, k=low;
        while (i<leftSize && j<rightSize) {
            if(leftArr[i]<rightArr[j]) {
                originalArr[k++] = leftArr[i++];
            } else {
                originalArr[k++] = rightArr[j++];
            }
        }

        for (; i < leftSize; i++) {
            originalArr[k++] = leftArr[i++];
        }

        for (; j < leftSize; j++) {
            originalArr[k++] = rightArr[j++];
        }
    }

    private boolean assertSortedArray(Comparable[] arr, int low, int high) {
        boolean sorted = true;
        for (int i = low; i < high -1 ; i++) {
            if(arr[i].compareTo(arr[i+1])>0) {
                sorted &= false;
            }
        }
        return sorted;
    }

}
