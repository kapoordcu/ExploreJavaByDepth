package explore.topics.design.aAdaptor;

import java.util.UUID;

public class BankAccountExample {
    public static void main(String[] args) {
        Recommendation recommendation = new InternalRecommendation();
        recommendation.getEvents(UUID.randomUUID());
        // How to call third party API
    }
}

// Target Interface == client Interface
interface Recommendation {
    void getEvents(UUID uuid);
}


class InternalRecommendation implements Recommendation {
    @Override
    public void getEvents(UUID uuid) {
        System.out.println("Internal Events fetched");
    }
}

// Adaptee - Incompatible
class EU3rdPartyAccount {
    public void getExternalEvents(String externalId) {
        System.out.println("Events from external dependency fetched");
    }
}

