package explore.topics.design.ocp;

import java.util.List;
import java.util.stream.Stream;

public class OpenCloseSolved {
    public static void main(String[] args) {
        List<Event> eventList = OpenCloseVoilate.getEventsStub();
                System.out.println("Open Closed Implemented");
        EventFilterWithSpec filterOCP = new EventFilterWithSpec();

        System.out.println("Confidence.MID");
        filterOCP.filterSpec(eventList, new ConfidencaSort(Confidence.MID))
                .forEach(e -> System.out.println(e));

        System.out.println("SportsType.SOCCER");
        filterOCP.filterSpec(eventList, new SportsSort(SportsType.SOCCER))
                .forEach(e -> System.out.println(e));

        System.out.println("SportsType.SOCCER && Confidence.MID");
        filterOCP.filterSpec(eventList, new SportsAndConfidanceSort(
                new ConfidencaSort(Confidence.MID),
                new SportsSort(SportsType.SOCCER)
        )).forEach(e -> System.out.println(e));
    }
}

interface Specification<T> {
    boolean isSpecificationSatisfied(T specification);
}

interface filterWithSpecification<T> {
    Stream<T> filterSpec(List<T> events, Specification<T> specs);
}

class EventFilterWithSpec implements filterWithSpecification {

    @Override
    public Stream filterSpec(List events, Specification specs) {
        return events.stream().filter(e -> specs.isSpecificationSatisfied(e));
    }
}

class ConfidencaSort implements Specification<Event> {
    private Confidence confidence;

    public ConfidencaSort(Confidence confidence) {
        this.confidence = confidence;
    }

    @Override
    public boolean isSpecificationSatisfied(Event event) {
        return event.confidence==confidence;
    }
}

class SportsSort implements Specification<Event> {
    private SportsType sportsType;

    public SportsSort(SportsType sportsType) {
        this.sportsType = sportsType;
    }

    @Override
    public boolean isSpecificationSatisfied(Event event) {
        return event.sportsType==sportsType;
    }
}

class SportsAndConfidanceSort<T> implements Specification<T> {
    private Specification<T> sportsType, confidance;

    public SportsAndConfidanceSort(Specification<T> sportsType, Specification<T> confidance) {
        this.sportsType = sportsType;
        this.confidance = confidance;
    }

    @Override
    public boolean isSpecificationSatisfied(T specification) {
        return sportsType.isSpecificationSatisfied(specification)
                && confidance.isSpecificationSatisfied(specification);
    }
}