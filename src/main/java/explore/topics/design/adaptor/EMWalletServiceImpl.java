package explore.topics.design.adaptor;

import java.util.Optional;

public class EMWalletServiceImpl implements EMWalletService {
    @Override
    public Optional<TpiTransactionSequenceDTOHLP> emPurchase(ExternalSystemIdHLP externalSystemIdHLP, String emToken, String transactionSequenceId, int stake) {
        return Optional.of(new TpiTransactionSequenceDTOHLP(externalSystemIdHLP.name() + ":" + transactionSequenceId + "=" + emToken));
    }
}
