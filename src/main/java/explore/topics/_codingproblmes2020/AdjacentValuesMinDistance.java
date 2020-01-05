package explore.topics._codingproblmes2020;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdjacentValuesMinDistance {
    public static void main(String[] args) {
        int[] A = { 1, 4, 7, 3, 3, 5};
        AdjacentValuesMinDistance distance = new AdjacentValuesMinDistance();
        System.out.println(distance.solution(A));

    }
    public int solution(int[] A) {
        List<Integer> elements = new ArrayList<>();
        Set<Integer> arrToList = IntStream.of(A).boxed().collect(Collectors.toSet());
        int arrLen = A.length;
        if(arrLen<1 || arrToList.size()==1) {
            return -1;
        }
        for (int i = 0; i < arrLen; i++) {
            for (int j = i + 1; j < arrLen; j++) {
                if(A[i]!=A[j]) {
                    Boolean adjacentPair = checkAdjacency(arrToList, A[i], A[j]);
                    if(adjacentPair) {
                        elements.add(Math.abs(i - j));
                    }
                }
            }
        }

        return Collections.min(elements);
    }

    private Boolean checkAdjacency(Set<Integer> A, int a, int b) {
        int sum = a + b;
        int min = Math.min(a, b);
        int max = sum - min;
        if(max-min>1) {
            List<Integer> range = IntStream.range(min+1, max).boxed().collect(Collectors.toList());
            range.retainAll(A);
            if(range.size()>0) {
                return false;
            }
            return true;
        }

        return true;
    }

}
