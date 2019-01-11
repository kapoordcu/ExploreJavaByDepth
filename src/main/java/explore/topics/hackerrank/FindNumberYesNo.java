package explore.topics.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class FindNumberYesNo {
    static String findNumber(List<Integer> arr, int k) {
        boolean present = false;
        for (Integer num:arr) {
            if(num == k) {
                present = present || true;
            }
        }
        if(present) { return "YES"; }
        return "NO";
    }

    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(10);
        numberList.add(4);
        numberList.add(6);
        numberList.add(1);
        numberList.add(3);

    }
}
