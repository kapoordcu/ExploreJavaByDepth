package explore.topics.design.aFactory;

public class KlarnaWallet implements Wallet {
    @Override
    public void purchaseAction() {
        System.out.println("Klarna wallet.");
    }
}
