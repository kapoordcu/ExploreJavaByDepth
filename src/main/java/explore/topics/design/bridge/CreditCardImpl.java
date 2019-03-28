package explore.topics.design.bridge;

public class CreditCardImpl implements CardImpl {
    @Override
    public void addMoney(Long cents) {
        System.out.println(cents + " cents added by Credit card");
    }
}
