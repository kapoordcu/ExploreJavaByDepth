package intervals;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class MergeInternvals {
    public int[][] merge(int[][] intervals) {
        List<Interval> invervalSorted = sortIntervalsByFirstTime(intervals);
        Stack<Interval> intervalStack = new Stack<>();
        for (Interval interval:         invervalSorted) {
            if(intervalStack.isEmpty()) {
                intervalStack.push(interval);
            } else {
                Interval topOfStack = intervalStack.peek();
                if(interval.start > topOfStack.end) {
                    intervalStack.push(interval);
                } else {
                    Interval merged = intervalStack.pop();
                    Interval newItem = new Interval(Math.min(merged.start, interval.start), Math.max(merged.end, interval.end));
                    intervalStack.push(newItem);
                }
            }
        }
        return convertToIntervals(intervalStack);

    }

    private int[][] convertToIntervals(Stack<Interval> intervalStack) {
        int[][] nonmappingIntervals = new int[intervalStack.size()][2];
        int i = 0;
        for (Interval in:         intervalStack) {
            nonmappingIntervals[i][0] = in.start;
            nonmappingIntervals[i++][1] = in.end;
        }
        return nonmappingIntervals;
    }


    public int[][] merge2(int[][] intervals) {
        List<Interval> invervalSorted = sortIntervalsByFirstTime(intervals);
        if(invervalSorted.size()==1) {
            return listArrayTo2D(invervalSorted);
        }
        List<Interval> result = new ArrayList<>();
        Interval merged = new Interval(0, 0);
        for (int i = 1; i < invervalSorted.size(); i++) {
           Interval prev = invervalSorted.get(i-1);
           Interval next = invervalSorted.get(i);
           if(prev.end < next.start) {
               result.add(prev);
               merged = next;
           } else {
               merged.start = Math.min(prev.start, next.start);
               merged.end = Math.max(prev.end, next.end);
               invervalSorted.set(i, merged);
           }
        }
        result.add(merged);
        return listArrayTo2D(result);
    }

    private List<Interval> sortIntervalsByFirstTime(int[][] intervals) {
        Set<Interval> pairs = new HashSet<>();
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[i].length; j++) {
                pairs.add(new Interval(intervals[i][0], intervals[i][1]));
            }
        }
        return pairs.stream().sorted(Comparator.comparing(Interval::getStart)).collect(Collectors.toList());
    }

    private int[][] listArrayTo2D(List<Interval> list) {
        int[][] list2D = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            list2D[i][0] = list.get(i).start;
            list2D[i][1] = list.get(i).end;
        }
        return list2D;
    }

    @Test
    public void test01() {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][]  actual = merge(intervals);
        int[][] results =  {{1,6},{8,10},{15,18}};
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                assertTrue(actual[i][j]==results[i][j]);
            }
        }
    }

    @Test
    public void test02() {
        int[][] intervals = {{1,4},{4,5}};
        int[][]  actual = merge(intervals);
        int[][] results =  {{1,5}};
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                assertTrue(actual[i][j]==results[i][j]);
            }
        }
    }

    @Test
    public void test03() {
        int[][] intervals = {{1, 4},{1,4}};
        int[][]  actual = merge(intervals);
        int[][] results =  {{1,4}};
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                assertTrue(actual[i][j]==results[i][j]);
            }
        }
    }

}

class Interval {
    int start,end;

    Interval(int start, int end)
    {
        this.start=start;
        this.end=end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return start == interval.start && end == interval.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}