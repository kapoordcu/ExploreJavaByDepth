package explore.topics.design.factory;


public class FactoryAppVoilated {
    private WalletType wallet;

    public FactoryAppVoilated(int type) {
        if (type == 1)
            wallet = new TipicoWallet();
        else if (type == 2)
            wallet = new PayPalWallet();
        else
            wallet = null;
    }
    public static void main(String[] args) {
        FactoryAppVoilated factoryApp = new FactoryAppVoilated(2);
        System.out.println(factoryApp.wallet.purchase("4932be6a-764d-4d65", 200));
    }
}
