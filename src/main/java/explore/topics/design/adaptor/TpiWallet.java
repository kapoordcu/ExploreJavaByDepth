package explore.topics.design.adaptor;

import java.util.Optional;

// Concrete Implementer
public class TpiWallet implements Wallet {
    @Override
    public Optional<TransactionSequence> purchase(Customer customer, String transactionSequenceId, int stake) {
        System.out.println("TPI Wallet is used with transactionSequenceId.");
        return Optional.of(new TransactionSequence(transactionSequenceId));
    }
}
