package explore.topics.design.adaptor;

import java.util.Optional;

public class WalletAdaptor implements WalletService {

    WalletService walletService;

    public WalletAdaptor(WalletService walletService) {
        this.walletService = walletService;
    }

    public Optional<TransactionSequence> emPurchase(String emToken, int stake) {
        return walletService.purchase(WalletType.WALLET_EM, new Customer(emToken, emToken),
                emToken, stake);
    }

    @Override
    public Optional<TransactionSequence> purchase(WalletType walletType,
                                                  Customer customer, String transactionSequenceId, int stake) {
        return emPurchase(customer.getEmToken(), stake);
    }
}
