package interviews;

// Add a method which takes a collection of flights and returns the collection of unique destinations
// which can be reached from a specific origin for a total fare of 500 or less when any number of
// intermediate stops are allowed (a -> b -> c -> ... -> n).
//
// Example:

// Given the above collection of flights and the origin "EDI":
// The expected result would be the destination strings "LHR", "BCN", "PRG", "SIN", and "DUB"

import lombok.Getter;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class AirportFareProblem {

    Flight f1 = new Flight("EDI", "LHR", 123.45);
    Flight f2 = new Flight("LHR", "BCN", 80.90);
    Flight f3 = new Flight("BCN", "PRG", 98.45);
    Flight f4 = new Flight("EDI", "SIN", 300.90);
    Flight f5 = new Flight("PRG", "HAN", 400.00);
    Flight f6 = new Flight("EDI", "BOM", 547.50);
    Flight f7 = new Flight("EDI", "DUB", 47.50);
    Flight f8 = new Flight("DUB", "EDI", 53.20);
    Flight f9 = new Flight("DUB", "BCN", 99.50);

    Set<String> possibleRoutes = new HashSet<>();
    public Set<Flight> findDestinationsUnder(List<Flight> flights, String origin, double budget) {
        return flights.stream().filter(f -> f.getOrigin().equals(origin))
                .filter(f -> f.getFare() <= budget)
                .collect(Collectors.toSet());
    }

    public Set<String> reachableDestinations(List<Flight> flights, String origin, double budget) {
        Map<String, Boolean> visited = createVisitedStops(flights);
        Set<String> possibleHops = new HashSet<>();
        dfs(origin, flights, visited, budget, possibleHops);
        return possibleHops;
    }

    private void dfs(String origin, List<Flight> flights, Map<String, Boolean> visited, double budget, Set<String> possibleHops) {
        Set<Flight> neighbours = findDestinationsUnder(flights, origin, budget);
        visited.put(origin, true);
        for (Flight f:         neighbours) {
            if(!visited.get(f.destination)) {
                possibleHops.add(f.destination);
                dfs(f.destination, flights, visited, budget - f.getFare(), possibleHops);
            }
        }
    }

    private Map<String, Boolean> createVisitedStops(List<Flight> flights) {
        Map<String, Boolean> visited = new HashMap<>();
        for (Flight f:         flights) {
            if(!visited.containsKey(f.origin)) {
                visited.put(f.origin, false);
            }
            if(!visited.containsKey(f.destination)) {
                visited.put(f.destination, false);
            }
        }
        return visited;
    }

    public List<String> startJourney(List<Flight> flights, String origin, double budget) {
        List<String> possibleRoutes = new ArrayList<>();
        Stack<Flight> dfs = new Stack<>();
        dfs.add(new Flight(origin, null, 0));
        while(!dfs.isEmpty()) {
            Flight currentFlight = dfs.pop();
            if(!origin.equals(currentFlight.getOrigin())) {
                addToResultIfUnderMaxFare(possibleRoutes, currentFlight, budget - currentFlight.getFare());
            }
            Set<Flight> nextLegStops = findDestinationsUnder(flights, currentFlight.origin, budget - currentFlight.getFare());
            for(Flight stops: nextLegStops) {
                dfs.push(new Flight(stops.destination, null, stops.fare));
            }
        }
        return possibleRoutes;
    }

    public void  addToResultIfUnderMaxFare(List<String> possibleRoutes, Flight currentFlight, double maxFare) {
        if(currentFlight.getFare() <= maxFare) {
            possibleRoutes.add(currentFlight.getDestination());
        }
    }

    @Test
    public void multiple_hopes() {
        String origin = "EDI";
        List<Flight> flights = List.of(f1, f2, f3, f4, f5, f6, f7, f8, f9);
        Set<String> destinationsUnder = reachableDestinations(flights, origin, 500);
        assertTrue(destinationsUnder.contains("LHR"));
        assertTrue(destinationsUnder.contains("BCN"));
        assertTrue(destinationsUnder.contains("PRG"));
        assertTrue(destinationsUnder.contains("SIN"));
        assertTrue(destinationsUnder.contains("DUB"));
    }

    @Test
    public void base_0() {
        String origin = "EDI";
        List<Flight> flights = List.of(f1, f2, f3, f4, f5, f6, f7, f8, f9);
        Set<Flight> destinationsUnder = findDestinationsUnder(flights, origin, 500);
        assertTrue(destinationsUnder.size()==3);
        assertTrue(destinationsUnder.contains(f1));
        assertTrue(destinationsUnder.contains(f4));
        assertTrue(destinationsUnder.contains(f7));
    }

}

@Getter
class Flight {
    String origin;
    String destination;
    double fare;

    public Flight(String origin, String destination, double fare) {
        this.origin = origin;
        this.destination = destination;
        this.fare = fare;
    }
}