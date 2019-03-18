package explore.topics.hackerrank;

import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagramOfEachOther("Gaurav", "uraaGa"));
    }

    private static boolean isAnagramOfEachOther(String a, String b) {
        char aArray[] = a.toCharArray();
        Arrays.sort(aArray);
        char bArray[] = b.toCharArray();
        Arrays.sort(bArray);
        return Arrays.equals(aArray, bArray);
    }
}
