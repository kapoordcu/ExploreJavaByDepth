package explore.topics.design.adaptor;

import java.util.Optional;

public interface WalletService {

    Optional<TpiTransactionSequenceDTOHLP> purchase(ExternalSystemIdHLP externalSystemIdHLP, CustomerHLP customerHLP,
                                                    String transactionSequenceId, int stake);

    Optional<TpiTransactionSequenceDTOHLP> payout(ExternalSystemIdHLP externalSystemIdHLP, CustomerHLP customerHLP,
                                                  String transactionSequenceId, int win);
}