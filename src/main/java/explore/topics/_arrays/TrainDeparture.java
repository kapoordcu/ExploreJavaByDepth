package explore.topics._arrays;

public class TrainDeparture {
    public static void main(String[] args) {
        String[] arr = { "0900",  "0940", "0950",  "1100", "1500", "1800"};
           String[] dep = { "0910",  "1200", "1120",  "1130", "1900", "2000"};

        quickSort(arr, 0, arr.length-1);
        quickSort(dep, 0, arr.length-1);
        System.out.println(mergeStep(arr, dep));

    }

    private static int mergeStep(String[] arr, String[] dep) {
        int i = 0;
        int j = 0;
        int platforms = 0;
        int max = 0;
        while (i<arr.length && j<dep.length) {
            if(compareStringTime(arr[i], dep[j]) < 0) {
                platforms += 1;
                max = Math.max(max, platforms);
                i++;
            } else {
                platforms -= 1;
                j++;
            }
        }
        return max;
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
