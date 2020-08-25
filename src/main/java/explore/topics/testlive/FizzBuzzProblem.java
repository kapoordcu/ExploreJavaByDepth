package explore.topics.testlive;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class FizzBuzzProblem {

    @Test
    public void test() {
        List<Integer> dictionary = List.of(3, 105, 15, 10, 12, 22, 19);
        int fizz = 3;
        int buzz = 5;
        List<String> anagrams = findFizzBuzz(dictionary, fizz, buzz);
        assertTrue(anagrams.size()==5);
    }

    private List<String> findFizzBuzz(List<Integer> dictionary, int fizz, int buzz) {
        List<String> fizBuzzList = new ArrayList<>();
        for (Integer number:         dictionary) {
            boolean isFizz = number%fizz==0;
            boolean isBuzz = number%buzz==0;
            if(isBuzz && isFizz) {
                fizBuzzList.add("fizzbuzz");
            } else if(isBuzz) {
                fizBuzzList.add("buzz");
            } else if(isFizz) {
                fizBuzzList.add("fizz");
            }
        }
        return fizBuzzList;
    }
}
