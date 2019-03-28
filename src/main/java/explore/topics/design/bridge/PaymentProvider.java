package explore.topics.design.bridge;

// Abstraction
public abstract class PaymentProvider {
    protected CardImpl card;

    public PaymentProvider(CardImpl card) {
        this.card = card;
    }

    abstract void whoIsPaymentProvoder();
}
