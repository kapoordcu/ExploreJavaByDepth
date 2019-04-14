package explore.topics.design.state;

public class BlockedAccount implements AccountState {
    @Override
    public void doTransaction(AccountContext accountContext, String transactionSequence) {
        System.out.println("Transaction cannot be performed since Account is blocked: " + transactionSequence);
    }
}
