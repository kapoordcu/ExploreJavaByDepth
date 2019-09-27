package explore.topics.design.aOCP.solved;

public class OpenClosedApp {
    public void transact(Transaction[] transactions) {
        for (Transaction t: transactions) {
            t.transactCommit();
        }
    }
}

interface Transaction {
    Double COMMISSION_CHARGES_RATE = 1.1;
    Double transactCommit();
}

class ElectronicTransaction implements Transaction{
    private Double amount;
    public Double getAmount() {
        return amount;
    }

    @Override
    public Double transactCommit() {
        return amount;
    }
}

class CashTransaction implements Transaction{
    private Double amount;

    @Override
    public Double transactCommit() {
        return Double.valueOf(amount*COMMISSION_CHARGES_RATE);
    }
}