package specials;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class DumblePlateMove {
    public static int getMinMoves(List<Integer> plates) {
        int l = 0;
        int r = plates.size() - 1;
        int[] arrayPlates = plates.stream().mapToInt(a -> a).toArray();
        return adjacentSwaps(arrayPlates, l, r);
    }

    private static int adjacentSwaps(int[] a, int l, int r) {
        int adjacentSwapsCount = 0;
        if(l < r)   {
            int mid = l + (r-l)/2;
            adjacentSwapsCount = adjacentSwaps(a, l, mid) + adjacentSwaps(a, mid+1, r);
            adjacentSwapsCount += swapOneElementAtATime(a, l, mid, r);
            return adjacentSwapsCount;
        }
        return adjacentSwapsCount;
    }

    private static long swapOneElementAtATime(int[] a, int l, int mid, int r) {
        int[] auxArray = new int[a.length];
        long adjacentSwaps = 0;

        int i = l;
        int j = mid+1;
        int k = l;

        while(i<=mid && j<=r) {
            if(a[i] <= a[j])    {
                auxArray[k++] = a[i++];
            }
            else {
                auxArray[k++] = a[j++];
                adjacentSwaps += mid - i + 1;
            }
        }
        adjustTheAuxilaryArrayToSort(i, j, k, l, mid, r, a, auxArray);
        return adjacentSwaps;
    }

    private static void adjustTheAuxilaryArrayToSort(int i, int j, int k, int l, int mid, int r, int[] a, int[] auxArray) {
        while(i <= mid) {
            auxArray[k++] = a[i++];
        }

        while(j <= r) {
            auxArray[k++] = a[j++];
        }

        for(i=l; i<=r; i++)  {
            a[i] = auxArray[i];
        }
    }

    @Test
    public void testOne23() {
        List<Integer> products = List.of(1,2,3);
        int combis = DumblePlateMove.getMinMovesRight(products);
        assertTrue(combis==0);
    }

    @Test
    public void testOne() {
        List<Integer> products = List.of(3, 2, 1);
        int combis = DumblePlateMove.getMinMovesRight(products);
        assertTrue(combis==3);
    }


    @Test
    public void testOne2() {
        List<Integer> products = List.of(5,2,4,3,1,6);
        int combis = DumblePlateMove.getMinMovesRight(products);
        assertTrue(combis==4);
    }

    @Test
    public void testThree() {
        List<Integer> products = List.of(5,4,11, 9,10,12);
        int combis = DumblePlateMove.getMinMovesRight(products);
        assertTrue(combis==1);
    }

    private static int getMinMovesRight(List<Integer> products) {
        int minIndex = 0;
        int maxIndex = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i) < min) {
                minIndex = i;
                min = products.get(i);
            }
            if(products.get(i) > max) {
                maxIndex = i;
                max = products.get(i);
            }
        }
        return countSwaps(products, minIndex, maxIndex);
    }

    private static int countSwaps(List<Integer> products, int minIndex, int maxIndex) {
        int[] weights = products.stream().mapToInt(Integer::intValue).toArray();
        int maxValue = weights[maxIndex];
        int swaps = 0;
        for (int i = minIndex; i > 0; i--) {
            if(weights[i]==maxValue) {
                maxIndex = i-1;
            } else if(weights[i-1]==maxValue) {
                maxIndex = i;
            }
            int swapped = weights[i];
            weights[i] = weights[i-1];
            weights[i-1] = swapped;
            swaps++;

        }
        for (int i = maxIndex; i < weights.length-1; i++) {
            int swapped = weights[i];
            weights[i] = weights[i+1];
            weights[i+1] = swapped;
            swaps++;
        }
        return swaps;
    }
}
