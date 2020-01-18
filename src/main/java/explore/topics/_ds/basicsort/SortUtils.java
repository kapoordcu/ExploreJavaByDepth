package explore.topics._ds.basicsort;

public class SortUtils {
    public static Comparable[] arr1 = {7, 10, 5, 3, 8, 4, 2};
    public static Comparable[] arr2 = {1, 2, 3, 4, 5, 6, 7};
    public static Comparable[] arr3 = {7, 6, 5,  4, 3, 2, 1};
    public static  int numbertimesExchangeCalled = 0;
    public static  int numbertimesLessCalled = 0;
    public static void exchange(Comparable[] arr, int i, int j) {
        numbertimesExchangeCalled++;
        Comparable swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    public static boolean less(Comparable v, Comparable w) {
        numbertimesLessCalled++;
        return v.compareTo(w) < 0;
    }
}
