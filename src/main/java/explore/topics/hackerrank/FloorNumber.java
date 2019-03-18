package explore.topics.hackerrank;


import java.util.HashMap;
import java.util.Map;

public class FloorNumber {

    static int getLuckyFloorNumber(int number) {
        Map<Integer, Integer> uniqueFloorSet = new HashMap<>();
        int floorLabel = 0;
        for (int i = 1; i <= number; i++) {
            floorLabel = findNextPossibleLucky(i);
            if(uniqueFloorSet.containsValue(floorLabel)) {
                floorLabel = findNextPossibleLucky(floorLabel+1);
            }
            uniqueFloorSet.put(i, floorLabel);
        }
        return floorLabel;

    }

    private static int findNextPossibleLucky(int currFloor) {
        while(unluckyFloor(currFloor)) {
            return findNextPossibleLucky(currFloor+1);
        }
        return currFloor;
    }

    private static boolean unluckyFloor(int number) {
        String convertToString = String.valueOf(number);
        if(convertToString.contains("4") || convertToString.contains("13")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //        1   2   3   4   5   6   7   8   9   10  11  12
        //        1   2   3   5   6   7   8   9   10  11  12  15
        System.out.println(getLuckyFloorNumber(12));

    }
}
