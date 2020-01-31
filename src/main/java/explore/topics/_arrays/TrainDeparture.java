package explore.topics._arrays;

public class TrainDeparture {
    public static void main(String[] args) {
        String[] arr = { "0900",  "0940", "0950",  "1100", "1500", "1800"};
           String[] dep = { "0940",  "1200", "1120",  "1130", "1900", "2000"};

        quickSort(arr, 0, arr.length-1);
        quickSort(dep, 0, arr.length-1);
        mergeStep(arr, dep);

    }

    private static void mergeStep(String[] arr, String[] dep) {
        int i = 0;
        while (i <arr.length) {
            if(compareStringTime(arr[i] , dep[0]) <= 0) {
                i++;
            } else {
                swapTwoArrayElement(arr, dep, i, 0);
                sortRemainingArray(dep);
            }
        }
    }

    private static void sortRemainingArray(String[] a2) {
        String element = a2[0];
        int k=1;
        while (k<a2.length && compareStringTime(a2[k],element)<0) {
            a2[k-1] = a2[k];
            k++;
        }
        a2[k-1] = element;
    }

    private static void swapTwoArrayElement(String[] arr, String[] dep, int i, int j) {
        String temp = arr[i];
        arr[i] = dep[0];
        dep[0] = temp;
    }

    private static void quickSort(String[] arr, int low, int high) {
        if(high<=low) {
            return;
        }

        int j = partition(arr, low, high);
        quickSort(arr, low, j-1);
        quickSort(arr, j+1, high);
    }

    private static int partition(String[] arr, int low, int high) {
        int pivot = (low+high)/2;
        int i=low; int j = high;
        while (i<j) {
            int leftHigh = compareStringTime(arr[i], arr[pivot]);
            int rightLow = compareStringTime(arr[j], arr[pivot]);
            if(leftHigh<0){
                i++;
            }
            if(rightLow>=0){
                j--;
            }
            if(leftHigh>=0 && rightLow<0) {
                swap(arr, i++, j--);
            }

        }
        swap(arr, pivot, j);
        return j;
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[j];
                arr[j] = arr[i];
        arr[i] = temp;
    }

    public static int compareStringTime(String arr, String dep) {
        return arr.compareTo(dep);
    }

}
