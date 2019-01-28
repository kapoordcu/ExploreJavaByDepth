package explore.topics.design.adaptor;


/**
 * A class that represents transaction sequence information.
 */
public class TpiTransactionSequenceDTOHLP {
    private final String resourceId;

    public TpiTransactionSequenceDTOHLP(final String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceId() {
        return resourceId;
    }
}
