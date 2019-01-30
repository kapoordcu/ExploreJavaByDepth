package explore.topics.design.adaptor;

import java.util.Optional;

public class TpiWalletService implements WalletService {
    @Override
    public Optional<TransactionSequence> purchase(WalletType walletType, Customer customer, String transactionSequenceId, int stake) {
        return Optional.of(new TransactionSequence(walletType.name()));
    }
}
