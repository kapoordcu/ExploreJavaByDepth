package explore.topics.design.bridge;

public class DebitCardImpl implements CardImpl {
    @Override
    public void addMoney(Long cents) {
        System.out.println(cents + " cents added by Debit card");
    }
}
