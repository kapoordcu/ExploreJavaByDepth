package intervals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        List<MeetingSlot> slots = new ArrayList<>();
        int removals = 0;
        for (int i = 0; i < intervals.length; i++) {
            slots.add(new MeetingSlot(intervals[i][0], intervals[i][1]));
        }
        slots = slots.stream().sorted(Comparator.comparing(MeetingSlot::getStart)).collect(Collectors.toList());
        for (int i = 1; i < slots.size(); i++) {
            if(slots.get(i).start < slots.get(i-1).end &&
                    slots.get(i).start > slots.get(i-1).start ) {
                slots.remove(i);
                removals++;
                i--;
            }
        }

        return removals;
    }

    @Test
    public void testNonOverlappingIntervals01() {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int actual = eraseOverlapIntervals(intervals);
        assertEquals(actual, 1);
    }

    @Test
    public void testNonOverlappingIntervals02() {
        int[][] intervals = {{1,2},{1, 2},{1, 2}};
        int actual = eraseOverlapIntervals(intervals);
        assertEquals(actual, 2);
    }
}
