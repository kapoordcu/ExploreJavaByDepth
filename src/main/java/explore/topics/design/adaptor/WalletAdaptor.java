package explore.topics.design.adaptor;

import org.springframework.util.StringUtils;

import java.util.Optional;

public class WalletAdaptor implements TpiWalletService {

    EMWalletService emWalletService;
    TpiWalletService tpiWalletService;

    public WalletAdaptor(String emToken, TpiWalletService tpiWalletService) {
        if(!StringUtils.isEmpty(emToken)) {
            emWalletService = new EMWalletServiceImpl();
        }
        this.tpiWalletService = tpiWalletService;
    }

    @Override
    public Optional<TpiTransactionSequenceDTOHLP> purchase(ExternalSystemIdHLP externalSystemIdHLP, CustomerHLP customerHLP, String transactionSequenceId, int stake) {
        if(!StringUtils.isEmpty(customerHLP.getEmToken())) {
            return emWalletService.emPurchase(customerHLP, stake);
        }
        return tpiWalletService.purchase(externalSystemIdHLP, customerHLP, transactionSequenceId, stake);
    }
}
