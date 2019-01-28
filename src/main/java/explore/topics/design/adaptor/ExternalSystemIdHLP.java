package explore.topics.design.adaptor;

import java.util.Locale;
import java.util.Objects;

public class ExternalSystemIdHLP {

    private String gameName;

    public static final ExternalSystemIdHLP SWIPE_IN_BLACKJACK = new ExternalSystemIdHLP("SWIPE_IN_BLACKJACK");
    public static final ExternalSystemIdHLP SWIPE_IN_ROULETTE = new ExternalSystemIdHLP("SWIPE_IN_ROULETTE");
    public static final ExternalSystemIdHLP SWIPE_IN_SLOTS = new ExternalSystemIdHLP("SWIPE_IN_SLOTS");

    public ExternalSystemIdHLP(String gameName) {
        this.gameName = gameName;
    }

    public final String name() {
        return gameName;
    }

    public static ExternalSystemIdHLP getSlots(String gameType) {
        return new ExternalSystemIdHLP(ExternalSystemIdHLP.SWIPE_IN_SLOTS.name() + "_" +
                gameType.toUpperCase(Locale.ENGLISH));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExternalSystemIdHLP that = (ExternalSystemIdHLP) o;
        return Objects.equals(gameName, that.gameName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameName);
    }
}
