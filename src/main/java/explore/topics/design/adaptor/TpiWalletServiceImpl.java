package explore.topics.design.adaptor;

import java.util.Optional;

public class TpiWalletServiceImpl implements TpiWalletService {
    @Override
    public Optional<TpiTransactionSequenceDTOHLP> purchase(ExternalSystemIdHLP externalSystemIdHLP, CustomerHLP customerHLP, String transactionSequenceId, int stake) {
        return Optional.of(new TpiTransactionSequenceDTOHLP(externalSystemIdHLP.name() + "=" + transactionSequenceId));
    }
}
