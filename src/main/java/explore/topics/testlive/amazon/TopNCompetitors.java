package explore.topics.testlive.amazon;



import java.util.*;
import java.util.stream.Collectors;

// CLASS BEGINS, THIS CLASS IS REQUIRED
class TopNCompetitors {

    public static void main(String[] args) {
        TopNCompetitors c = new TopNCompetitors();
        System.out.println(c.topNCompetitors(6, 2, Arrays.asList("a", "b", "c"), 6,
                Arrays.asList("a e h j l h", "b q w e r t t", "a w r e", "b", "b t u i w", "c")));
    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> topNCompetitors(int numCompetitors,
                                             int topNCompetitors,
                                             List<String> competitors,
                                             int numReviews,
                                             List<String> reviews) {
        // WRITE YOUR CODE HERE
        final Set<String> competitorsUnique = new HashSet<>(competitors);
        Map<String, Long> mapByOccuranceCount = new HashMap<>();
        String SEPERATER_SPACE = "\\s+";
        competitorsUnique.stream().forEach(competitor -> {
            reviews.stream().forEach(review -> {
                List<String> reviewRead = Arrays.asList(review.split(SEPERATER_SPACE));
                Long count = reviewRead.stream().filter(competitor::contains).count();
                if(count>0) {
                    Long currentCount = mapByOccuranceCount.get(competitor);
                    if(currentCount!=null) {
                        mapByOccuranceCount.put(competitor, ++currentCount);
                    } else {
                        mapByOccuranceCount.put(competitor, 1L);
                    }

                }
            });

        });
       Map<String, Long> sortedByFrequency = mapByOccuranceCount.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        List<String> topCompetitors = sortedByFrequency.keySet().stream()
                .limit(topNCompetitors)
                .collect(Collectors.toList());
        return new ArrayList<>(topCompetitors);
    }




}