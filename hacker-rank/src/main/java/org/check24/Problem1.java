package org.check24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Problem1 {

    public static void main(String[] args) {
        List<String> products = Arrays.asList("red", "green", "red", "orange"
                , "black", "black");
        Problem1.featuredProduct(products);
    }
    public static String featuredProduct(List<String> products) {
        Map<String, Integer> collection = new HashMap<String, Integer>();
        int max = 0;
        Set<String> results = new TreeSet<String>();
        for(String product : products) {
            if(collection.containsKey(product)) {
                collection.put(product, collection.get(product)+1);
            }
            else {
                collection.put(product,1);
            }
        }

        for (Map.Entry<String,Integer> entry : collection.entrySet()) {
            if(entry.getValue() > max)
            {
                max = entry.getValue();
            }
        }

        for(Map.Entry<String,Integer> entry : collection.entrySet()) {
            if(entry.getValue() == max) {
                results.add(entry.getKey());
            }
        }
        return (String)results.toArray()[results.size()-1];
    }

    public static int getMinimumUniqueSum(List<Integer> arr) {
        List<Integer> storeResults = new ArrayList<>();
        int sum = 0;
        storeResults.add(arr.get(0));

        for (int i = 1; i < arr.size(); i++) {
            int val = arr.get(i);
            while (storeResults.contains(val)) {
                val++;
            }
            storeResults.add(val);
        }
        for (int i = 0; i < storeResults.size(); i++) {
            sum += storeResults.get(i);
        }

        return sum;

    }
}
