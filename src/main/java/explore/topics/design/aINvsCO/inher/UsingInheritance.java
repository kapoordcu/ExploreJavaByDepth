package explore.topics.design.aINvsCO.inher;
/*

Disadvantages:-

        Inherited functions work slower than normal function as there is indirection.
        Improper use of inheritance may lead to wrong solutions.
        Often, data members in the base class are left unused which may lead to memory wastage.
        Inheritance increases the coupling between base class and derived class. A change in base class will affect all the child classes.
        Another problem with class inheritance is that the implementation inherited from a parent class cannot be changed at run-time.

Advantages:

        Inheritance promotes reusability. When a class inherits or derives another class, it can access all the functionality of inherited class.
        Reusability enhanced reliability. The base class code will be already tested and debugged.
        As the existing code is reused, it leads to less development and maintenance costs.
        Inheritance makes the sub classes follow a standard interface.
        Inheritance helps to reduce code redundancy and supports code extensibility.
        Inheritance facilitates creation of class libraries.
*/
// Inheritance breaking encapsulation?
//
class UsingInheritance {
    public static void main(String[] args) {
        BackendDeveloper backendDeveloper = new BackendDeveloper();
        /* BROKEN if the return type of getSkillsCount changes */
        int skillsCount = backendDeveloper.getSkillsCount();
    }
}

class Developer {
    public int getSkillsCount() {
        System.out.println("Technologies are appealing.");
        return 3;
    }
    // Now getSkillsCount returns Technologies , NOT int
//    public Technologies getSkillsCount() {
//        System.out.println("Technologies are appealing.");
//        return new Technologies(5);
//    }
}

class BackendDeveloper extends Developer {

}

class Technologies {
    private int skillsCount;
    public Technologies(int knownCount) {
        this.skillsCount = knownCount;
    }
    public int getSkillsCount() {
        return skillsCount;
    }
}