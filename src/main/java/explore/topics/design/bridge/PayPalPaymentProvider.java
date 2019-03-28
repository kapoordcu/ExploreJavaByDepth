package explore.topics.design.bridge;

// refined Abstraction
public class PayPalPaymentProvider extends PaymentProvider {

    public PayPalPaymentProvider(CardImpl card) {
        super(card);
    }

    @Override
    public void whoIsPaymentProvoder() {
        card.addMoney(200l);
        System.out.println("Paypal added money into the account by " + card.getClass());
    }
}
