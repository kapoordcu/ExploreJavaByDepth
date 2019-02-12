package explore.topics.design.adaptor;

import java.util.Optional;

public class WalletAdaptor implements Wallet {

    EMWallet emWallet;

    public WalletAdaptor(EMWallet emWallet) {
        this.emWallet = emWallet;
    }

    @Override
    public Optional<TransactionSequence> purchase(Customer customer, String transactionSequenceId, int stake) {
        return emWallet.purchaseAndPayout(transactionSequenceId, stake);
    }
}
