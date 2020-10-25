import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
    You are given n activities with their start and finish times.
    Select the maximum number of activities that can be performed by a single person,
    assuming that a person can only work on a single activity at a time.
 */
public class ActivitySelection {
    public int[] activitySetMax(int[] start, int[] finish) {
        List<Activity> activities = new ArrayList<>();
        List<Integer> workList = new ArrayList<>();

        for (int i = 0; i < start.length; i++) {
            activities.add(new Activity(start[i], finish[i]));
        }
        activities.sort(Comparator.comparing(Activity::getEnd));
        if(activities.size()>0) {
            Activity first = activities.get(0);
            int ending = first.getEnd();
            workList.add(0);
            for (int i = 1; i < activities.size(); i++) {
                if(activities.get(i).getStart() >= ending) {
                    workList.add(i);
                    ending = activities.get(i).getEnd();
                }
            }
        }
        return workList.stream().mapToInt(i-> i).toArray();
    }

    /**
     * Example 2 : Consider the following 6 activities
     * sorted by by finish time.
     int[] start  =  { 0, 8, 5, 5,  1, 3};
     int[] finish =  { 6, 9, 7, 9, 2, 4 };
     * A person can perform at most four activities. The
     * maximum set of activities that can be executed
     * is {0, 1, 3, 4} [ These are indexes in start[] and
     * finish[] ]
     */
    @Test
    public void testActivity6() {
        ActivitySelection selection = new ActivitySelection();
        int[] start  =  { 0, 8, 5, 5,  1, 3};
        int[] finish =  { 6, 9, 7, 9, 2, 4 };
        int[] set = selection.activitySetMax(start, finish);
        assertTrue(set.length==4);
        assertTrue(set[0]==0);
        assertTrue(set[1]==1);
        assertTrue(set[2]==3);
        assertTrue(set[3]==4);
    }

    @Test
    public void testActivityMeetingRoom() {
        ActivitySelection selection = new ActivitySelection();
        int[] start  =  { 75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924};
        int[] finish =  { 112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252};


        int[] set = selection.activitySetMax(start, finish);
        assertTrue(set.length==4);
        assertTrue(set[0]==0);
        assertTrue(set[1]==1);
        assertTrue(set[2]==3);
        assertTrue(set[3]==4);
    }

    @Test
    public void testActivity3() {
        int[] start  =  {10, 12, 20};
        int[] finish =  {20, 25, 30};
        int[] set = activitySetMax(start, finish);
        assertTrue(set.length==2);
        assertTrue(set[0]==0);
        assertTrue(set[1]==2);
    }
}

class Activity {
    Integer start;
    Integer end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }
}