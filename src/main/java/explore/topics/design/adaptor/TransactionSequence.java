package explore.topics.design.adaptor;


/**
 * A class that represents transaction sequence information.
 */
public class TransactionSequence {
    private final String resourceId;

    public TransactionSequence(final String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceId() {
        return resourceId;
    }

    @Override
    public String toString() {
        return "resourceId='" + resourceId + '\'' +
                '}';
    }
}
