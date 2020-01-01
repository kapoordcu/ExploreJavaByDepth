package explore.topics.hackerrank;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        solution(16, 211);
    }

    public static int solution(int A, int B) {
        List<Integer> perfectSquares = new ArrayList<Integer>();
        for (int perfectSquareNumber=A; perfectSquareNumber<=B; perfectSquareNumber++) {
            if(getSquareRoot(perfectSquareNumber)) {
                perfectSquares.add(perfectSquareNumber);
            }
        }
        System.out.println(perfectSquares);
        return 0;
    }

    private static boolean getSquareRoot(int number) {
        int sqrt = (int) Math.sqrt(number);
        if(sqrt*sqrt == number) {
            return true;
        }
        return false;
    }
}
