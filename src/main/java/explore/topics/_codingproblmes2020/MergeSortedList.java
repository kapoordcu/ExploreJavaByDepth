package explore.topics._codingproblmes2020;

import explore.topics._ds.basicsort.SortUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedList {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(2, 4, 5, 9, 10);
        List<Integer> l2 = Arrays.asList(0, 1, 8);
        mergeSortedList(l1, l2);
    }

    private static void mergeSortedList(List<Integer> l1, List<Integer> l2) {
        List<Integer> combinedList = new ArrayList<>();
        int l1Size = l1.size();
        int l2Size = l2.size();
        int i = 0;
        int j = 0;
        for (int k = 0; k < l1Size+l2Size; k++) {
            if(i>l1Size) {
                combinedList.add(l2.get(j++));
            } else if(j>=l2Size) {
                combinedList.add(l1.get(i++));
            } else if(SortUtils.less(l1.get(i), l2.get(j))) {
                combinedList.add(l1.get(i++));
            } else {
                combinedList.add(l2.get(j++));
            }
        }
        System.out.println(combinedList);
    }


}
