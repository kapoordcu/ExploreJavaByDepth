package explore.topics.design.adaptor;

import java.util.Objects;

public class CustomerHLP {
    private String emToken;

    public CustomerHLP(String emToken) {
        this.emToken = emToken;
    }

    public String getEmToken() {
        return emToken;
    }

    public void setEmToken(String emToken) {
        this.emToken = emToken;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerHLP customerHLP = (CustomerHLP) o;
        return Objects.equals(emToken, customerHLP.emToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emToken);
    }
}
