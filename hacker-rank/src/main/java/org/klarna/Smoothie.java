package org.klarna;


import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Smoothie {

    private static List<String> menuDetails = List.of("Classic: strawberry, banana, pineapple, mango, peach, honey",
            "Freezie: blackberry, blueberry, black currant, grape juice, frozen yogurt",
            "Greenie: green apple, lime, avocado, spinach, ice, apple juice",
            "Just Desserts: banana, ice cream, chocolate, peanut, cherry");
    private static Map<String, List<String>> smoothiesMap = new HashMap<>();
    public static String ingredients(String order) {
        List<String> drinkArgs = new ArrayList<>();
        List<String> newContents = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        if(smoothiesMap.isEmpty()) {
            menuDetails.forEach(menu -> fillMap(menu));
        }
        if(order != null) {
            String[] orderDetails = order.split(",");
            String drinkType = orderDetails[0].trim();
            if(smoothiesMap.containsKey(drinkType)) {
                for (int i = 1; i < orderDetails.length; i++) {
                    drinkArgs.add(orderDetails[i]);
                }
                List<String> originalContents = smoothiesMap.get(drinkType);
                newContents = originalContents;
                for (String ing: drinkArgs) {
                    if(ing.startsWith("-")) {
                        processRestrictedIngredients(originalContents, newContents, ing);
                    } else {
                        if(originalContents.contains(ing)) {
                            throw new IllegalArgumentException();
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException();
            }

            Collections.sort(newContents);
            for (int i = 0; i < newContents.size(); i++) {
                sb.append(newContents.get(i));
                if(i != newContents.size()-1) {
                    sb.append(",");
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        return sb.toString();
    }

    private static void processRestrictedIngredients(List<String> originalContents, List<String> newContents, String ing) {
        String ingName = ing.substring(1);
        if(originalContents.contains(ingName)) {
            newContents.remove(ingName);
        }
    }

    private static void fillMap(String drink) {
        String[] item = drink.split(":");
        if(item.length == 2) {
            List<String> ingredients = Arrays.stream(item[1].split(",")).map(String::trim).collect(Collectors.toList());
            smoothiesMap.put(item[0].trim(), ingredients);
        }
    }

    @Test
    public void test00() {
        String order = "Classic";
        String output = "banana,honey,mango,peach,pineapple,strawberry";
        String ingredients = ingredients(order);
        assertEquals(ingredients, output);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test001() {
        String order = "Classi";
        String ingredients = ingredients(order);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test002() {
        String order = null;
        String ingredients = ingredients(order);
    }

    @Test
    public void test01() {
        String order = "Classic,-strawberry,-peanut";
        String output = "banana,honey,mango,peach,pineapple";
        String ingredients = ingredients(order);
        assertEquals(ingredients, output);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test02() {
        String order = "Classic,mango";
        String ingredients = ingredients(order);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test03() {
        String order = "Vitamin smoothie";
        String ingredients = ingredients(order);
        assertEquals(ingredients, "");
    }


}
