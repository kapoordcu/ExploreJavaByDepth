package explore.topics.design.bridge;

import explore.topics.design.adaptor.WalletService;

// // refined Abstraction
public class SofortMoneyToWallet extends AddMoneyToWallet {

    public SofortMoneyToWallet(WalletService wallet) {
        super(wallet);
    }

    @Override
    public void addMoney(Long cents) {
        System.out.println("Sofort(Klarna) added " + cents + " cents into the account.");
    }
}
