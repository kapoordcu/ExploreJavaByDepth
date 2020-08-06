package explore.topics.design.aAdaptor;

public class ThirdPartyImpl implements ThirdPartyI {
    @Override
    public String executePayment() {
        return "payment executed from ThirdParty";
    }

    @Override
    public boolean isBalancePositive() {
        return true;
    }

    @Override
    public String payOut() {
        return "payout from ThirdParty";
    }

    @Override
    public boolean callWalletService() {
        return true;
    }
}
