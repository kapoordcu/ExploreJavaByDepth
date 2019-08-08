package explore.topics.design.aDip;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Triplet;

public class DIP_ExtraExample {
    public static void main(String[] args) {
        Man john = new Man("John");
        Man chris = new Man("Chris");
        Man evan = new Man("Evan");

        RelatiopnShips relatiopnShips = new RelatiopnShips();
        relatiopnShips.connectParentChild(john, chris);
        relatiopnShips.connectParentChild(john, evan);

        new FindRelationShipTree(relatiopnShips);
    }
}

enum Relation {
    PARENT, CHILD, SIBLINGS
}

class Man {
    private String name;

    public Man(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class RelatiopnShips { // low-level - Data
    // Public level getter exposed to outer world
    public List<Triplet<Man, Relation, Man>> getRelations() {
        return relations;
    }

    private List<Triplet<Man, Relation, Man>> relations =
            new ArrayList<>();

    public void connectParentChild(Man a, Man b) {
        relations.add(new Triplet<>(a, Relation.PARENT, b));
        relations.add(new Triplet<>(b, Relation.CHILD, a));
    }
}

class FindRelationShipTree { // High-level module
    public FindRelationShipTree(RelatiopnShips relatiopnShips) {
        relatiopnShips.getRelations().stream()
                .filter( x -> x.getValue0().getName().equals("John")
                && x.getValue1() == Relation.PARENT)
                .forEach(tuple -> System.out.println("John has a child called " + tuple.getValue2().getName()));
    }
}