package explore.topics.design.adaptor;

import java.util.Optional;

// Concrete Implementer
public class EMWallet implements Wallet {
    @Override
    public Optional<TransactionSequence> purchase(Customer customer, String transactionSequenceId, int stake) {
        System.out.println("EM Wallet is used with emToken.");
        return Optional.of(new TransactionSequence(customer.getEmToken()));
    }
}
