package explore.topics.design.aDecorator;

import java.math.BigDecimal;

public class BaseSalary extends Salary {

    public BaseSalary() {
        super();
        this.description = "Category 1 minimum tax";
    }

    @Override
    public BigDecimal getTaxRate() {
        return new BigDecimal(30.00);
    }
}
