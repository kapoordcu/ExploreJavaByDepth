package explore.topics.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PrimeNumberSum {



    // Complete the SumPrimes function below.
    static int SumPrimes() {
        Scanner scanner = new Scanner(System.in);
        int lowerLimit = 2;
        int higherLimit = 50000;
        if(scanner.hasNextLine()) {
            lowerLimit = Integer.valueOf(scanner.nextLine());
        }
        if(scanner.hasNextLine()) {
            higherLimit = Integer.valueOf(scanner.nextLine());
        }
        int sum = 0;
        for (int number = lowerLimit; number < higherLimit ; number++) {
            if(checkIfPrime(number)) {
                sum += number;
            }
        }
        return sum;
    }

    static boolean checkIfPrime(Integer value) {
        boolean isPrime = false;
        for (int i = 2; i <= value / 2; ++i) {
            if (value % i == 0) {
                isPrime = true;
                break;
            }
        }
        return isPrime;
    }

    public static void main(String[] args) throws IOException  {

        String OUTPUT_PATH = "C:\\Users\\gaura\\gaurav.text";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("C:\\Users\\gaura\\gaurav.text")));
        int res = SumPrimes();

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}