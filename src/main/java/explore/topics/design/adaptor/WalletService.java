package explore.topics.design.adaptor;

import java.util.Optional;

// Implementer Interface = Bridge
public interface WalletService {
    Optional<TransactionSequence> purchase(WalletType walletType, Customer customer,
                                           String transactionSequenceId, int stake);
}
