package explore.topics.design.aDecorator;

import java.math.BigDecimal;

public abstract class Salary {
    public String description;

    public String getDescription() {
        return description;
    }

    public abstract BigDecimal getTaxRate();
}
