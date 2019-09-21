package explore.topics.design.state;

public class ActiveAccount implements AccountState {
    @Override
    public void doTransaction(AccountContext accountContext, String transactionSequence) {
        System.out.println("Transaction is executed with transactionSequence: " + transactionSequence);
    }
}
