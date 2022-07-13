package specials;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class RiceBags {

    @Test
    public void testOne() {
        int[] ricebag = {3, 27, 4, 2, 16};
        int biggest = RiceBags.findBiggestBag(ricebag);
        assertTrue(biggest==3);
    }

    @Test
    public void testTwo() {
        int[] ricebag = {3, 2};
        int biggest = RiceBags.findBiggestBag(ricebag);
        assertTrue(biggest==-1);
    }

    private static int findBiggestBag(int[] ricebag) {
        Map<Integer, List<Integer>> riceBagGroup = new HashMap<>();

        for (int i = 0; i < ricebag.length; i++) {
            int number = ricebag[i];
            List<Integer> primeFactorList = Eratosthene.sieveOfEratosthenes(number);
            for (int j = 0; j < primeFactorList.size(); j++) {
                Integer primeFactor = primeFactorList.get(j);
                if(number % primeFactor == 0) {
                    riceBagGroup.merge(primeFactor,
                            new ArrayList<>() {{add(number);}},
                            (small, big) -> { small.add(number); return small;}
                    );
                }
             }

        }
        int maxSize = 0;
        riceBagGroup.entrySet().forEach(v -> {

        } );
        for(Map.Entry<Integer, List<Integer>> v: riceBagGroup.entrySet()) {
            if(v.getValue().size() > maxSize) {
                maxSize = v.getValue().size();
            }
        }
        return maxSize >=2 ? maxSize : -1;
    }
}
