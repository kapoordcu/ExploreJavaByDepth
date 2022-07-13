package specials;

import lombok.var;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

public class RankImbalance {
    @Test
    public void testRankImbalance() {
        int[] array = {3, 9, 5, 6, 2};
        List<Integer> collect = IntStream.of(array).boxed().collect(Collectors.toList());
        long value = RankImbalance.findTotalImbalance(collect);
        assertTrue(value==12);
    }

    @Test
    public void testRankImbalance2() {
        int[] array = {3, 1, 2};
        List<Integer> collect = IntStream.of(array).boxed().collect(Collectors.toList());
        long value = RankImbalance.findTotalImbalance(collect);
        assertTrue(value==1);
    }

    public static long findTotalImbalance(List<Integer> integers) {
            var imbalance = 0;
            var len = integers.size();
            if (len == 1) {
                return 0;
            }

            for (var count = 2; count <= len; count++) {
                for (var i = 0; i <= len - count; i++) {
                    var arr = integers.subList(i, count + i);

                    Collections.sort(arr);
                    for (var j = 0; j < count - 1; j++) {
                        if (arr.get(j+1) - arr.get(j) > 1)
                            imbalance++;
                    }
                }
            }
            return imbalance;
        }
}
