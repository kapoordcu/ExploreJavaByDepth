package explore.topics.design.adaptor;

import java.util.Optional;

// Implementer Interface = Bridge
public interface Wallet {
    Optional<TransactionSequence> purchase(Customer customer,
                                           String transactionSequenceId, int stake);
}
