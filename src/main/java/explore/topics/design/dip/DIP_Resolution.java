package explore.topics.design.dip;

import java.util.Arrays;
import java.util.List;

public class DIP_Resolution {
    public static void main(String[] args) {
        List<Developer> developers = Arrays.asList(new BackEndDeveloper_1(), new FrontEndDeveloper_1());
        Project_1 project = new Project_1(developers);
        project.makeApplication();
    }
}

interface Developer {
    void develop();
}

class BackEndDeveloper_1 implements Developer {

    @Override
    public void develop() {
        writeJava();
    }

    public void writeJava() {
        System.out.println("Java 8 code written by: " + explore.topics.design.dip.BackEndDeveloper.class.getName());
    }
}

class FrontEndDeveloper_1 implements Developer {
    @Override
    public void develop() {
        writeJavaScript();
    }

    public void writeJavaScript() {
        System.out.println("javascript code written by: " + explore.topics.design.dip.FrontEndDeveloper.class.getName());
    }
}

class Project_1 {
    List<Developer> developerList;

    public Project_1(List<Developer> developerList) {
        this.developerList = developerList;
    }

    public void makeApplication() {
        developerList.forEach(d -> d.develop());
    }
}


/*
        The outcome is that the Project class does not depend on lower level modules, but rather abstractions.
        Also, low-level modules and their details depend on abstractions.
*/
