package explore.topics.design.aFactory.af;

public class Application {
    public static void main(String[] args) {
        WalletAbstractFactory producer = FactoryProducer.getFactory(true);
        producer.getWalletFactory(WalletType.VISA).purchase();
        producer.getWalletFactory(WalletType.MASTERCARD).purchase();

        producer = FactoryProducer.getFactory(false);
        producer.getWalletFactory(WalletType.VISA).purchase();
        producer.getWalletFactory(WalletType.MASTERCARD).purchase();
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

class MasterDomestic implements Wallet {
    @Override
    public void purchase() {
        System.out.println("MASTERCARD Domestic");
    }
}

class VISAInternational implements Wallet {
    @Override
    public void purchase() {
        System.out.println("International VISA");
    }
}

class NoWallet implements Wallet {
    @Override
    public void purchase() {
        System.out.println("NO_WALLET");
    }
}

abstract class WalletAbstractFactory {
    abstract Wallet getWalletFactory(WalletType walletType) ;
}

class WalletFactory extends WalletAbstractFactory {
    @Override
    Wallet getWalletFactory(WalletType walletType) {
        if(walletType==WalletType.VISA){
            return new VISA();
        }else if(walletType==WalletType.MASTERCARD){
            return new MasterCard();
        }
        return new NoWallet();
    }
}

class InternationalWalletFactory extends WalletAbstractFactory {
    @Override
    Wallet getWalletFactory(WalletType walletType) {
        if(walletType==WalletType.VISA){
            return new VISAInternational();
        }else if(walletType==WalletType.MASTERCARD){
            return new MasterDomestic();
        }
        return new NoWallet();
    }
}

class FactoryProducer {
    public static WalletAbstractFactory getFactory(boolean international){
        if(international){
            return new InternationalWalletFactory();
        }else{
            return new WalletFactory();
        }
    }
}