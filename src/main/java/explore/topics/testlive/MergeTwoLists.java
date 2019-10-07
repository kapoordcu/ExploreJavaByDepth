package explore.topics.testlive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoLists {
    public static void main(String[] args) {
        String s = "strawberries";
        System.out.println(s.substring(2,5) );
        byte b = 42;
        byte b1 = 24;
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
