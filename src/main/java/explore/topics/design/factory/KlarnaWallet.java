package explore.topics.design.factory;

import java.util.Optional;

public class KlarnaWallet implements WalletType {
    @Override
    public Optional<String> purchase(String transactionSequenceId, int stake) {
        return Optional.of("Klarna:" + transactionSequenceId);
    }
}
