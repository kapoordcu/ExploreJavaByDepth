package explore.topics.design.adaptor;

import java.util.Optional;

public interface TpiWalletService {

    Optional<TpiTransactionSequenceDTOHLP> purchase(ExternalSystemIdHLP externalSystemIdHLP, CustomerHLP customerHLP,
                                                    String transactionSequenceId, int stake);

}