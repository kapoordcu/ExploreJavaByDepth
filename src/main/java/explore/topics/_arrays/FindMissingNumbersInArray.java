package explore.topics._arrays;

import java.util.HashSet;
import java.util.Set;

public class FindMissingNumbersInArray {
    public static void main(String[] args) {
        int[] unsortedArray = {1, 4, 5, 9, 3, 10, 2, 8};
        findMissingNumbersWithoutSpaceMethod1(unsortedArray, 10);

    }

    private static void findMissingNumbersWithoutSpaceMethod1(int[] a1, int total) {
        Set<Integer> exsitingNumberSet = new HashSet<>();
        for (int i = 0; i < a1.length; i++) {
            exsitingNumberSet.add(a1[i]);
        }

        for (int i = 1; i <= total; i++) {
            if(!exsitingNumberSet.contains(i)) {
                System.out.println(i);
            }
        }
    }
}
