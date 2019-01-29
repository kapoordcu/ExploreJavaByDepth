package explore.topics.design.adaptor;

import java.util.Optional;

public class TpiWalletAdaptor implements EMWalletService {

    TpiWalletService tpiWalletService;

    public TpiWalletAdaptor(TpiWalletService tpiWalletService) {
        this.tpiWalletService = tpiWalletService;
    }

    @Override
    public Optional<TpiTransactionSequenceDTOHLP> emPurchase(String emToken, int stake) {
        return tpiWalletService.purchase(ExternalSystemIdHLP.SWIPE_IN_SLOTS, new CustomerHLP(emToken, emToken),
                emToken, stake);
    }
}
