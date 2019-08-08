package explore.topics.design.aFactory;

public class VoilatedApp {
    public static void main(String[] args) {
        Wallet walletType = new KlarnaWallet();  // Problem, Client knows which classes you are working with
        walletType.purchaseAction();
    }
}
