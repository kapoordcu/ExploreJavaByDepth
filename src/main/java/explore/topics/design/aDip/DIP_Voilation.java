package explore.topics.design.aDip;

/*
    Dependency Inversion Principle is primarily about reversing the conventional direction of dependencies from "higher level" components to "lower level"
    components such that "lower level" components are dependent upon the interfaces owned by the "higher level" components.
*/

//        High-level modules should not depend on low-level modules. Both should depend on abstractions.
//
//        Abstractions should not depend on details. Details should depend on abstractions.

//          Here high level modules own the abstraction (for example, deciding the methods of the interface)
//          which are implemented by lower level modules. Thus making lower level modules dependent on higher level modules.

/*What are the high-level modules and low level? Thinking modules such as libraries or packages,
high-level module would be those that traditionally have dependencies and low level on which they depend.
In other words, module high level would be where the action is invoked and low level where the action is performed.*/

public class DIP_Voilation {
    public static void main(String[] args) {
        Project project = new Project(new FrontEndDeveloper(), new BackEndDeveloper());
        project.makeApplication();
    }
}

class FrontEndDeveloper {
    public void writeJavaScript() {
        System.out.println("javascript code written by: " + FrontEndDeveloper.class.getName());
    }
}

class BackEndDeveloper {
    public void writeJava() {
        System.out.println("Java 8 code written by: " + BackEndDeveloper.class.getName());
    }
}

class Project {
//   The Project class is a high-level module,
//    and it depends on low-level modules such as BackEndDeveloper and FrontEndDeveloper.
//    We are actually violating the first part of the dependency inversion principle.
    FrontEndDeveloper fe;
    BackEndDeveloper be;
    // What if a new full stack developer join



    public Project(FrontEndDeveloper front, BackEndDeveloper back) {
        this.fe = front;
        this.be = back;
    }

//   methods writeJava and writeJavascript are methods bound to the corresponding
//   classes. those are details since
//   Thus, the second part of the dependency inversion principle is violated
    public void makeApplication() {
        fe.writeJavaScript();
        be.writeJava();
    }
}

/*



*/