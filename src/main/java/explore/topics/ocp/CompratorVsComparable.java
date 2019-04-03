package explore.topics.ocp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class CompratorVsComparable {
    public static void main(String[] args) {
        Compareble1 c1 = new Compareble1("C", 2);
        Compareble1 c2 = new Compareble1("B", 1);
        Compareble1 c3 = new Compareble1("D", 3);
        Compareble1 c4 = new Compareble1("A", 0);

        Set<Compareble1> compareSet = new TreeSet<>();
        compareSet.add(c1);
        compareSet.add(c2);
        compareSet.add(c3);
        compareSet.add(c4);

        compareSet.stream().forEach((n) -> System.out.println(n.getLabel()));


        Comparator1 ct1 = new Comparator1("Gaurav", 2);
        Comparator1 ct2 = new Comparator1("Amit", 1);
        Comparator1 ct3 = new Comparator1("Aadi", 3);
        Comparator1 ct4 = new Comparator1("Sonia", 0);

        List<Comparator1> compareList = new ArrayList<>();
        compareList.add(ct1);
        compareList.add(ct2);
        compareList.add(ct3);
        compareList.add(ct4);

        Collections.sort(compareList, new MyComparatorExp());
        compareList.stream().forEach((n) -> System.out.println(n.getLabel()));


    }
}

/* Comparable  Comparable  Comparable  Comparable  Comparable*************************
Natural Ordering
single method int compareTo(T o)
Object of class implementing Comparable, can be sorted in a collection or array
compareTo===equals - recommended (SortedSet/SortedMap should behave in normal ways)


*/
class Compareble1 implements Comparable<Compareble1> {
    private String label;
    private Integer value;

    public Compareble1(String label, Integer value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public int compareTo(Compareble1 o) {
        return this.label.compareTo(o.getLabel());
    }
}

/*
Comparator  Comparator  Comparator  Comparator  Comparator*************************
Natural Ordering
single abstract method int compare(T o1, T o2)
compareTo===equals - recommended (SortedSet/SortedMap should behave in normal ways)
*/
class Comparator1 {
    private String label;
    private Integer value;

    public Comparator1(String label, Integer value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public Integer getValue() {
        return value;
    }
}

class MyComparatorExp implements Comparator<Comparator1> {

    @Override
    public int compare(Comparator1 o1, Comparator1 o2) {
        return o1.getLabel().compareTo(o2.getLabel());
    }
}