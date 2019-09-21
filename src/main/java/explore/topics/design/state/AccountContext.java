package explore.topics.design.state;

public class AccountContext {
    private AccountState accountState;

    public AccountContext() {
        this.accountState = new BlockedAccount();
    }

    public AccountState getAccountState() {
        return accountState;
    }

    public void setAccountState(AccountState accountState) {
        this.accountState = accountState;
    }

    public void doTransaction(String transactionSequence) {
        accountState.doTransaction(this, transactionSequence);
    }
}
