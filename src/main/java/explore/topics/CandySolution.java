package explore.topics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CandySolution {
    public static void main(String[] args) {
       int[] T = {3, 4, 7, 7, 6, 6};

       // 3 --> 1
        // 4 --> 1
        // 7 --> 2
        // 6--> 2
        CandySolution solution = new CandySolution();
        System.out.println(solution.solution(T));
    }

    public int solution(int[] T) {
        List<Integer> candies = IntStream.of(T).boxed().collect(Collectors.toList());
        Map<Integer, Integer> candyMap = new HashMap<>();
        for (int i = 0; i < candies.size(); i++) {
            Integer type = candies.get(i);
            if(candyMap.containsKey(type)) {
                int count = candyMap.get(type);
                candyMap.put(type, ++count);
            } else {
                candyMap.put(type, 1);
            }
        }
        int toGive = T.length/2;
        int typeGiven = 0;
        for (Map.Entry entry : candyMap.entrySet()) {
            if((int)entry.getValue()>1) {
                typeGiven++;
            }
            if(typeGiven==toGive) {
                return typeGiven;
            }
        }

        for (Map.Entry entry : candyMap.entrySet()) {
            if((int)entry.getValue()==1) {
                typeGiven++;
                candyMap.remove(entry);
            }
            if(typeGiven==toGive) {
                return typeGiven;
            }
        }


        // write your code in Java SE 8
        return typeGiven;
    }
}
