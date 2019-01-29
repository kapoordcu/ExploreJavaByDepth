package explore.topics.design.adaptor;

import java.util.Optional;

public class EMWalletServiceImpl implements EMWalletService {
    @Override
    public Optional<TpiTransactionSequenceDTOHLP> emPurchase(String emToken, int stake) {
        return Optional.of(new TpiTransactionSequenceDTOHLP(emToken));
    }
}
