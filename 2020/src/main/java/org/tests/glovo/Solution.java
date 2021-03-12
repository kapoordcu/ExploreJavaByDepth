package org.tests.glovo;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class Solution {

    public static final Map<String, Float> WEIGHTS = new HashMap<String, Float>() {{
        put("review draft", 2.0f);
        put("photo", 1.0f);
        put("check-in", 0.8f);
        put("bookmark", 0.25f);
    }};

    public static List<Integer> interactionsToSortedBusinesses(List<Interaction> interactions) {
        /*
        Takes a list of interactions with various businesses and returns a list of
        business ids sorted by highest total review suggestion weight.

        :param interactions: a list of Interactions, in no particular order
        :return: sorted list of business ids, order by total review suggestion weight, descending
        */
        Map<Integer, Float> interactScoreMap = processInteractionsIntoMapByWeights(interactions);
        LinkedHashMap<Integer, Float> sortInteractionMapByScore =
                interactScoreMap.entrySet().stream()
                        .sorted(Map.Entry.<Integer, Float>comparingByValue().reversed()
                                .thenComparing(Map.Entry.comparingByKey()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return new ArrayList<>(sortInteractionMapByScore.keySet());

    }

    private static Map<Integer, Float> processInteractionsIntoMapByWeights(List<Interaction> interactions) {
        Map<Integer, Float> interactScoreMap = new HashMap<>();

        for (Interaction it:         interactions) {
            String type = it.getInteractionType();
            int businessId = it.getBusinessId();
            if(WEIGHTS.containsKey(type)) {
                if(interactScoreMap.containsKey(businessId)) {
                    Float prevScore = interactScoreMap.get(businessId);
                    interactScoreMap.put(businessId, prevScore + WEIGHTS.get(type));
                } else {
                    interactScoreMap.put(businessId, WEIGHTS.get(type));
                }
            }
        }
        return interactScoreMap;
    }

    @Test
    public void set1() {
        Interaction i1= new Interaction("photo", 1);
        Interaction i2= new Interaction("bookmark", 2);
        Interaction i3= new Interaction("check-in", 3);
        Interaction i4= new Interaction("review draft", 4);
        Interaction i5= new Interaction("check-in", 4);
        List<Interaction> interactions = Arrays.asList(i1, i2, i3, i4, i5);
        List<Integer> integers = interactionsToSortedBusinesses(interactions);
        assertTrue(integers.get(0)==4);
        assertTrue(integers.get(1)==1);
        assertTrue(integers.get(2)==3);
        assertTrue(integers.get(3)==2);
    }
}

class Interaction {
    // A single interaction with a business
    String interactionType;
    int businessId;

    public Interaction(String interactionType, int businessId) {
        this.interactionType = interactionType;
        this.businessId = businessId;
    }

    public String getInteractionType() { return this.interactionType; }
    public int getBusinessId() { return this.businessId; }

}
