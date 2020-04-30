package org.check24;

import com.sun.source.tree.Tree;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.assertTrue;

public class StringSortByCount {

    public static String featuredProductSubmitted(List<String> products) {
        Map<String, Integer> stringFrequencyCountMap = new HashMap<String, Integer>();
        int max = 0;
        Set<String> results = new TreeSet<String>();
        for(String product : products) {
            if(stringFrequencyCountMap.containsKey(product)) {
                stringFrequencyCountMap.put(product, stringFrequencyCountMap.get(product)+1);
            }
            else {
                stringFrequencyCountMap.put(product,1);
            }
        }

        for (Map.Entry<String,Integer> entry : stringFrequencyCountMap.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        for(Map.Entry<String,Integer> entry : stringFrequencyCountMap.entrySet()) {
            if(entry.getValue() == max) {
                results.add(entry.getKey());
            }
        }
        return (String)results.toArray()[results.size()-1];
    }

    public static String featuredProductJava8(List<String> products) {
        Map<String, Long> groupByCount = products.stream()
                .collect(groupingBy(Function.identity(), counting()));
        Optional<Long> maxProduct = groupByCount.values().stream().max(Long::compareTo);
        if(maxProduct.isPresent()) {
            int nextDayPromotion = maxProduct.get().intValue();
            TreeSet<String> promotionSet = groupByCount.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() == nextDayPromotion)
                    .map(entry -> entry.getKey())
                    .collect(Collectors.toCollection(() -> new
                            TreeSet<>(Comparator.comparing(String::valueOf))));
            return promotionSet.last();
        }
        return null;
    }

    @Test
    public void testScenario1() {
        List<String> products = Arrays.asList("red", "green", "red", "orange"
                , "black", "black");
        String s = StringSortByCount.featuredProductSubmitted(products);
        String s1 = StringSortByCount.featuredProductJava8(products);
        assertTrue("red".equalsIgnoreCase(s));
        assertTrue("red".equalsIgnoreCase(s1));
    }

    @Test
    public void testScenario2() {
        List<String> products = Arrays.asList("red", "green", "red", "green"
                , "black", "green");
        String s = StringSortByCount.featuredProductSubmitted(products);
        String s1 = StringSortByCount.featuredProductJava8(products);
        assertTrue("green".equalsIgnoreCase(s));
        assertTrue("green".equalsIgnoreCase(s1));
    }

    @Test
    public void testScenario3() {
        List<String> products = Arrays.asList("red", "red", "red", "voilet"
                , "voilet", "voilet");
        String s = StringSortByCount.featuredProductSubmitted(products);
        String s1 = StringSortByCount.featuredProductJava8(products);
        assertTrue("voilet".equalsIgnoreCase(s));
        assertTrue("voilet".equalsIgnoreCase(s1));
    }
}
