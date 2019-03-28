package explore.topics.design.bridge;

// refined Abstraction
public class SofortPaymentProvider extends PaymentProvider {

    public SofortPaymentProvider(CardImpl card) {
        super(card);
    }

    @Override
    public void whoIsPaymentProvoder() {
        card.addMoney(500l);
        System.out.println("Klarna added money into the account by " + card.getClass());
    }
}
