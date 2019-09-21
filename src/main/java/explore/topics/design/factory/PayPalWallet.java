package explore.topics.design.factory;

import java.util.Optional;

public class PayPalWallet implements WalletType {
    @Override
    public Optional<String> purchase(String transactionSequenceId, int stake) {
        return Optional.of("Paypal:" + transactionSequenceId);
    }
}
