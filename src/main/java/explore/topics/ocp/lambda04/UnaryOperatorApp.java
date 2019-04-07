package explore.topics.ocp.lambda04;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryOperatorApp {
    public static void main(String[] args) {
// is a specialization of Function
        // suninterface of the Function so inherits alls members
        // abstract method T apply(T t);
        UnaryOperator<Double> operator = d -> d/2;
        Double apply = operator.apply((double) 1);
        System.out.println(apply);

        List<String> list = Arrays.asList("java");
        list.replaceAll(s-> s.toUpperCase());
        System.out.println(list.get(0));

    }
}
