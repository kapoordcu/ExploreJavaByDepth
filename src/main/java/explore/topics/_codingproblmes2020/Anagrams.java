package explore.topics._codingproblmes2020;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Anagrams {
    public static void main(String[] args) {
        String key = "loop";
        String[] values = {"polo", "poole", "rest", "pol"};
        System.out.println(count(key, values));
    }

    private static int count(String key, String[] values) {
        List<String> strings = Arrays.asList(values);
        List<String> sorted = strings.stream()
                .map(value -> sort(value))
                .collect(Collectors.toList());
        String sortKey = sort(key);
        return (int)sorted.stream()
                .filter(v -> v.equals(sortKey))
                .count();
    }

    private static String sort(String value) {
        char tempArray[] = value.toCharArray();
        // sort tempArray
        Arrays.sort(tempArray);
        // return new sorted string
        return new String(tempArray);
    }
}
