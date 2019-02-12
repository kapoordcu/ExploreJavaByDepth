package explore.topics.design.bridge;

import explore.topics.design.adaptor.WalletService;

// Abstraction
public abstract class AddMoneyToWallet {
    WalletService wallet;

    public AddMoneyToWallet(WalletService wallet) {
        this.wallet = wallet;
    }

    public AddMoneyToWallet() {}

    abstract void addMoney(Long cents);
}
