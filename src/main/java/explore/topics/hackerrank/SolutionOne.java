package explore.topics.hackerrank;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutionOne {
    static Map<String, Integer> groupedResults = new LinkedHashMap<String, Integer>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int _count;
        _count = Integer.parseInt(in.nextLine());

        OutputMostPopularDestination(_count, in);
    }

    static void OutputMostPopularDestination(int count, Scanner in) {
        for (int i = 0; i < count; i++) {
            String destination = in.next();
            if(groupedResults.containsKey(destination)) {
                groupedResults.put(destination, groupedResults.get(destination) + 1);
            } else {
                groupedResults.put(destination, 0);
            }
        }
        Map.Entry<String, Integer> maxEntry = groupedResults.entrySet().stream()
                .max(Map.Entry.comparingByValue()).get();
        System.out.println(maxEntry.getKey());

    }
}
