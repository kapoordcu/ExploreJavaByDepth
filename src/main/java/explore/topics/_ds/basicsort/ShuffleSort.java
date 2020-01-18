package explore.topics._ds.basicsort;

import java.util.Arrays;
import java.util.Random;

public class ShuffleSort {
    public static void main(String[] args) {
        ShuffleSort sort = new ShuffleSort();
        sort.shuffleSort(SortUtils.arr2);
        System.out.println(Arrays.toString(SortUtils.arr2));
    }

    private void shuffleSort(Comparable[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int r = random.nextInt(i+1);
            SortUtils.exchange(arr, i, r);
        }
    }
}
