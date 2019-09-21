package explore.topics.ocado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toMap;

public class OcadoApp {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 4, 7, 7, 6, 6}));
    }
    public static int solution(int[] T) {
        // write your code in Java SE 8
        List<Integer> candyVariety = Arrays.stream(T).boxed().collect(Collectors.toList());
        List<Integer> candyUniqueVarietyWithMary = new ArrayList();
/*
        // Java 7
        Map<Integer, Integer> candyCountMap = new HashMap<Integer, Integer>();
        for(Integer candy: candyVariety) {
            if(candyCountMap.containsKey(candy)) {
                int count = candyCountMap.get(candy);
                candyCountMap.put(candy, count +1);
            } else {
                candyCountMap.put(candy, 1);
            }
        }
        */

        Map<Integer, Integer> candyCountMap = candyVariety.stream()
                .collect(Collectors.groupingBy(Function.identity(), reducing(0, e -> 1, Integer::sum)));

        int candiesToGive = candyVariety.size()/2;
        Map<Integer, Integer> sortedByCount = candyCountMap
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

        for (Map.Entry<Integer, Integer> entry : sortedByCount.entrySet()) {
            if(candyUniqueVarietyWithMary.size() == candiesToGive) {
                break;
            } else {
                candyUniqueVarietyWithMary.add(entry.getKey());
            }
        }
        /*candyUniqueVarietyWithMary.stream().forEach(e-> System.out.println(e));*/
        return candyUniqueVarietyWithMary.size();
    }
}
