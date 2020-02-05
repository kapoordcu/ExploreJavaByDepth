package explore.topics._stacks_queues;

import java.util.HashSet;
import java.util.Set;

public class NonRepeatingChar {
    public static void main(String[] args) {
        String[] ch = {"a", "a", "b", "c", "b", "a", "e"};

        findNonRepeating(ch);
        for (int i = 0; i < ch.length; i++) {
            System.out.println(ch[i]);
        }
    }

    private static void findNonRepeating(String[] ch) {
        Set<String> charUnique = new HashSet<>();
        for (int i = 0; i < ch.length; i++) {
            if(charUnique.contains(ch[i])) {
                ch[i] = "-1";
                break;
            } else {
                charUnique.add(ch[i]);
            }
        }
    }
}
