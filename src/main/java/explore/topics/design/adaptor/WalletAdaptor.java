package explore.topics.design.adaptor;

import java.util.Optional;

public class WalletAdaptor implements Wallet {

    Wallet wallet;

    public WalletAdaptor(Wallet wallet) {
        this.wallet = wallet;
    }

    public Optional<TransactionSequence> incompatibleMethodCall(String emToken, int stake) {
        return wallet.purchase(new Customer(emToken, emToken), emToken, stake);
    }

    @Override
    public Optional<TransactionSequence> purchase(Customer customer, String transactionSequenceId, int stake) {
        return incompatibleMethodCall(customer.getEmToken(), stake);
    }
}
