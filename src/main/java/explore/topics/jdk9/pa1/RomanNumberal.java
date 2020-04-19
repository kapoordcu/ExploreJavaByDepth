package explore.topics.jdk9.pa1;

import java.util.TreeMap;

public class RomanNumberal {
    private final static TreeMap<Integer, String> romanMap = new TreeMap<>();

    static {
        romanMap.put(1, "I");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(9, "IX");
        romanMap.put(10, "X");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");
        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(900, "CM");
        romanMap.put(1000, "M");
    }

    public final static String toRoman(int number) {
        int key =  romanMap.floorKey(number);
        if (number == key) {
            return romanMap.get(number);
        }
        return romanMap.get(key) + toRoman(number-key);
    }

    public long findXXX(int capacity) {
        long xCount = 0;
        for (int i = 1; i <= capacity; i++) {
            xCount += countXXX(toRoman(i));
        }
        return xCount;
    }

    private long countXXX(String toRoman) {
        int countX = 0;
        for (Character c:  toRoman.toCharArray()) {
            if(c=='X') {
                countX++;
            }
        }
        return countX;
    }

    public static void main(String[] args) {
        RomanNumberal romanNumberal = new RomanNumberal();
        System.out.println(romanNumberal.findXXX(2660));
    }
}
