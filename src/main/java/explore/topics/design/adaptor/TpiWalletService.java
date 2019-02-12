package explore.topics.design.adaptor;

import java.util.Optional;

// Concrete Implementer
public class TpiWalletService implements WalletService {
    @Override
    public Optional<TransactionSequence> purchase(WalletType walletType, Customer customer, String transactionSequenceId, int stake) {
        System.out.println("TPI Wallet is used.");
        return Optional.of(new TransactionSequence(walletType.name()));
    }
}
