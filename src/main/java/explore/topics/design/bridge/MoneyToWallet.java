package explore.topics.design.bridge;

import explore.topics.design.adaptor.Wallet;

// Abstraction
public abstract class MoneyToWallet {
    Wallet wallet;

    public MoneyToWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public MoneyToWallet() {}

    abstract void addMoney(Long cents);
}
