package explore.topics.testlive.amazon;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntersectionList {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 5, 2, 1);
        List<Integer> list2 = Arrays.asList( 3, 1, 3);
        System.out.println(intersect(list1, list2));
        List<Integer> mergedArrays = intersectMultipleOccurance(list1, list2);
    }

    public static List<Integer> intersectMultipleOccurance(List<Integer> list1, List<Integer> list2) {
        Map<Integer, Long> first = countMap(list1);
        Map<Integer, Long> second = countMap(list2);
        second.forEach((k, v) -> first.merge(k, v, Long::min));
        return mapToListWithCount(first);
    }

    private static List<Integer> mapToListWithCount(Map<Integer, Long> mapNumbers) {
        List<Integer> numberList = new ArrayList<>();
        mapNumbers.entrySet()
                .stream()
                .forEach(entry -> {
                    numberList.addAll(Collections.nCopies(Math.toIntExact(entry.getValue()), entry.getKey()));
                });
        return numberList;
    }

    public static List<Integer> intersect(List<Integer> list1, List<Integer> list2) {
        Set<Integer> list2Set = new HashSet<>(list2);
        return list1.stream()
                .filter(e -> list2Set.contains(e))
                .collect(Collectors.toList());
    }

    private static Map<Integer, Long> countMap(List<Integer> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }
}
