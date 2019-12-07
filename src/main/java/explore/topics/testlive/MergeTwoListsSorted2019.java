package explore.topics.testlive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeTwoListsSorted2019 {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(2, 4, 5, 9, 10);
        List<Integer> l2 = Arrays.asList(0, 1, 8);
        mergeSortedList(l1, l2);
    }

    public static List<Integer> mergeSortedList(List<Integer> l1, List<Integer> l2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0,  j = 0;
        for (;i < l1.size() && j < l2.size();) {
            if(l1.get(i) > l2.get(j)) {
                mergedList.add(l2.get(j++));
            } else {
                mergedList.add(l1.get(i++));
            }
        }
        List<Integer> remainingList1 = l1.subList(i, l1.size());
        List<Integer> remainingList2 = l2.subList(j, l2.size());
        mergedList.addAll(remainingList1);
        mergedList.addAll(remainingList2);
        return mergedList;
    }

    public static List<Integer> joinListSorted(List<Integer> list1, List<Integer> list2) {
        List<Integer> resultList = new ArrayList<>();
        if(list1.size()==0 && list2.size()==0) {
            return Collections.emptyList();
        }

        int size1 = list1.size();
        int size2 = list2.size();

        while(list1.size()!=0 && list2.size()!=0) {
            Integer firstListElement = list1.get(0);
            Integer secondListElement = list2.get(0);

            if(firstListElement!=secondListElement) {
                boolean first = (firstListElement>secondListElement) ? true : false;
                if(first) {
                    resultList.add(secondListElement);
                    list2 = list2.subList(1, size2);
                    size2--;
                } else {
                    resultList.add(firstListElement);
                    list1 = list1.subList(1, size1);
                    size1--;
                }
            } else {
                resultList.add(secondListElement);
                list2 = list2.subList(1, size2);
                size2--;
            }
        }
        if(size1>0) {
            resultList.addAll(list1);
        } else if(size2>0){
            resultList.addAll(list2);
        }
        return resultList;
    }
}
