package explore.topics.jdk9.pa2;

public class RunnerJDK9 {
    public static void main(String[] args) {
        RunnerJDK9 jdk9 = new RunnerJDK9();
        System.out.println(jdk9.sumFibs(10000));
    }


    public long sumPalendromes(int number) {
        long result = 0;
        for (int num = 0; num < number; num++) {
            if(isPalindromicNumber(num)) {
                result += num;
            }
        }
        return result;
    }

    private boolean isPalindromicNumber(int num) {
        int valueOriginal = num;
        int remainder = 0;
        int reversedInteger = 0;
        while(num != 0 ) {
            remainder = num % 10;
            reversedInteger = reversedInteger * 10 + remainder;
            num  /= 10;
        }
        return valueOriginal==reversedInteger;
    }

    public long sumFibs(int number) {
        long result = 0;
        int prevNumber = 0;
        int currNumber = 1;
        while (currNumber < number) {
            if (currNumber % 2 != 0) {
                result += currNumber;
            }
            currNumber += prevNumber;
            prevNumber = currNumber - prevNumber;
        }
        return result;
    }
}
