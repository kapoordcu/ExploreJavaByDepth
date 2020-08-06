package explore.topics.design.aAdaptor;

public class AdaptorGlue implements LocalInterface {
    private final ThirdPartyI thirdPartyI;

    public AdaptorGlue(ThirdPartyI thirdPartyI) {
        this.thirdPartyI = thirdPartyI;
    }

    @Override
    public String executePayment() {
        return thirdPartyI.executePayment();
    }

    @Override
    public boolean isBalancePositive() {
        thirdPartyI.payOut();
        thirdPartyI.callWalletService();
        return thirdPartyI.isBalancePositive();
    }

    public static void main(String[] args) {
        ThirdPartyI thirdPartyI = new ThirdPartyImpl();
        LocalInterface local = new AdaptorGlue(thirdPartyI);
        thirdPartyI.callWalletService();
    }
}
