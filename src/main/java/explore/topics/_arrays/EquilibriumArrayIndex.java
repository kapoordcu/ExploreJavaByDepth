package explore.topics._arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EquilibriumArrayIndex {
    public static void main(String[] args) {
        int[] a = {3, -2, 5, -1, -1, -2, 0, 0 , 1, 3, -2};
        int[] arrayEq1 = {4, 1, 1, 2, 3};
        int[] arrayEq2 = {4, -1, 1, 2, 1};
        int[] arrayEq3 = {2, 1, 1, 3, 1};
        int[] arrayEq4 = {2, 1, 2, 3, 1};
        System.out.println(findEqIndex(a));
        System.out.println(findEqIndex(arrayEq1));
        System.out.println(findEqIndex(arrayEq2));
        System.out.println(findEqIndex(arrayEq3));
        System.out.println(findEqIndex(arrayEq4));
    }

    //O(n)
    private static int findEqIndex(int[] a) {
        if(a.length<3) {
            return -1;
        }
        int totalSum = IntStream.of(a).sum();
        int leftSum = 0;
        int righsum = 0;
        for (int i = 0; i < a.length; i++) {
            righsum = totalSum - leftSum - a[i];
            if(leftSum==righsum) {
                return i;
            }
            leftSum += a[i];
        }
        return -1;
    }

    //O(n^2)
    private static int findEquilibriumArrayIndex(int[] arrayEq) {
        List<Integer> integerList = Arrays.stream(arrayEq).boxed().collect(Collectors.toList());
        for (int i = 0; i < arrayEq.length - 1; i++) {
            int left = sumLeft(integerList, i+1);
            int right = sumRightPart(integerList, i+2);
            if(left==right) {
                return i+1;
            }
        }
        return -1;
    }

    private static int sumLeft(List<Integer> integerList, int endIndex) {
        return integerList.subList(0, endIndex)
                .stream().mapToInt(Integer::intValue).sum();
    }

    private static int sumRightPart(List<Integer> integerList, int startIndex) {
        return integerList.subList(startIndex, integerList.size())
                .stream().mapToInt(Integer::intValue).sum();
    }
}
