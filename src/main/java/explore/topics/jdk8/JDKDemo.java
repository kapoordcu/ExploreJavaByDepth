package explore.topics.jdk8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JDKDemo {
    public static void main(String[] args) {
        JDKDemo demo = new JDKDemo();

        List<EmployeeDAO> employees = demo.createEmployees();

        Map<String, EmployeeDAO> employeeMap = demo.createListToMapJava8(employees);

    }

    private Map<String, EmployeeDAO> createListToMapJava8(List<EmployeeDAO> employees) {
        //Way 2
        return employees.stream()
                .collect(Collectors.toMap(emp -> emp.name, emp -> emp));
    }

    private List<EmployeeDAO> createEmployees() {
        return List.of(new EmployeeDAO("John", "Dao", new Address("Volmannstrass", "Munich", 81925)),
                new EmployeeDAO("Fride", "Gauck", new Address("Sendlinger", "Germany", 80331)),
                new EmployeeDAO("Crow", "James", new Address("Mullerstr", "Berlin", 80301)),
                new EmployeeDAO("Crawdrdk", "Gest", new Address("Feldkirchend str", "Hamburg", 78902)),
                new EmployeeDAO("Meast", "Nomi", new Address("Rosenheimer sr", "Munich", 89056))

        );
    }
}
