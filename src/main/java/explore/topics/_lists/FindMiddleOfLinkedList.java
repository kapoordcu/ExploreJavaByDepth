package explore.topics._lists;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class FindMiddleOfLinkedList {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(12);
        list.add(3);
        list.add(7);
        list.add(2);
        list.add(8);
        list.add(9);
        list.add(16);
        list.add(4);

        findMiddle(list);
    }

    private static void swap(List<Integer> list, Integer start, Integer end) {
        Integer startEle = list.get(start);
        Integer endtEle = list.get(end);
        list.remove(start);
        list.add(start, endtEle);
        list.remove(end);
        list.add(end, startEle);
    }

    private static void findMiddle(List<Integer> list) {
        int size = list.size();
        int count = 0;
        boolean even = false;
        for (ListIterator<Integer> it = list.listIterator(); it.hasNext(); ) {
            Integer a = it.next();
            count++;
            if(size%2==0) {
                even = true;
            }
            if(count==size/2) {
                System.out.println(a);
                if(even && it.hasNext()) {
                    System.out.println(it.next());
                }
            }

        }

    }
}
