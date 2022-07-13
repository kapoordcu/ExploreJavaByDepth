package specials;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class CompartmentCount {

    @Test
    public void testHj() {
        String s = "|**|*|*";
        List<Integer> startIndices = List.of(1,1);
        List<Integer> endIndices = List.of(5, 6);
        List<Integer> swaps = CompartmentCount.numberOfItems(s, startIndices, endIndices);
        assertTrue(swaps.size()==2);
        assertTrue(swaps.get(0)==2);
        assertTrue(swaps.get(1)==3);
    }

    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        List<Integer> compartments = new LinkedList<>();
        if(startIndices.size()==endIndices.size()) {
            for (int i = 0; i < startIndices.size(); i++) {
                compartments.add(calculateCompartment(s, startIndices.get(i),endIndices.get(i)));
            }
        }
        return compartments;
    }

    private static Integer calculateCompartment(String s, Integer start, Integer end) {
        int compartmentsize = 0;
        Pattern p = Pattern.compile("(?<=\\|)[^|]++(?=\\|)");
        Matcher m = p.matcher(s.substring(start-1, end));
        while(m.find()){
            compartmentsize += m.group().length();
        }
        return compartmentsize;
    }

}
