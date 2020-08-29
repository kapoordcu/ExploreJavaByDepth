package explore.topics._strings;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class IntersectionStringList {

    @Test
    public void intersect() {
        List<String> list1 = Arrays.asList("11@N3", "23@N0", "62@N0", "99@N0", "47@N7");
        List<String> list2 = Arrays.asList("23@N0", "12@N1");
        List<String> collect = findInterSection(list1, list2);
        assertTrue(collect.size()==1);
        assertTrue(collect.get(0).equals("23@N0"));
    }

    private List<String> findInterSection(List<String> list1, List<String> list2) {
        return list1.stream()
                .filter(s -> list2.contains(s))
                .collect(Collectors.toList());
    }
}
