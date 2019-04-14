package explore.topics.design.state;

public interface AccountState {
    void doTransaction(AccountContext accountContext, String transactionSequence);
}
