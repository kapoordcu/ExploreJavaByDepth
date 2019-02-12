package explore.topics.design.adaptor;

import java.util.Objects;

public class Customer {
    private String customerID;
    private String emToken;

    public Customer(String customerID, String emToken) {
        this.customerID = customerID;
        this.emToken = emToken;
    }
    public String getEmToken() {
        return emToken;
    }
}
