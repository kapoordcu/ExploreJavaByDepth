package explore.topics.hackerrank;

import java.util.*;

public class ParserDig {
    public static void main(String[] args) {
        ParserDig pg = new ParserDig();
        System.out.println(pg.countPalindrome("aaa"));
        System.out.println(pg.countPalindrome("abccba"));
        System.out.println(pg.countPalindrome("daata"));
        //System.out.println(pg.countPalindrome("tacocat"));
//        System.out.println(pg.carParkingRoof(Arrays.asList(6L, 2L, 12L, 7L), 3));
//        List<Integer> articles = Arrays.asList(2,2,3,4);
//        List<Integer> iv = Arrays.asList(2,4,4,5);
//
//        pg.maximumLearning(iv, articles, 15);

    }

    public int countPalindrome(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                StringBuilder tempReverse = new StringBuilder(substring).reverse();
                if(tempReverse.toString().compareTo(substring) == 0) {
                    count++;
                    tempReverse.setLength(0);
                }
            }
        }
        return count;
    }

    public static long carParkingRoof(List<Long> cars, int k) {
        Collections.sort(cars);
        List<Long> lengths = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            lengths.add(findNextRoofLength(cars, i, k) + 1);
        }
        Collections.sort(lengths);
        // Write your code here
        return lengths.get(0);
    }

    private static long findNextRoofLength(List<Long> cars, int carPosition, int k) {

        long maxLength = cars.get(cars.size()-1) - cars.get(0);
        long left = cars.get(carPosition);
        long right = 0;
        if(carPosition + k <= cars.size()) {
            right = cars.get(carPosition + k - 1);
            if(right-left<maxLength) {
                maxLength = right - left;
            }
        }
        return maxLength;
    }

    public static int maximumLearning(List<Integer> iv, List<Integer> articles, int p) {
        // Write your code here
        if(p%2!=0) {
            p = p -1;
        }
        int sum = p / 2;
        // 2  2  3  4  --> 7
        int[] findCOmbinations = combis(articles, sum);
        return 0;
    }

    private static int[] combis(List<Integer> articles, int sum) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();


        return null;
    }
}
