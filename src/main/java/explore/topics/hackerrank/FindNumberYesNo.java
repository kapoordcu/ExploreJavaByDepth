package explore.topics.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindNumberYesNo {

    static String findNumber(List<Integer> arr, int k) {
        Optional<Integer> present = arr.stream()
                .filter(number -> number == k)
                .findFirst();
        return present.isPresent() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(10);
        numberList.add(4);
        numberList.add(6);
        numberList.add(1);
        numberList.add(3);

        System.out.println(findNumber(numberList, 3));

    }
}
