package explore.topics.design.solid;

public class SRPApp {
    public static void main(String[] args) {
        WalletSRPSolved walletSRPSolved = new WalletSRPSolved("37898", "Tipico",
                new PaymentProvider("Paypal"));
        System.out.println(walletSRPSolved);
    }
}
/*
This principle states that if we have 2 reasons to change for a class, we have to split the functionality in two classes.
Each class will handle only one responsibility and if in the future we need to make one change we are going to make it in the class which handles it.
*/

class WalletSRPSolved {
    private String walletId;
    private String walletName;
    private PaymentProvider paymentprovider;

    public WalletSRPSolved(String walletId, String walletName, PaymentProvider paymentprovider) {
        this.walletId = walletId;
        this.walletName = walletName;
        this.paymentprovider = paymentprovider;
    }

    @Override
    public String toString() {
        return "WalletSRPSolved{" +
                "walletId='" + walletId + '\'' +
                ", walletName='" + walletName + '\'' +
                ", paymentprovider=" + paymentprovider +
                '}';
    }
}

class PaymentProvider {
    private String paymentprovider;

    public PaymentProvider(String paymentprovider) {
        this.paymentprovider = paymentprovider;
    }

    private boolean validatePaymentprovider(String paymentprovider) {
        // payment provider validate logic
        return true;
    }

    @Override
    public String toString() {
        return "PaymentProvider{" +
                "paymentprovider='" + paymentprovider + '\'' +
                '}';
    }
}
/*
PROBLEM
    this class should not include payment provider validation because that is not related with a Wallet behaviour
SOLUTION
    We can improve the class above by removing the responsibility of payment provider validation from the Wallet
    class and creating a new payment provider class that will have that responsibility:
*/
class WalletSRPBroken {
    private String walletId;
    private String walletName;
    private String paymentprovider;

    public WalletSRPBroken(String walletId, String walletName, String paymentprovider) {
        this.walletId = walletId;
        this.walletName = walletName;
        if(this.validatePaymentprovider(paymentprovider)) {
            this.paymentprovider = paymentprovider;
        }
        else {
            throw new Error("Invalid payment provider!");
        }
    }

    private boolean validatePaymentprovider(String paymentprovider) {
        // payment provider validate logic
        return true;
    }
}