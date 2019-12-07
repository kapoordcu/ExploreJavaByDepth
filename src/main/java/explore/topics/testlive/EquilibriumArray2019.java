package explore.topics.testlive;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EquilibriumArray2019 {
    public static void main(String[] args) {
        int[] arrayEq1 = {4, 1, 1, 2, 3};
        int[] arrayEq2 = {4, -1, 1, 2, 1};
        int[] arrayEq3 = {2, 1, 1, 3, 1};
        int[] arrayEq4 = {2, 1, 2, 3, 1};
        System.out.println(findEquilibriumArrayIndex(arrayEq1));
        System.out.println(findEquilibriumArrayIndex(arrayEq2));
        System.out.println(findEquilibriumArrayIndex(arrayEq3));
       System.out.println(findEquilibriumArrayIndex(arrayEq4));
    }

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
