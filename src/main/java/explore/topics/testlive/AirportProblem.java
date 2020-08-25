package explore.topics.testlive;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// You are given an unordered list of source and destination airports
// for a set of routes. Find the path through the airports and output.
public class AirportProblem {

    public List<List<String>> findPaths(Map<String, String> routes) {
        List<List<String>> pathsMultiple = new ArrayList<>();
        for (Map.Entry<String, String> entry : routes.entrySet()) {
            List<String> findPath = getPath(entry.getKey(), routes);
            pathsMultiple.add(findPath);
        }
        return pathsMultiple;
    }

    private List<String> getPath(String source, Map<String, String> routes) {
        List<String> path = new ArrayList<>();
        while(source!=null)  {
            path.add(source);
            source = routes.get(source);
        }
        return path;
    }

    @Test
    public void getPathPhase1() {
        Map<String, String> routes = Map.of(
                        "SFO", "JFK",
                        "MAD", "SYD",
                        "SYD", "SFO",
                        "JFK", "LHR");
        List<List<String>> paths = findPaths(routes);
        List.of("MAD", "SYD", "SFO", "JFK", "LHR");

    }
}

