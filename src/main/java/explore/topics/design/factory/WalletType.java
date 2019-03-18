package explore.topics.design.factory;

import java.util.Optional;

public interface WalletType {
    Optional<String> purchase(String transactionSequenceId, int stake);
}
