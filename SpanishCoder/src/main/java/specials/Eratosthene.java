package specials;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Eratosthene {

    @Test
    public void testOne() {
        List<Integer> find = Eratosthene.sieveOfEratosthenes(50);
        assertTrue(find.equals(List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47)));
    }

    @Test
    public void testSmallNumber() {
        List<Integer> find = Eratosthene.sieveOfEratosthenes(10);
        assertTrue(find.equals(List.of(2, 3, 5, 7)));
    }

    @Test
    public void testVerySmallNumber() {
        List<Integer> find = Eratosthene.sieveOfEratosthenes(3);
        assertTrue(find.equals(List.of(2, 3)));
    }

    public static List<Integer> sieveOfEratosthenes(int number) {
        List<Integer> primeNumbers = new ArrayList<>();
        boolean[] strikes = new boolean[number+1];
        strikes[0] = true;
        strikes[1] = true;
        for (int i = 2; i * i <= number ; i++) {
            if(strikes[i] == false) {
                for (int j = i * i; j <= number ; j+=i) {
                    strikes[j] = true;
                }
            }
        }
        for (int i = 1; i <= number; i++) {
            if(strikes[i]==false) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}
