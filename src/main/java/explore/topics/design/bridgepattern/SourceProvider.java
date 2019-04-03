package explore.topics.design.bridgepattern;

public abstract class SourceProvider {
    protected SportType sportType;

    public SourceProvider(SportType sportType) {
        this.sportType = sportType;
    }

    public abstract void getRecommendationProviderForSport();
}
