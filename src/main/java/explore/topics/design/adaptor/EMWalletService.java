package explore.topics.design.adaptor;

import java.util.Optional;

public interface EMWalletService {
    Optional<TpiTransactionSequenceDTOHLP> emPurchase(CustomerHLP customerHLP, int stake);
}
