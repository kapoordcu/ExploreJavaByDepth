package explore.topics.testlive;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindMissingMinimumNumber {
    public static void main(String[] args) {
        FindMissingMinimumNumber c = new FindMissingMinimumNumber();
        int[] arr = {1,2,3};
        int solution = c.solution(arr);
    }

    public int solution(int[] A) {
       Set<Integer> number = new HashSet<>();

        List<Integer> collect = Arrays.stream(A)
                .boxed()
                .filter(n -> n > 0)
                .collect(Collectors.toList());

        HashSet<Integer> integers = new HashSet<>(collect);
        for (int i = 0; i < integers.size(); i++) {
            if(!integers.contains(i+1)) {
                return i+1;
            }
        }

        return number.size();
    }
}
