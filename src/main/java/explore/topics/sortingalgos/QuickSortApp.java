package explore.topics.sortingalgos;

import java.util.Arrays;

//Recursive, Divide and Conquer
// In Place algorithm

// Best Case (nlogn) - Partition in the middle (pivot should be Median) :  https://www.youtube.com/watch?v=-qOVVRIZzao
// Worst Case (n^2) - Partition will be happening at the beginning of the list
// Achieveing best case is not guaranteed, randomly happen that pivot is median

public class QuickSortApp {

    static int[] unsortedNumbers = {10, 16, 12, 15, 6, 3, 9, 8};

    public static void main(String[] args) {
        quickSort(0, unsortedNumbers.length-1);
        System.out.println(Arrays.toString(unsortedNumbers));
    }

    private static void quickSort(int low, int high) {
        if(low<high) {
            int pivot = partition(low, high);
            quickSort(low, pivot);
            quickSort(pivot+1, high);
        }
    }
    private static int partition(int low, int high) {
        int pivot = unsortedNumbers[low];
        int i = low, j = high;

        while(i<j) {
            while(unsortedNumbers[i] <= pivot & i<high) {
                i++;
            }
            while(unsortedNumbers[j] > pivot && j>low) {
                j--;
            }
            if(i<j) {
                swapThem(unsortedNumbers, i, j);
            }
        }
        swapThem(unsortedNumbers, low, j);
        return j;
    }

    private static void swapThem(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }
}

