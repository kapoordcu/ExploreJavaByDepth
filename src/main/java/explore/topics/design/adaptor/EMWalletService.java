package explore.topics.design.adaptor;

import java.util.Optional;

// Concrete Implementer
public class EMWalletService implements WalletService {
    @Override
    public Optional<TransactionSequence> purchase(WalletType walletType, Customer customer, String transactionSequenceId, int stake) {
        System.out.println("EM Wallet is used.");
        return Optional.of(new TransactionSequence(walletType.name() + ":" + transactionSequenceId));
    }
}
