package explore.topics.design.factory;

public class WalletFactory {
    public static WalletType getWallet(Wallet wallet) {
        if (wallet == Wallet.TIPICO) {
            return new TipicoWallet();
        } else if (wallet == Wallet.PAYPAL) {
            return new PayPalWallet();
        } else if (wallet == Wallet.KLARNA) {
            return new KlarnaWallet();
        }
        return null;
    }
}
