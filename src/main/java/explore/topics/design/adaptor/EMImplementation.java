package explore.topics.design.adaptor;

import java.util.Optional;

public class EMImplementation implements WalletService {
    @Override
    public Optional<TpiTransactionSequenceDTOHLP> purchase(ExternalSystemIdHLP externalSystemIdHLP, CustomerHLP customerHLP, String transactionSequenceId, int stake) {
        return Optional.empty();
    }

    @Override
    public Optional<TpiTransactionSequenceDTOHLP> payout(ExternalSystemIdHLP externalSystemIdHLP, CustomerHLP customerHLP, String transactionSequenceId, int win) {
        return Optional.empty();
    }
}
