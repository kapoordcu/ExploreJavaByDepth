package explore.topics._ds.basicsort;

public class SortUtils {
    public static  int numbertimes = 0;
    public static void exchange(Comparable[] arr, int i, int j) {
        numbertimes++;
        Comparable swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
