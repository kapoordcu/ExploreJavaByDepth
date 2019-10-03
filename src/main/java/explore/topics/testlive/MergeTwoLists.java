package explore.topics.testlive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoLists {
    public static void main(String[] args) {
        List<Integer> first = List.of(1, 4, 5);
        List<Integer> sec = List.of(4);
        System.out.println(joinListSorted(first, sec));
    }

    public static List<Integer> joinListSorted(List<Integer> list1, List<Integer> list2) {
        List<Integer> resultList = new ArrayList<>();
        if(list1.size()==0 && list2.size()==0) {
            return Collections.emptyList();
        }

        int size1 = list1.size();
        int size2 = list2.size();
        int bigSize = Math.max(size1, size2);
        for(int i=0, j=0; i<bigSize; ) {
            if(list1.size()==0 || list2.size()==0) {
                break;
            }
            Integer firstListElement = list1.get(0);
            Integer secondListElement = list2.get(0);

            // if they are not equal
            if(firstListElement!=secondListElement) {
                boolean first = (firstListElement>secondListElement) ? true : false;
                if(first) {
                    resultList.add(secondListElement);
                    list2 = list2.subList(1, size2);
                    j++;
                    size2--;
                } else {
                    resultList.add(firstListElement);
                    list1 = list1.subList(1, size1);
                    i++;
                    size1--;
                }
            } else {
                resultList.add(secondListElement);
                list2 = list2.subList(1, size2);
                j++;
                size2--;
            }
        }
        // 1 4 5
        // 4

        // 1, 4
        if(size1>0) {
            resultList.addAll(list1);
        } else if(size2>0){
            resultList.addAll(list2);
        }
        return resultList;
    }

// 1, 3, 5
// 4


}
