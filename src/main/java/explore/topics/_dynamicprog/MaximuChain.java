package explore.topics._dynamicprog;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaximuChain {
    public static void main(String[] args) {
        MaximuChain chain = new MaximuChain();
        int[] A = {5, 24, 39, 60, 15, 28, 27, 40, 50, 90};
        System.out.println(chain.findMaxChain(A, A.length));
    }

    private int findMaxChain(int[] A, int size) {
        List<Pair> pairs = findPairByStart(A, size);
        int len = 1;
        Pair[] pairsMaxChain = new Pair[size/2];
        pairsMaxChain[0] = pairs.get(0);
        for (int i = 1; i < pairs.size(); i++) {
            if(pairsMaxChain[len-1].high > pairs.get(i).low) {
                if(pairsMaxChain[0].high > pairs.get(i).high) {
                    pairsMaxChain[0] = pairs.get(i);
                }
            } else if((pairsMaxChain[len-1].high < pairs.get(i).high)) {
                pairsMaxChain[len++] = pairs.get(i);
            }
        }
        int chainLength = 0;
        for (int i = 0; i < pairsMaxChain.length; i++) {
            if(pairsMaxChain[i]!=null) {
                chainLength++;
            }
        }
        return chainLength;
    }

    private List<Pair> findPairByStart(int[] A, int size) {
        Pair[] pairs = new Pair[size/2];
        for (int i = 0; i < size/2; i++) {
            pairs[i] = new Pair(A[2*i], A[2*i+1]);
        }
        return Arrays.asList(pairs).stream()
                .sorted(Comparator.comparing(pair -> pair.low))
                .collect(Collectors.toList());

    }

    static class Pair {
        public int low;
        public int high;

        public Pair(int low, int high) {
            this.low = low;
            this.high = high;
        }
    }
}
