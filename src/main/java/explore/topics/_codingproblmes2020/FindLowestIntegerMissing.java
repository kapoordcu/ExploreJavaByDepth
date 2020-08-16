package explore.topics._codingproblmes2020;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class FindLowestIntegerMissing {


    public int solution(int[] A) {
        // 1, 3, 6, 4, 1, 2
        // 1, 1, 2, 3, 4, 6
        List<Integer> collect = Arrays.stream(A).boxed().collect(Collectors.toList());
        int missingNumber = 1;
        Collections.sort(collect);
        Integer prevValue = collect.get(0);
        for (Integer value:         collect) {
            if(value!=prevValue && value!=prevValue+1) {
                return prevValue + 1;
            }
            prevValue = value;
        }
        return missingNumber;
    }

    @Test
    public void test1() {
        FindLowestIntegerMissing missing = new FindLowestIntegerMissing();
        int[] a = {1, 3, 6, 4, 1, 2};
        assertEquals(missing.solution(a), 5);
    }

    @Test
    public void test2() {
        FindLowestIntegerMissing missing = new FindLowestIntegerMissing();
        int[] a = {1, 2, 3};
        assertEquals(missing.solution(a), 4);
    }

    @Test
    public void test3() {
        FindLowestIntegerMissing missing = new FindLowestIntegerMissing();
        int[] a = {-1, -3};
        assertEquals(missing.solution(a), 1);
    }

}
