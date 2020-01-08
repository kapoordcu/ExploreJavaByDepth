package explore.topics._codingproblmes2020;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


import static java.lang.Math.toIntExact;

public class CountIdenticalPairs {
    public static void main(String[] args) {
        int[] A = {3, 5, 6, 3, 3, 5 };
        CountIdenticalPairs pair = new CountIdenticalPairs();
        System.out.println(pair.solution(A));

    }

    public int solution(int[] A) {
        Map<Integer, Long> arrayByFrequency = IntStream.of(A).boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        return arrayByFrequency.values().stream()
                .mapToInt(v -> toIntExact((v * (v - 1) / 2)))
                .sum();
//        List<Pair> pairs = new ArrayList<>();
//        for (int i = 0; i < A.length; i++) {
//            for (int j = i+1; j < A.length; j++) {
//                if(((A[i] & A[j]) == A[i]) && (A[i]==A[j])) {
//                    pairs.add(new Pair(i, j));
//                }
//            }
//        }
//        return pairs.size();
    }


}