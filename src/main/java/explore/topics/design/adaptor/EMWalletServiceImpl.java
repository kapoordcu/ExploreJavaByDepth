package explore.topics.design.adaptor;

import java.util.Optional;

public class EMWalletServiceImpl implements EMWalletService {
    @Override
    public Optional<TpiTransactionSequenceDTOHLP> emPurchase(CustomerHLP customerHLP, int stake) {
        return Optional.of(new TpiTransactionSequenceDTOHLP(customerHLP.getEmToken()));
    }
}
