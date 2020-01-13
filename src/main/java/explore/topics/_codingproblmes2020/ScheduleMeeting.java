package explore.topics._codingproblmes2020;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScheduleMeeting {
    public static void main(String[] args) {
        int meetingDuration = 30;

        String[][] slot1 = {
                {"9.00", "10.30"},
                {"12.00", "13.00"},
                {"16.00", "18.00"}
                            };
        String[][] slot2 = {
                {"10.00", "11.30"},
                {"12.30", "14.30"},
                {"14.30", "15.00"},
                {"16.00", "17.00"}
        };

        String[] bound1 = {"9.00", "20.00"};
        String[] bound2 = {"10.00", "18.30"};

        MeetingSlot firstBound = new MeetingSlot(bound1[0], bound1[1]);
        MeetingSlot secondBound = new MeetingSlot(bound2[0], bound2[1]);

        List<MeetingSlot> firstCalendar = processUnavailibility(slot1, firstBound, secondBound);
        List<MeetingSlot> secondCalendar = processUnavailibility(slot2, firstBound, secondBound);

        List<MeetingSlot> mergedCalendar = new ArrayList<>(firstCalendar);
        mergedCalendar.addAll(secondCalendar);
        firstCalendar.clear();
        secondCalendar.clear();

        Collections.sort(mergedCalendar, Comparator.comparing(MeetingSlot::getStart)
                .thenComparing(MeetingSlot::getEnd));
        for (int i = 0; i < mergedCalendar.size()-1; i++) {
            Double c1Start = mergedCalendar.get(i).getStart();
            Double c1End = mergedCalendar.get(i).getEnd();
            Double c2Start = mergedCalendar.get(i + 1).getStart();
            Double c2End = mergedCalendar.get(i + 1).getEnd();

            if(c1Start==c2Start) {
                firstCalendar.add(new MeetingSlot(c1Start + "0", Math.max(c1End, c2End) + "0"));
            }
            if(c1End.compareTo(c2Start)==-1 && c1End.compareTo(c2End)==-1) {
                firstCalendar.add(new MeetingSlot(c1Start + "0", c1End + "0"));
            } else if(c1End.compareTo(c2Start)==1 && c1End.compareTo(c2End)==1) {
                i++;
            }
        }
        processBounds(firstCalendar, firstBound, secondBound);
    }

    private static void processBounds(List<MeetingSlot> firstCalendar, MeetingSlot firstBound, MeetingSlot secondBound) {

    }

    private static List<MeetingSlot> processUnavailibility(String[][] slot, MeetingSlot firstBound, MeetingSlot secondBound) {
        List<MeetingSlot> unAvailibilityList = new ArrayList<>();
        MeetingSlot currentSlot;

//        double max = Math.max(Double.parseDouble(firstBound.getStart()), Double.parseDouble(firstBound.getStart()));
//        double min = Math.min(Double.parseDouble(firstBound.getEnd()), Double.parseDouble(firstBound.getEnd()));

        for (int i = 0; i < slot.length; i++) {
            currentSlot = new MeetingSlot(slot[i][0], slot[i][1]);
//            if(Double.valueOf(currentSlot.getStart()).compareTo(max)==-1) {
//                currentSlot.setStart(String.valueOf(max));
//            }
//            if(Double.valueOf(currentSlot.getEnd()).compareTo(min)==1) {
//                currentSlot.setEnd(String.valueOf(min));
//            }
            unAvailibilityList.add(currentSlot);
        }
        return unAvailibilityList;
    }

    //    private static int inBetween(String time1, String[] range) {
//        Double mid = Double.valueOf(time1);
//        Double low = Double.valueOf(range[0]);
//        Double high = Double.valueOf(range[1]);
//        if(mid<low) {
//            return 1;
//        } else if(mid>high){
//            return -1;
//        }
//        return 0;
//    }
//
//    private static int compareTimes(String time1, String time2) {
//        String[] timeSplit1 = time1.split("\\.");
//        String[] timeSplit2 = time2.split("\\.");
//        Integer minutes1 = Integer.valueOf(timeSplit1[0])*60 +  Integer.valueOf(timeSplit1[1]);
//        Integer minutes2 = Integer.valueOf(timeSplit2[0])*60 +  Integer.valueOf(timeSplit2[1]);
//        return minutes1.compareTo(minutes2);
//    }
//
    private static void findUnavailableSlots(String[][] slot1, String[][] slot2,
                                             String start, String end,
                                             int meetingDuration, int[] slots) {
        for(String[] slotTuple : slot1) {
            List<Integer> indices = findValidBookedTime(slotTuple, start, end, meetingDuration);
            for (Integer in: indices) {
                slots[in-1]++;
            }
        }

        for(String[] slotTuple : slot2) {
            List<Integer> indices = findValidBookedTime(slotTuple, start, end, meetingDuration);
            for (Integer in: indices) {
                slots[in-1]++;
            }
        }

        //mapBackToAvailableSlots(slots, lateStart, earlierEnd, meetingDuration);
    }
//
//    private static void mapBackToAvailableSlots(int[] slots, String lateStart, String earlierEnd, int meetingDuration) {
//
//        for (int i = 0; i < slots.length; i++) {
//            if(slots[i]==0) {
//
//
//                // 2, 9, 10, 15, 16
//                // 90, 300, 330, 480, 510
//                // 10 , 10+5, 10 + 5.5, 10+8,   10+8.5
//            }
//        }
//    }
//
    private static List<Integer> findValidBookedTime(String[] slotTuple, String lateStart, String earlierEnd, int meetingDuration) {
        List<Integer> increment = new ArrayList<>();
        int early = findArrayIndex(lateStart, meetingDuration);
        int late = findArrayIndex(earlierEnd, meetingDuration);

        int low = findArrayIndex(slotTuple[0], meetingDuration);
        int high = findArrayIndex(slotTuple[1], meetingDuration);

        for (int i = low; i <= high; i++) {
            if(i>early && i<late) {
                increment.add(i-early);
            }
        }
        return increment;
    }

    private static int findArrayIndex(String time, int meetingDuration) {
        String[] timeSplit = time.split("\\.");
        return (Integer.parseInt(timeSplit[0])*60 + Integer.parseInt(timeSplit[1]))/meetingDuration;
    }

    private static String findTimeFromIndex(int index, String start, int meetingDuration) {
        String[] base = start.split("\\.");
        int offset = (index + 1) * (60 / meetingDuration);
        return null;
    }
//

//
    private static int findNumberOfSlots(String start, String end, int meetingDuration) {
        String[] timeSplit1 = start.split("\\.");
        String[] timeSplit2 = end.split("\\.");
        int totalSlots = 0;
        int m1 = Integer.parseInt(timeSplit1[0])*60 +  Integer.parseInt(timeSplit1[1]);
        int m2 = Integer.parseInt(timeSplit2[0])*60 +  Integer.parseInt(timeSplit2[1]);
        for (int i = m1; i < m2 ; i+= meetingDuration) {
            totalSlots++;
        }
        return totalSlots;
    }
//
//    private static List<String> findMeetingSlots(String[][] slot1, String[][] slot2, String[] bound1, String[] bound2) {
//        List<String> timeRange = findTimeRangeAvailibility(bound1, bound2);
//        return null;
//    }
//
//    private static List<String> findTimeRangeAvailibility(String[] bound1, String[] bound2) {
//        List<String> availableTimings = new ArrayList<>();
//        availableTimings.add(0, later(bound1[0], bound2[0]));
//        //availableTimings.add(1, earlier(bound1[1], bound2[1]));
//        return availableTimings;
//    }
//
    private static String later(String t1, String t2) {
        String[] timeSplit1 = t1.split("\\.");
        String[] timeSplit2 = t2.split("\\.");
        Integer a1 = Integer.parseInt(timeSplit1[0]);
        Integer a2 = Integer.parseInt(timeSplit2[0]);

        if(a1>a2) {
            return t1;
        } else if(a1<a2) {
            return t2;
        } else {
            Integer b1 = Integer.parseInt(timeSplit1[1]);
            Integer b2 = Integer.parseInt(timeSplit2[1]);
            if(b1>b2) {
                return timeSplit1[0] + "." + b1;
            } else if(b1<b2) {
                return timeSplit1[0] + "." + b2;
            } else {
                return t1;
            }
        }
    }

    private static String earlier(String t1, String t2) {
        List<String> bounds = new ArrayList<>();
        bounds.add(t1);
        bounds.add(t2);
        bounds.remove(later(t1, t2));
        return bounds.get(0);
    }

}

class MeetingSlot {
    private Double start;
    private Double end;

    public MeetingSlot(String start, String end) {
        this.start = Double.parseDouble(start);
        this.end = Double.parseDouble(end);
    }

    public Double getStart() {
        return start;
    }

    public void setStart(Double start) {
        this.start = start;
    }

    public Double getEnd() {
        return end;
    }

    public void setEnd(Double end) {
        this.end = end;
    }
}
