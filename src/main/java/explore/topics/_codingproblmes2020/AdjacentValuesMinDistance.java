package explore.topics._codingproblmes2020;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdjacentValuesMinDistance {
    public static void main(String[] args) {
        int[] integers = { 1, 4, 7 , 3, 3, 5 };
        System.out.println(AdjacentValuesMinDistance.solutionOptimal(integers));

    }

    public static int solutionOptimal(int[] A) {
        List<Pair> elements = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            elements.add(new Pair(A[i], i));
        }
        Collections.sort(elements, Comparator.comparing(Pair::getValue));
        Map<Integer, List<Pair>> groupByValues = elements.stream()
                .collect(Collectors.groupingBy(Pair::getValue));
        return 0;
    }

    public static int solution(int[] A) {
        if(A.length==0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int arrLen = A.length; // 6
        for (int i = 0; i < arrLen; i++) {
            for (int j = i+1; j < arrLen; j++) {
                if(A[i]!=A[j]) {
                    if(!checkAdjacent(A, Math.min(A[i], A[j]), Math.max(A[i], A[j]))) {
                        min = Math.abs(i-j) < min ?  Math.abs(i-j): min;
                    }
                }
            }
        }
        return min;
    }

    private static boolean checkAdjacent(int[] A, int i, int j) {
        List<Integer> elements = IntStream.of(A).boxed().collect(Collectors.toList());
        return elements.stream()
                .anyMatch(v -> v > i && v < j);
    }

}

class Pair {
    private Integer value;
    private Integer index;

    public Pair(Integer value, Integer index) {
        this.value = value;
        this.index = index;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getIndex() {
        return index;
    }
}