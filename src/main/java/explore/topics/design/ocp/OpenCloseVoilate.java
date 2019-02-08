package explore.topics.design.ocp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
// This is okay for 2 criterias, Imagine there is one more criteria ( 3-- > 7 )
// You should not be jumping to the code which is already being written, Open for extension and closed to modification
// Your client already using shipped code in the form of binaries
public class OpenCloseVoilate {
    public static void main(String[] args) {
        List<Event> eventList = getEventsStub();

        EventFilter eventFilter = new EventFilter();
        eventFilter.filterByConfidence(eventList, Confidence.HIGH)
                .forEach(p -> System.out.println(p));
    }

    public static List<Event> getEventsStub() {
        Event event1 = new Event("1L", Confidence.HIGH, SportsType.SOCCER);
        Event event2 = new Event("2L", Confidence.HIGH, SportsType.BASEBALL);
        Event event3 = new Event("3L", Confidence.LOW, SportsType.HANDBALL);
        Event event4 = new Event("4L", Confidence.MID, SportsType.SOCCER);
        Event event5 = new Event("5L", Confidence.LOW, SportsType.TABLETENNIS);

        return Arrays.asList(event1, event2, event3, event4, event5);
    }
}

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

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", confidence=" + confidence +
                ", sportsType=" + sportsType +
                '}';
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
