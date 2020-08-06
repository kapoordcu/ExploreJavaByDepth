package explore.topics.design.aAdaptor;

public interface ThirdPartyI {
    String executePayment();
    boolean isBalancePositive();
    String payOut();
    boolean callWalletService();
}
