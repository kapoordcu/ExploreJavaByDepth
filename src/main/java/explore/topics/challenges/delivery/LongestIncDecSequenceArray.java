package explore.topics.challenges.delivery;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LongestIncDecSequenceArray {

    public static int[] solution(int[] arr) {
        return new int[2];
    }

    @Test
    public void getSolution1() {
        int[] arr = {1, 3, 4, 5, 6, 5, 4, 7, 2, 7};
        int[] solution = LongestIncDecSequenceArray.solution(arr);
        assertTrue(solution.length==4);
    }

    @Test
    public void getSolution2() {
        int[] arr = {1, 6, 5, 4, 3, 2, 1, 2, 3, 4};
        int[] solution = LongestIncDecSequenceArray.solution(arr);
        assertTrue(solution.length==6);
    }
}
