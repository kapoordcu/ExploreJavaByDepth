package explore.topics.design.adaptor;

import java.util.Optional;

public interface EMWalletService {
    Optional<TpiTransactionSequenceDTOHLP> emPurchase(String emToken, int stake);
}
