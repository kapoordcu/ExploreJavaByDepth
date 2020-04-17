package explore.topics.challenges.delivery;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

import static org.junit.Assert.assertTrue;

public class FishEatingApp {

    public static int solution(String S) {
        Map<Character, List<Character>> eatingMap = initDataFish();
        Stack<Character> fishStack = new Stack<Character>();
        while (true) {
            int length = S.length();
            S = startEating(S, fishStack, eatingMap);
            if(fishStack.size()==length) {
                return fishStack.size();
            }
            fishStack.clear();
        }
    }

    private static Map<Character, List<Character>> initDataFish() {
        return Map.of('A', Arrays.asList('B', 'C'),
                'B', Arrays.asList('D', 'C'),
                'C', Arrays.asList('D'));

    }

    private static String startEating(String s, Stack<Character> fishStack
            , Map<Character, List<Character>> eatingMap) {

        for (char c : s.toCharArray()) {
            if(!fishStack.isEmpty())  {
                if(fishStack.peek()!=null) {
                    Optional<Character> eaten = eatingMap.get(fishStack.peek()).stream()
                            .filter(ch -> ch.equals(c))
                            .findAny();
                    if(!eaten.isPresent()) {
                        fishStack.push(c);
                    }
                }
            } else {
                fishStack.push(c);
            }
        }
        StringBuilder returnString = new StringBuilder();
        fishStack.stream().forEach(character -> returnString.append(character));
        return returnString.toString();
    }

    @Test
    public void getSolution1() {
        int solution = FishEatingApp.solution("ABCD");
        assertTrue(solution==2);
    }

    @Test
    public void getSolution2() {
        int solution = FishEatingApp.solution("ACCD");
        assertTrue(solution==2);
    }

    @Test
    public void getSolution3() {
        int solution = FishEatingApp.solution("BDC");
        assertTrue(solution==1);
    }
}
