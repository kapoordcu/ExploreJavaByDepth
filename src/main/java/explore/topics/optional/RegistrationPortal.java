package explore.topics.optional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegistrationPortal {
    private List<Student> studentList = Collections.emptyList();

    private static class MyWrapper {
        static RegistrationPortal INSTANCE = new RegistrationPortal();
    }

    private RegistrationPortal () {}

    public static RegistrationPortal getRegistrationPortal() {
        return MyWrapper.INSTANCE;
    }

    public void register(Student student) {
        studentList.add(student);
    }

    public List<Student> getRegisteredStudents() {
        return studentList;
    }
}
