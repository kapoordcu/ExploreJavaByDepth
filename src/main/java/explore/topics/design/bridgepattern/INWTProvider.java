package explore.topics.design.bridgepattern;

public class INWTProvider extends SourceProvider {
    public INWTProvider(SportType sportType) {
        super(sportType);
    }

    @Override
    public void getRecommendationProviderForSport() {
        sportType.sportName();
        System.out.println("INWTProvider");
    }
}
