package explore.topics.design.bridge;

import explore.topics.design.adaptor.WalletService;

// refined Abstraction
public class PayPalMoneyToWallet extends AddMoneyToWallet {

    public PayPalMoneyToWallet(WalletService wallet) {
        super(wallet);
    }

    @Override
    public void addMoney(Long cents) {
        System.out.println("Paypal added " + cents + " cents into the account.");
    }
}
