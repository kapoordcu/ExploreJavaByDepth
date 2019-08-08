package explore.topics.design.aFactory;

public class PaypalWallet implements Wallet {
    @Override
    public void purchaseAction() {
        System.out.println("Paypal wallet.");
    }
}
