package explore.topics.design.factory;


public class FactoryAppSolved {
//    private WalletType wallet;
//
//    public FactoryAppSolved(int type) {
//        if (type == 1)
//            wallet = new TipicoWallet();
//        else if (type == 2)
//            wallet = new PayPalWallet();
//        else
//            wallet = null;
//    }
    public static void main(String[] args) {
        System.out.println(WalletFactory.getWallet(Wallet.KLARNA).purchase("4932be6a-764d-4d65", 200));
    }
}
