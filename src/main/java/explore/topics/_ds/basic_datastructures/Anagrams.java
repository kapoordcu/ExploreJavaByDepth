package explore.topics._ds.basic_datastructures;

import java.util.*;

public class Anagrams {
    private Map<String, Set<String>> map;

    public Anagrams() {
        this.map =new TreeMap<>();
        new HashMap<>();
    }

    public void addWords(String[] words) {
        for (String word : words) {
            addWord(word);
        }
    }

    private void addWord(String word) {
        String key = generateKey(word);

        if (!map.containsKey(key)) {
            map.put(key, new TreeSet<>(Arrays.asList(word)));
        } else {
            Set<String> set = map.get(key);
            set.add(word);
        }
    }

    private static String generateKey(String word) {
        Map<Character, Integer> map = new TreeMap<>();
        StringBuilder builder = new StringBuilder();
        char arr[] = word.toLowerCase().toCharArray();

        for (char key : arr) {
            int value = map.getOrDefault(key, 0);
            map.put(key, ++value);
        }

        Set<Character> set = map.keySet();
        for (Character ch : set) {
            builder.append(ch + Integer.toString(map.get(ch)));
        }

        return builder.toString();
    }

    public String[] getAnagrams(String word) {
        String key = generateKey(word);
        Set<String> set = map.getOrDefault(key, new TreeSet<>());
        return set.stream().toArray(String[]::new);
    }

    public static void main(String[] args) {
        Anagrams obj = new Anagrams();
        String words[] = { "ate", "eat", "THIS", "EAT" };
        obj.addWords(words);
        for (String anagram : obj.getAnagrams("tea")) {
            System.out.println(anagram);
        }
    }
}
