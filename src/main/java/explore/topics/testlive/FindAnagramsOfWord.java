package explore.topics.testlive;

import org.junit.Test;

import java.util.*;

import static java.util.Map.Entry.comparingByKey;
import static org.junit.Assert.assertTrue;

public class FindAnagramsOfWord {
    public List<String> findAnagrams(List<String> dictionary, String word) {
        List<String> codedDictionary = new ArrayList<>();
        Integer intl;
        String wordCode = getStringCode(word);
        for (String w:  dictionary) {
            if(word.length()==w.length()) {
                String dictWordCode = getStringCode(w);
                if(dictWordCode.equals(wordCode)) {
                    codedDictionary.add(w);
                }
            }
        }
        return codedDictionary;
    }

    private String getStringCode(String word) {
        StringBuilder code = new StringBuilder();
        char[] chars = word.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        for (Character ch: chars) {
            if(charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }
        charMap.entrySet()
                .stream()
                .sorted(comparingByKey())
                .forEach(entry -> code.append(entry.getKey() + "" + entry.getValue()));
        return code.toString();
    }


    @Test
    public void test() {
        List<String> dictionary = List.of("one", "two", "three", "eeth", "eerht", "treer", "threi");
        String word = "three";
        List<String> anagrams = findAnagrams(dictionary, word);
        assertTrue(anagrams.contains("three"));
        assertTrue(anagrams.contains("eerht"));
        assertTrue(anagrams.size()==2);
    }
}
