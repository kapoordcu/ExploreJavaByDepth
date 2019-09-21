package explore.topics.ocp;

import java.util.Objects;

// Unable to access the internal structure
// Through methods on their own class.
// Private M.V and public methods
// benefits : allowing impl details of an object to be modified without breakinge existing clients
            // Protect an object's internal state
public class OCP1 {
    public static void main(String[] args) {
        Mt mt1 = new Mt(1);
        Mt mt2 = new Mt(2);
        System.out.println(mt1.equals(mt2));
    }
}

class Mt {
    public int number;

    public Mt(int number) {
        this.number = number;
    }


    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public boolean equals(Object o) {

        return true;
    }

    @Override
    public String toString() {
        return "Mt{" +
                "number=" + number +
                '}';
    }
}
