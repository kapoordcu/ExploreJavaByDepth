package explore.topics.design.aOCP.voilate;


public class OpenCloseApp {
    String payout = "";
    Double EXTTRAS = 1.1;
    public void transact(Object[] transactions) {
        for (Object t: transactions) {
            if(t instanceof ElectronicTransaction) {
                payout += ((ElectronicTransaction) t).getAmount() + ((ElectronicTransaction) t).getCurrency();
            }
            if(t instanceof CashTransaction) {
                payout += ((ElectronicTransaction) t).getAmount()*EXTTRAS + ((ElectronicTransaction) t).getCurrency();
            }

        }
    }
}
// This is okay for 2 type of transactions, Imagine there is one more type of transaction ( Mobile )
// You should not be jumping to the code which is already being written, Open for extension and closed to modification
// Your client already using shipped code in the form of binaries

class ElectronicTransaction {
    private String currency;
    private Double amount;

    public String getCurrency() {
        return currency;
    }

    public Double getAmount() {
        return amount;
    }
}

class CashTransaction {
    private String currency;
    private Double amount;

    public String getCurrency() {
        return currency;
    }

    public Double getAmount() {
        return amount;
    }
}