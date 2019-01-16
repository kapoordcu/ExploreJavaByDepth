package explore.topics.design;

import java.util.List;
import java.util.stream.Stream;

enum Confidence {
    LOW, MID, HIGH
}

enum SportsType {
    SOCCER, TABLETENNIS, BASEBALL, HANDBALL
}

class Event {
    public String id;
    public Confidence confidence;
    public SportsType sportsType;

    public Event(String id, Confidence confidence, SportsType sportsType) {
        this.id = id;
        this.confidence = confidence;
        this.sportsType = sportsType;
    }
}

class EventFilter {
    public Stream<Event> filterByConfidence(List<Event> eventList, Confidence confidence) {
        return eventList.stream().filter(p -> p.confidence == confidence);
    }

    public Stream<Event> filterBySportsType(List<Event> products, SportsType sportsType) {
        return products.stream().filter(p -> p.sportsType == sportsType);
    }

    public Stream<Event> filterByConfidenceAndSportsType(List<Event> products, Confidence confidence, SportsType sportsType) {
        return products.stream().filter(p -> p.confidence == confidence && p.sportsType == sportsType);
    }
    // state space explosion
    // 3 criteria = 7 methods
}

public class OpenClose {
    Event event1 = new Event("1L", Confidence.HIGH, SportsType.SOCCER);
    Event event2 = new Event("2L", Confidence.HIGH, SportsType.BASEBALL);
    Event event3 = new Event("3L", Confidence.LOW, SportsType.HANDBALL);
    Event event4 = new Event("4L", Confidence.MID, SportsType.SOCCER);
    Event event5 = new Event("5L", Confidence.LOW, SportsType.TABLETENNIS);

    //List<Event> eventList = List.of(event1, event2, event3, event4, event5);

    EventFilter eventFilter = new EventFilter();
}

//////////////OPEN CLOSE IN ACTION /////////////
interface Specification<T> {
    boolean specificationMet(T spec);
}

interface Filter<T> {
    Stream<T> checkFilter(List<T> types, Specification<T> specs);
}

class ConfidenceSpecification implements Specification<Event> {
    private Confidence confidence;
    public ConfidenceSpecification(Confidence confidence) {
        this.confidence = confidence;
    }

    @Override
    public boolean specificationMet(Event spec) {
        return spec.confidence == confidence;
    }
}

class SportsTypeSpecification implements Specification<Event> {
    private SportsType sportsType;
    public SportsTypeSpecification(SportsType sportsType) {
        this.sportsType = sportsType;
    }

    @Override
    public boolean specificationMet(Event spec) {
        return spec.sportsType == sportsType;
    }
}

class ANDSpecification implements Specification<Event> {
    private SportsType sportsType;
    private Confidence confidence;

    ANDSpecification(SportsType sportsType, Confidence confidence) {
        this.sportsType = sportsType;
        this.confidence = confidence;
    }


    @Override
    public boolean specificationMet(Event spec) {
        return spec.confidence==confidence && spec.sportsType==sportsType;
    }
}