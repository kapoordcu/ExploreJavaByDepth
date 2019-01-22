package explore.topics.design;

class Salary {
    private int salary;

    public Salary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}

class Person {
    public Salary getSalary() {
        return new Salary(15000);
    }
}

class Employee {
    private Person person = new Person();
    public int getSalary() {
        Salary salary = person.getSalary();
        return salary.getSalary();
    }
}

class InheritanceVersusComposition {
    public static void main(String[] args) {
        Employee employee = new Employee();
        int salary = employee.getSalary();
    }
}


//class Peel {
//    private int peelCount;
//    public Peel(int peelCount) {
//        this.peelCount = peelCount;
//    }
//    public int getPeelCount() {
//        return peelCount;
//    }
//    //...
//}
//
//class Fruit {
//    // Return int number of pieces of peel that
//    // resulted from the peeling activity.
//    public Peel peel() {
//        System.out.println("Peeling is appealing.");
//        return new Peel(1);
//    }
//}
//
//class Apple {
//    private Fruit fruit = new Fruit();
//    public int peel() {
//        Peel peel = fruit.peel();
//        return peel.getPeelCount();
//    }
//}
//
//class ComOvrInher {
//    public static void main(String[] args) {
//        Apple apple = new Apple();
//        System.out.println(apple.peel());
//    }
//}


//class Peel {
//    private int peelCount;
//    public Peel(int peelCount) {
//        this.peelCount = peelCount;
//    }
//    public int getPeelCount() {
//        return peelCount;
//    }
//    //...
//}
//
//class Fruit {
//    // Return int number of pieces of peel that
//    // resulted from the peeling activity.
//    public Peel peel() {
//        System.out.println("Peeling is appealing.");
//        return new Peel(1);
//    }
//}
//
//class Apple extends Fruit {
//}
//
//class ComOvrInher {
//    public static void main(String[] args) {
//        Apple apple = new Apple();
//        int pieces = apple.peel();
//    }
//}