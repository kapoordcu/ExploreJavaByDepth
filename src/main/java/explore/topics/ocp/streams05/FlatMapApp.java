package explore.topics.ocp.streams05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
The flatMap method returns a stream containing of the results of replacing each element of the original stream with the contents of the mapped
stream produced by applying the provided mapping function to that element
if mapping function produces a null value, such a value is replace with empty streams

One to Many transformatoion on different streams of same type , Flattening all elements of all individual streams to a single syream



   <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper); Intermediate operation

   premitive type

   IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper);
    LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper);
   DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper);

   all above 3 returns a priitive stream , instead of generic one
*/
public class FlatMapApp {
    public static void main(String[] args) {
        StudentFlat henry = new StudentFlat("Henry", 90);
        StudentFlat bella = new StudentFlat("Bella", 80);
        StudentFlat dylan = new StudentFlat("Dylan", 75);
        StudentFlat riley = new StudentFlat("Riley", 70);

        CourseFlat oca = new CourseFlat("OCA");
        CourseFlat ocp = new CourseFlat("OCP");
        oca.addStudent(bella);oca.addStudent(dylan);
        ocp.addStudent(henry);ocp.addStudent(riley);

        List<CourseFlat> courseFlats = Arrays.asList(oca, ocp);
        Stream<StudentFlat> studentByCourse = courseFlats.stream().flatMap(c -> c.getStudents().stream());
        studentByCourse.forEach(s-> System.out.println(s.getName()));

        IntStream marks = courseFlats.stream().flatMapToInt(c-> c.getStudents().stream().mapToInt(StudentFlat::getMark));
        marks.forEach(System.out::println);
    }
}

class CourseFlat {
    private String name;
    private List<StudentFlat> students = new ArrayList<>();

    public CourseFlat(String name) {
        this.name = name;
    }

    public void addStudent(StudentFlat student) {
        this.students.add(student);
    }

    public String getName() {
        return name;
    }

    public List<StudentFlat> getStudents() {
        return students;
    }
}

class StudentFlat {
    private String name;
    private int mark;

    public StudentFlat(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }
}