package explore.topics.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PackNeigboringNumbers {


    static List<String> packNumbers(List<Integer> arr) {
        List<String> result = new ArrayList<>();
        Set<Integer> uniqueElement = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 0; i < arr.size()-1; i++) {
            int one = arr.get(i);
            int two = arr.get(i+1);
            if (one==two) {
                count +=1;
            } else {
                if(count == 1 ) {
                    result.add(String.valueOf(one));
                } else {
                    result.add(one + "-" + count);
                }
                count = 1;
            }

        }
        return null;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 5, 5, 7, 7, 1, 3, 2);

        packNumbers(numbers);
    }

}
