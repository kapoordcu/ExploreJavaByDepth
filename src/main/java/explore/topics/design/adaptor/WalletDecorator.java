package explore.topics.design.adaptor;

import java.util.Optional;

public class WalletDecorator implements WalletService {

    private WalletService walletService;
    private String paymentGateWay;

    public WalletDecorator(WalletService walletService, String paymentGateWay) {
        this.walletService = walletService;
        this.paymentGateWay = paymentGateWay;
    }

    @Override
    public Optional<TransactionSequence> purchase(WalletType walletType, Customer customer, String transactionSequenceId, int stake) {
        return Optional.of(new TransactionSequence(walletType.name() + " with PG : " + paymentGateWay));
    }
}
