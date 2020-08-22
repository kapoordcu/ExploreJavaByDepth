package org.dp.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakerProblem {

    @Test
    public void wordBreaker() {
        List<String> dict = Arrays.asList("this", "th", "is", "famous", "Word",
                "break", "b", "r", "e", "a", "k", "br",
                "bre", "brea", "ak", "problem");
        String str = "Wordbreakproblem";
        String out = "";
        wordBreak(dict, str, out);
        System.out.println(out);
    }

    private void wordBreak(List<String> dict, String str, String out) {
       if (str.length() == 0) {
            System.out.println(out);
            return;
        }

        for (int i = 1; i <= str.length(); i++) {
            // consider all prefixes of current String
            String prefix = str.substring(0, i);

            // if the prefix is present in the dictionary, add prefix to the
            // output String and recur for remaining String

            if (dict.contains(prefix)) {
                wordBreak(dict, str.substring(i), out + " " + prefix);
            }
        }
    }
}
