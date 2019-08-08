package explore.topics.design.aFactory;

public class Application {
    public static void main(String[] args) {
        Wallet wallet = FactoryWallet.getWallet("PaypalWallet") ; // This wont change, Although you may need to change FactoryWallet
        wallet.purchaseAction();
    }
}
