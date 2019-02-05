package explore.topics.tdd;

import java.util.Collections;
import java.util.List;

public class SumCalculator {
    public static int add(String stringOfNumbers) {

        String delimiter = ",|n";
        String numbersWithoutDelimiter = stringOfNumbers;

//        if(numbers.length > 2) {  // whenMoreThan2NumbersAreUsedThenExceptionIsThrown
//            throw new RuntimeException("Only two numbers can be added.");
//        }
        if(stringOfNumbers.startsWith("//")) {
            //  //;n3;6;15
            int delimiterIndex = stringOfNumbers.indexOf("//") + 2;
            delimiter = stringOfNumbers.substring(delimiterIndex, delimiterIndex +1);
            numbersWithoutDelimiter = stringOfNumbers.substring(delimiterIndex +2);
        }

//        List<Integer> numbersAdd = Arrays.asList(1,2,3,4,5);
//        int sumAll = numbersAdd.stream().mapToInt( i -> i).sum();
//        System.out.println(sumAll);
        return addNumberWithDelimiter(numbersWithoutDelimiter, delimiter);
    }

    private static int addNumberWithDelimiter(String numbersWithoutDelimiter, String delimiter) {
        List<Integer> negatives = Collections.emptyList();
        int sum = 0;
        String[] numbers = numbersWithoutDelimiter.split(delimiter);
        for (String number: numbers) {
            if(!number.trim().isEmpty()) {
                int currentNum = Integer.parseInt(number.trim());
                if(currentNum < 0) {
                    negatives.add(currentNum);
                } else if(currentNum < 1000) {
                    sum += currentNum;
                }
            }
        }
        if(!negatives.isEmpty()) {
            throw new RuntimeException("No negative numbers");
        }
        return sum;
    }
}
