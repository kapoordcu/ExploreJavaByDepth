package specials;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MaxIncreasingSubArray {

    @Test
    public void testOne() {
        List<Integer> products = List.of(7,4,5,2,6,5);
        long combis = MaxIncreasingSubArray.findMaxProducts(products);
        assertTrue(combis==12);
    }

    @Test
    public void testOne2() {
        List<Integer> products = List.of(6,2,9,4,7,5,2);
        long combis = MaxIncreasingSubArray.findMaxProducts(products);
        assertTrue(combis==17);
    }

    public static long findMaxProducts(List<Integer> products) {
        long maxPile = 0;
        int[] arrayProducts = null;
        for (int i = products.size() - 1; i >=0 ; i--) {
            arrayProducts = products.stream().mapToInt(a -> a).toArray();
            long findMaxPileSum = findMaxPileForIndex(arrayProducts, i);
            maxPile = Math.max(findMaxPileSum, maxPile);
            System.out.println(products.get(i));
        }
        return maxPile;
    }

    private static long findMaxPileForIndex(int[] arrayProducts, int indx) {
        long maxPileSum = arrayProducts[indx];
        for (int i = indx - 1; i >=0 ; i--) {
            int picked = Math.min(arrayProducts[i], arrayProducts[indx] - 1);
            arrayProducts[i] = picked;
            indx--;
            maxPileSum += picked;
            if(picked==1) {
                return maxPileSum;
            }
        }
        return maxPileSum;
    }


}
