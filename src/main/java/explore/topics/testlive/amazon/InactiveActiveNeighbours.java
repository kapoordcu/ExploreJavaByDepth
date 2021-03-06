package explore.topics.testlive.amazon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InactiveActiveNeighbours {
    public static void main(String[] args) {
        int[] states = {1, 0, 0, 1, 1, 0, 0, 1};
        //List<Integer> resultFirstAttempt = cellCompeteFirstAttempt(states, 3);
        List<Integer> resultFirstEfficient = cellCompeteEffiecient(states, 3);
        //System.out.println(resultFirstAttempt);
        System.out.println(resultFirstEfficient);

    }

    private static List<Integer> cellCompeteEffiecient(int[] states, int days) {
        for (int i = 1; i <=  days; i++) {
            states = getNextDayStates(states);
        }
        return Arrays.stream(states).boxed().collect(Collectors.toList());
    }

    private static int[] getNextDayStates(int[] states) {
        if(states.length>1) {
            int[] temp = states.clone();
            temp[0] = 0^states[1];
            temp[states.length-1] = 0^states[states.length-2];
            for (int i = 1; i < states.length-1; i++) {
                temp[i] = states[i-1]^states[i+1];
            }
            states = temp.clone();
        }
        return states;
    }

    public static int XOR(int x, int y) {
        return x==y ? 0 : 1;
    }

    public static List<Integer> cellCompeteFirstAttempt(int[] states, int days) {
        int[] arrayNextDay = new int[states.length+2];
        for (int i = 1; i <= days; i++) {
            arrayNextDay = calculateNthDayStatus(arrayNextDay, states);
            mapTemporaryArrayBack(arrayNextDay, states);
        }
        List<Integer> collectReturnArray = Arrays.stream(arrayNextDay).boxed().collect(Collectors.toList());
        return collectReturnArray.subList(1, collectReturnArray.size()-1);
    }

    private static int[] calculateNthDayStatus(int[] arrayNextDay, int[] states) {
        mapDataArrayToTemporaryArray(arrayNextDay, states);
        int[] tempArray = arrayNextDay.clone();
        for (int i = 0; i < states.length ; i++) {
            arrayNextDay[i+1] = XOR(tempArray[i], tempArray[i+2]);
        }
        return arrayNextDay;
    }

    private static void mapDataArrayToTemporaryArray(int[] arrayNextDay, int[] states) {
        arrayNextDay[0] = 0;
        arrayNextDay[arrayNextDay.length-1] = 0;
        for (int i = 1; i < arrayNextDay.length-1; i++) {
            arrayNextDay[i] = states[i-1];
        }
    }

    private static void mapTemporaryArrayBack(int[] arrayNextDay, int[] states) {
        for (int j = 0; j < states.length; j++) {
            states[j] = arrayNextDay[j+1];
        }
    }
}
