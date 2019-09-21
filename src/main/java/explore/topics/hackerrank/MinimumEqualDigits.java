package explore.topics.hackerrank;

public class MinimumEqualDigits {
    public static void main(String[] args) {
        MinimumEqualDigits minimumEqualDigits = new MinimumEqualDigits();
        System.out.println(minimumEqualDigits.solution(1));
        System.out.println(minimumEqualDigits.solution(234));
        System.out.println(minimumEqualDigits.solution(0));
        System.out.println(minimumEqualDigits.solution(345));
        System.out.println(minimumEqualDigits.solution(-1));
        System.out.println(minimumEqualDigits.solution(10));

    }

    public int solution(int N) {
        // write your code in Java SE 8
        int deductionCount = 0;
        int returnSameDigitInteger = 0;
        if(N <= 0) {
            return 0;
        }
        int firstDigit = getFirstDigitOfNumber(N);
        int remainingDigit = getRemainingDigitOfNumber(N);

        while(firstDigit!=1) {
            firstDigit--;
            deductionCount++;
        }

        if(remainingDigit!=-1) { // Means there is more than one digit  in number N
            returnSameDigitInteger =  N - Integer.parseInt(deductionCount + "" + remainingDigit);
        } else {
            returnSameDigitInteger = N - deductionCount; // Means there is ONLY one digit  in number N
        }
        return returnSameDigitInteger;
    }

    private int getRemainingDigitOfNumber(int number) {
        String numberString = Integer.toString(number);
        if(numberString.length() >=2) {
            return Integer.parseInt(numberString.substring(1));
        }
        return -1; // -1 denotes that its a single digit
    }

    private int getFirstDigitOfNumber(int number) {
        return Integer.parseInt(Integer.toString(number).substring(0, 1));
    }
}
