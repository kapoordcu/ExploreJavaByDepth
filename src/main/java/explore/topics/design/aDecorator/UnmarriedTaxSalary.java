package explore.topics.design.aDecorator;

import java.math.BigDecimal;

public class UnmarriedTaxSalary extends SalaryAfterTax {
    private Salary salary;

    public UnmarriedTaxSalary(Salary salary) {
        this.salary = salary;
    }

    @Override
    public String getDescription() {
        return this.description + " + Unmarried class";
    }

    @Override
    public BigDecimal getTaxRate() {
        return (new BigDecimal(3.00).add(this.salary.getTaxRate()));
    }
}
