package explore.topics.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindOddNumbers {

    static List<Integer> oddNumbers(int l, int r) {
        if(l<r) {
            return Collections.emptyList();
        }
        List<Integer> oddNumberList = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if(i%2 != 0) {
                oddNumberList.add(i);
            }
        }
        return oddNumberList;
    }
}
