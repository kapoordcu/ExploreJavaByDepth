package specials;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class RiceBags {
    static boolean coverAll = false;
    @Test
    public void testOne() {
        coverAll = false;
        int[] ricebag = {3, 27, 4, 2, 16};
        int biggest = RiceBags.findBiggestSet(ricebag);
        int biggest2 = RiceBags.countGrainDP(ricebag);
        assertTrue(biggest==3);
        assertTrue(biggest2==3);
    }

    @Test
    public void testOneAgain() {
        coverAll = false;
        int[] ricebag = {3, 9, 81, 256, 4, 2, 16};
        int biggest = RiceBags.findBiggestSet(ricebag);
        int biggest2 = RiceBags.countGrainDP(ricebag);
        assertTrue(biggest==4);
        assertTrue(biggest2==4);
    }

    @Test
    public void testOneWith() {
        coverAll = false;
        int[] ricebag = {3, 27, 4, 81, 16};
        int biggest = RiceBags.findBiggestSet(ricebag);
        int biggest2 = RiceBags.countGrainDP(ricebag);
        assertTrue(biggest==-1);
        assertTrue(biggest2==-1);
    }

    @Test
    public void testTwo() {
        coverAll = false;
        int[] ricebag = {3, 2};
        int biggest = RiceBags.findBiggestSet(ricebag);
        int biggest2 = RiceBags.countGrainDP(ricebag);
        assertTrue(biggest==-1);
        assertTrue(biggest2==-1);
    }

    private static int findBiggestSet(int[] ricebags) {
        Set<Integer> bagSet = new TreeSet<>();
        int maxSizeSet = 0;
        for (int i = 0; i < ricebags.length - 1 ; i++) {
            if(ricebags[i+1]%ricebags[i]==0 || ricebags[i]%ricebags[i+1]==0) {
                bagSet.add(ricebags[i]);
                bagSet.add(ricebags[i+1]);
            } else {
                if(!bagSet.isEmpty() && perfectSet(bagSet)) {
                    maxSizeSet = Math.max(maxSizeSet, bagSet.size());
                }
                bagSet.clear();
            }
        }
        if(!bagSet.isEmpty() && perfectSet(bagSet)) {
            maxSizeSet = Math.max(maxSizeSet, bagSet.size());
        }
        if(maxSizeSet<2) {
            return -1;
        }
        return maxSizeSet;
    }

    private static boolean perfectSet(Set<Integer> bagSet) {
        List<Integer> collect = bagSet.stream().collect(Collectors.toList());
        boolean perfectSet = true;
        for (int i = collect.size() - 1; i >0 ; i--) {
            if(collect.get(i) != collect.get(i-1)*collect.get(i-1)) {
                perfectSet = perfectSet & false;
            }
        }
        return perfectSet;
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

    static int countGrainDP(int [] arr)
    {
        int start = 0;
        int startVal = arr[0];
        int result = Integer.MIN_VALUE;
        return countGrainsUtil(arr,start,result,startVal);
    }

    static int countGrainsUtil(int[] arr, int start,int result,int startVal) {
        if(start == arr.length - 1)
        {
            return result;
        }

        int k = 0;
        for(int i = start ; i< arr.length-1; i++)
        {
            if(k == arr.length)
            {
                coverAll = true;
                break;
            }
            int temp = 0;
            for(k = i+1 ; k < arr.length ; k++)
            {
                int min = Math.min(startVal,arr[k]);
                int max = Math.max(startVal,arr[k]);
                if(min*min == max)
                {
                    temp++;
                    result = Math.max(temp,result);
                    startVal = max;
                }
                else
                {
                    int nextCombination = countGrainsUtil(arr,k,result,arr[k]);
                    if(coverAll)
                    {
                        return result = Math.max(result,nextCombination);
                    }

                }
            }
        }
        return result == Integer.MIN_VALUE ? -1 : result+1;
    }
}
