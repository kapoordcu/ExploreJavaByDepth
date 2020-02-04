package explore.topics._arrays;

import java.util.*;

public class LargestNumberFormed {
    public static void main(String[] args) {
        Integer[] arr = {3, 30, 34, 5, 9};
        Integer[] arr2 = {54, 546, 548, 60};
        System.out.println(findMaxNumberFormed(arr));
        System.out.println(findMaxNumberFormed(arr2));
        System.out.println(findMaxNumberFormedMyVersion(arr));
        System.out.println(findMaxNumberFormedMyVersion(arr2));
    }

    private static String findMaxNumberFormed(Integer[] arr) {
        List<Integer> ints = Arrays.asList(arr);
        Collections.sort(ints, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = ints.size()-1; i >=0 ; i--) {
            sb.append(ints.get(i));
        }
        return sb.toString();
    }

    private static String findMaxNumberFormedMyVersion(Integer[] arr) {
        List<Integer> ints = Arrays.asList(arr);
        Collections.sort(ints, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer l1 = String.valueOf(o1).indexOf(0);
                Integer l2 = String.valueOf(o2).indexOf(0);
                return l1.compareTo(l2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = ints.size()-1; i >=0 ; i--) {
            sb.append(ints.get(i));
        }
        return sb.toString();
    }
}
