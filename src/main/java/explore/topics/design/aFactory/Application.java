package explore.topics.design.aFactory;

public class Application {
    public static void main(String[] args) {
        // Earlier
        Wallet walletVisa = new VISA();
        Wallet walletMC = new MasterCard();

        Wallet wallet = WalletFactory.getWallet(WalletType.KLARNA) ; // This wont change, Although you may need to change WalletFactory
        wallet.purchase();
    }
}

enum WalletType {
    VISA, MASTERCARD, KLARNA, PAYPAL, NO_WALLET
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
        System.out.println("MASTERCARD");
    }
}

class NoWallet implements Wallet {
    @Override
    public void purchase() {
        System.out.println("NO_WALLET");
    }
}

class WalletFactory {
    public static Wallet getWallet(WalletType type) {
        Wallet wallet = new NoWallet();
        if (type == WalletType.VISA) {
            wallet = new VISA();
        } else if (type == WalletType.MASTERCARD) {
            wallet =  new MasterCard();
        }
        return wallet;
    }
}