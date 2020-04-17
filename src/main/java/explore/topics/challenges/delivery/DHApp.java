package explore.topics.challenges.delivery;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

public class DHApp {
    public static void main(String[] args) {
        DHApp app = new DHApp();
        int[] solution = app.solution(1, 2);
        System.out.println();
    }

    public int[] solution(int X, int Y) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i <= X; i++) {
            if (4 * i > Y) continue;
            int j = X - i;
            if (4 * i + 2 * j == Y) {

                res.add(j);
                res.add(i);
                return res.stream().mapToInt(k -> k).toArray();
            }
        }
        return res.stream().mapToInt(k -> k).toArray();
    }

    public int solution2(String S) {
        Map<Character, List<Character>> eatingMap = new HashMap<>();
        eatingMap.put('A', Arrays.asList('B', 'C'));
        eatingMap.put('B', Arrays.asList('D', 'C'));
        eatingMap.put('C', Arrays.asList('D'));

        Stack<Character> fishStack = new Stack<Character>();
        while (true) {
            int length = S.length();
            S = startEating(S, S.length(), fishStack, eatingMap);
            if(fishStack.size()==length) {
                return fishStack.size();
            }
            fishStack.clear();
        }
    }

    private String startEating(String s, int length, Stack<Character> fishStack
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
}
