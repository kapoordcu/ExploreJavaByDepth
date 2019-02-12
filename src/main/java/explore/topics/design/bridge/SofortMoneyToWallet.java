package explore.topics.design.bridge;

import explore.topics.design.adaptor.Wallet;

// // refined Abstraction
public class SofortMoneyToWallet extends MoneyToWallet {

    public SofortMoneyToWallet(Wallet wallet) {
        super(wallet);
    }

    @Override
    public void addMoney(Long cents) {
        System.out.println("Sofort(Klarna) added " + cents + " cents into the account.");
    }
}
