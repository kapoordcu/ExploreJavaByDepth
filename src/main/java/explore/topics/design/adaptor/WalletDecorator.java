//package explore.topics.design.adaptor;
//
//import java.util.Optional;
//
//public class WalletDecorator implements Wallet {
//
//    private Wallet wallet;
//    private String paymentGateWay;
//
//    public WalletDecorator(Wallet wallet, String paymentGateWay) {
//        this.wallet = wallet;
//        this.paymentGateWay = paymentGateWay;
//    }
//
//    @Override
//    public Optional<TransactionSequence> purchase(WalletType walletType, Customer customer, String transactionSequenceId, int stake) {
//        return Optional.of(new TransactionSequence(walletType.name() + " with PG : " + paymentGateWay));
//    }
//}
