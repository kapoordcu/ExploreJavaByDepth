package explore.topics.design.ocp;

import java.awt.peer.ScrollbarPeer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class OpenClose {
    public static void main(String[] args) {
        Event event1 = new Event("1L", Confidence.HIGH, SportsType.SOCCER);
        Event event2 = new Event("2L", Confidence.HIGH, SportsType.BASEBALL);
        Event event3 = new Event("3L", Confidence.LOW, SportsType.HANDBALL);
        Event event4 = new Event("4L", Confidence.MID, SportsType.SOCCER);
        Event event5 = new Event("5L", Confidence.LOW, SportsType.TABLETENNIS);

        List<Event> eventList = Arrays.asList(event1, event2, event3, event4, event5);

        System.out.println("Open Closed Implemented");
        Filter filterOCP = new EventFilterOCP();

        System.out.println("Confidence.MID");
        filterOCP.filterOCP(eventList, new ConfidanceSpec(Confidence.MID))
                .forEach(e -> System.out.println(e));

        System.out.println("SportsType.SOCCER");
        filterOCP.filterOCP(eventList, new SportsSpec(SportsType.SOCCER))
                .forEach(e -> System.out.println(e));

        System.out.println("SportsType.SOCCER && Confidence.MID");
        filterOCP.filterOCP(eventList, new CombinedTwo(
                new ConfidanceSpec(Confidence.MID),
                new SportsSpec(SportsType.SOCCER)
        )).forEach(e -> System.out.println(e));
    }
}

////////////////OPEN CLOSE IN ACTION /////////////
interface Specification<T> {
    boolean isSatisfied(T specification);
}

interface Filter<T> {
    Stream<T> filterOCP(List<T> events, Specification<T> specs);
}

class EventFilterOCP implements Filter {
    @Override
    public Stream filterOCP(List events, Specification specs) {
        return events.stream().filter(e -> specs.isSatisfied(e));
    }
}

class ConfidanceSpec implements Specification<Event> {

    private Confidence confidence;
    public ConfidanceSpec(Confidence confidence) {
        this.confidence = confidence;
    }
    @Override
    public boolean isSatisfied(Event event) {
        return event.confidence == confidence;
    }
}

class SportsSpec implements Specification<Event> {

    private SportsType sportsType;
    public SportsSpec(SportsType sportsType) {
        this.sportsType = sportsType;
    }
    @Override
    public boolean isSatisfied(Event event) {
        return event.sportsType == sportsType;
    }
}

class CombinedTwo<T> implements Specification<T> {
    private Specification<T> one, two;

    public CombinedTwo(Specification<T> one, Specification<T> two) {
        this.one = one;
        this.two = two;
    }

    @Override
    public boolean isSatisfied(T specification) {
        return one.isSatisfied(specification) && two.isSatisfied(specification);
    }
}