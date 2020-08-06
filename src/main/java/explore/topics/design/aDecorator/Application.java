package explore.topics.design.aDecorator;

public class Application {
    public static void main(String[] args) {
        Salary salary = new BaseSalary();
        System.out.println(salary.getDescription());
        System.out.println(salary.getTaxRate());

        UnmarriedTaxSalary singleTaxation = new UnmarriedTaxSalary(salary);
        System.out.println(singleTaxation.getDescription());
        System.out.println(singleTaxation.getTaxRate());

        UnmarriedTaxSalary doubleTaxation = new UnmarriedTaxSalary(singleTaxation);
        System.out.println(doubleTaxation.getDescription());
        System.out.println(doubleTaxation.getTaxRate());
    }
}
