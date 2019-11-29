package explore.topics.design.aOCP.voilate;


import java.math.BigDecimal;

public class OpenCloseApp {


}

class InitTransaction {
    private static final Double COMMISSION_CHARGES_RATE = 1.1;

    public Double transact(Object[] transactions) {
        for (Object t: transactions) {
            if(t instanceof ElectronicTransaction) {
                return  ((ElectronicTransaction) t).getAmount();
            }
            if(t instanceof CashTransaction) {
                return ((ElectronicTransaction) t).getAmount()* COMMISSION_CHARGES_RATE;
            }

        }
        return Double.valueOf(0);
    }
}

// This is okay for 2 type of transactions, Imagine there is one more type of transaction ( Mobile )
// You should not be jumping to the code which is already being written, Open for extension and closed to modification
// Your client already using shipped code in the form of binaries

class ElectronicTransaction {
    private Double amount;
    public Double getAmount() {
        return amount;
    }
}

class CashTransaction {
    private Double amount;
    public BigDecimal getAmount() {
        return BigDecimal.valueOf(amount);
    }
}