package explore.topics.design.aFactory;

public class Application {
    public static void main(String[] args) {
        // Earlier
        Wallet walletVisa = new VISA();
        Wallet walletMC = new MasterCard();

        Wallet wallet = WalletFactory.getWallet("VISA") ; // This wont change, Although you may need to change WalletFactory
        wallet.purchase();
    }
}

interface Wallet {
    void purchase();
}

class VISA implements Wallet {
    @Override
    public void purchase() {
        System.out.println("VISA");
    }
}

class MasterCard implements Wallet {

    @Override
    public void purchase() {
        System.out.println("MasterCard");
    }
}

class WalletFactory {
    public static Wallet getWallet(String type) {
        Wallet wallet = null;
        if (type.equalsIgnoreCase(VISA.class.getSimpleName())) {
            wallet = new VISA();
        } else if (type.equalsIgnoreCase(MasterCard.class.getSimpleName())) {
            wallet =  new MasterCard();
        }
        return wallet;
    }
}