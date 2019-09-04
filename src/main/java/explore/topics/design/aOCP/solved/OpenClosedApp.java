package explore.topics.design.aOCP.solved;

public class OpenClosedApp {

    public void transact(Transaction[] transactions) {
        for (Transaction t: transactions) {
            t.transactCommit();
        }
    }
}

abstract class Transaction {
    public abstract String transactCommit();
}

class Electronic extends Transaction {
    private String currency;
    private Double amount;

    public String getCurrency() {
        return currency;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String transactCommit() {
        return String.valueOf(amount).concat(currency);
    }
}

class Cash extends Transaction {
    private String currency;
    private Double amount;

    public String getCurrency() {
        return currency;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String transactCommit() {
        return String.valueOf(amount*1.10).concat(currency);
    }
}