package intervals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MeetingRoom1 {

    @Test
    public void test01() {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        assertFalse(canAttendAll(intervals));
    }

    @Test
    public void test011() {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        assertTrue(numberOfMeetingRooms(intervals)==2);
    }

    @Test
    public void test02() {
        int[][] intervals = {{7, 10},{2, 4}};
        assertTrue(canAttendAll(intervals));
    }

    @Test
    public void test022() {
        int[][] intervals = {{7, 10},{2, 4}};
        assertTrue(numberOfMeetingRooms(intervals)==1);
    }

    private int numberOfMeetingRooms(int[][] intervals) {
        List<MeetingSlot> slots = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            slots.add(new MeetingSlot(intervals[i][0], intervals[i][1]));
        }
        slots = slots.stream().sorted(Comparator.comparing(MeetingSlot::getStart)).collect(Collectors.toList());
        int clash = 0;
        for (int i = 1; i < slots.size(); i++) {
            if(slots.get(i-1).end > slots.get(i).start) {
                clash++;
            }
        }
        return clash + 1;
    }

    private boolean canAttendAll(int[][] intervals) {
        List<MeetingSlot> slots = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            slots.add(new MeetingSlot(intervals[i][0], intervals[i][1]));
        }
        slots = slots.stream().sorted(Comparator.comparing(MeetingSlot::getStart)).collect(Collectors.toList());
        for (int i = 1; i < slots.size(); i++) {
            if(slots.get(i-1).end > slots.get(i).start) {
                return false;
            }
        }
        return true;
    }



}

class MeetingSlot {
    int start;
    int end;

    public MeetingSlot(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}