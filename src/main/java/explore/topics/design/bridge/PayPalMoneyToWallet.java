package explore.topics.design.bridge;

import explore.topics.design.adaptor.Wallet;

// refined Abstraction
public class PayPalMoneyToWallet extends MoneyToWallet {

    public PayPalMoneyToWallet(Wallet wallet) {
        super(wallet);
    }

    @Override
    public void addMoney(Long cents) {
        System.out.println("Paypal added " + cents + " cents into the account.");
    }
}
