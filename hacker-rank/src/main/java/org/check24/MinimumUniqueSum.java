package org.check24;

import java.util.ArrayList;
import java.util.List;

public class MinimumUniqueSum {
    public static int getMinimumUniqueSum(List<Integer> arr) {
        List<Integer> storeResults = new ArrayList<>();
        int sum = 0;
        storeResults.add(arr.get(0));

        for (int i = 1; i < arr.size(); i++) {
            int val = arr.get(i);
            while (storeResults.contains(val)) {
                val++;
            }
            storeResults.add(val);
        }
        for (int i = 0; i < storeResults.size(); i++) {
            sum += storeResults.get(i);
        }
        return sum;
    }
}
