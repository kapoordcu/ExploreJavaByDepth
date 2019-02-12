package explore.topics.design.adaptor;

import java.util.Optional;

// Concrete Implementer
// Adaptee
public class EMWallet implements Wallet{

    public Optional<TransactionSequence> purchaseAndPayout(String gameSession, int stake) {
        System.out.println("EM Wallet is used with gameSession.");
        return Optional.of(new TransactionSequence(gameSession));
    }

    @Override
    public Optional<TransactionSequence> purchase(Customer customer, String transactionSequenceId, int stake) {
        return Optional.of(new TransactionSequence(transactionSequenceId));
    }
}
