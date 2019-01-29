package explore.topics.design.adaptor;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class WalletServiceAdaptor implements WalletService {

    private final EMWalletService emWalletService;

    @Autowired
    public WalletServiceAdaptor(EMWalletService emWalletService) {
        this.emWalletService = emWalletService;
    }

    @Override
    public Optional<TpiTransactionSequenceDTOHLP> purchase(ExternalSystemIdHLP externalSystemIdHLP, CustomerHLP customerHLP, String transactionSequenceId, int stake) {
        return emWalletService.emPurchase(externalSystemIdHLP, customerHLP.getEmToken(), transactionSequenceId, stake);
    }

}
