package explore.topics.design.adaptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("walletService")
public class WalletServiceAdaptor implements WalletService {

    private final TPIImplementation tpiImplementation;
    private final EMImplementation emImplementation;

    @Autowired
    public WalletServiceAdaptor(TPIImplementation tpiImplementation, EMImplementation emImplementation) {
        this.tpiImplementation = tpiImplementation;
        this.emImplementation = emImplementation;
    }

    @Override
    public Optional<TpiTransactionSequenceDTOHLP> purchase(ExternalSystemIdHLP externalSystemIdHLP, CustomerHLP customerHLP, String transactionSequenceId, int stake) {
        return walletService(customerHLP).purchase(externalSystemIdHLP, customerHLP, transactionSequenceId, stake);
    }

    @Override
    public Optional<TpiTransactionSequenceDTOHLP> payout(ExternalSystemIdHLP externalSystemIdHLP, CustomerHLP customerHLP, String transactionSequenceId, int win) {
        return Optional.empty();
    }

    private WalletService walletService(CustomerHLP customer) {
        if (customer.getEmToken() != null) {
            return emImplementation;
        } else {
            return tpiImplementation;
        }
    }
}
