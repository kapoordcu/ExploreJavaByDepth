package explore.topics.design.aFactory;



public class FactoryWallet {

    public static Wallet getWallet(String type) {
        Wallet wallet = null;
        if (type.equalsIgnoreCase(KlarnaWallet.class.getSimpleName())) {
            wallet = new KlarnaWallet();
        } else if (type.equalsIgnoreCase(PaypalWallet.class.getSimpleName())) {
            wallet =  new PaypalWallet();
        } else if (type.equalsIgnoreCase(XYZWallet.class.getSimpleName())) {
            wallet =  new XYZWallet();
        }
        return wallet;
    }
}
