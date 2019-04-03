package explore.topics.design.bridgepattern;

public class BIProvider extends SourceProvider {
    public BIProvider(SportType sportType) {
        super(sportType);
    }

    @Override
    public void getRecommendationProviderForSport() {
        sportType.sportName();
        System.out.println("BIProvider");
    }
}
