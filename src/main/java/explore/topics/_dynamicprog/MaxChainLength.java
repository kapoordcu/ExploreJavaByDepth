package explore.topics._dynamicprog;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaxChainLength {
    public static void main(String[] args) {
        int[] A = {5,  24, 39, 60, 15, 28, 27, 40, 50, 90};
        MaxChainLength chainLength = new MaxChainLength();
        chainLength.findChainLength(A);
    }

    private List<Pair> findChainLength(int[] A) {
        List<Pair> pairs  = new ArrayList<>();
        for (int i = 0; i < A.length; i+=2) {
            pairs.add(new Pair(A[i], A[i+1]));
        }
        List<Pair> sortedByEnd = pairs.stream()
                .sorted(Comparator.comparing(pair -> pair.st)).collect(Collectors.toList());
        return pairs;
    }

    static class Pair {
        public int st;
        public int end;

        public Pair(int st, int end) {
            this.st = st;
            this.end = end;
        }
    }
}
