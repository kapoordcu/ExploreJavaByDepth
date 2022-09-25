package intervals;

import org.junit.Test;

import java.util.*;

public class MergeIntervals {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if(newInterval[1] < intervals[i][0]) {
                result.add(newInterval);
                return addOtherIntervals(result, intervals, i);
            } else if(newInterval[0] > intervals[i][1]) {
                result.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(
                        newInterval[0], intervals[i][0]
                );
                newInterval[1] = Math.max(
                        newInterval[1], intervals[i][1]
                );
            }
        }
        result.add(newInterval);
        return returnIntervalsResults(result);
    }

    private int[][] returnIntervalsResults(List<int[]> result) {
        int[][] newResult = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            newResult[i] = result.get(i);
        }
        return newResult;
    }

    private int[][] addOtherIntervals(List<int[]> result, int[][] intervals, int next) {
        int[][] newResult = new int[intervals.length+1][];
        for (int i = next; i < intervals.length; i++) {
            result.add(intervals[i]);
        }
        for (int i = 0; i < result.size(); i++) {
            newResult[i] = result.get(i);
        }
        return newResult;
    }


    @Test
    public void testMergeInsert() {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval ={2,5};
        int[][] actual = insert(intervals, newInterval);
        int[][] expected = {{1,5},{6,9}};
        actual.equals(expected);
    }

    @Test
    public void testMergeInsert02() {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval ={4,8};
        int[][] actual = insert(intervals, newInterval);
        int[][] expected = {{1,2},{3,10},{12,16}};
        actual.equals(expected);
    }

}
