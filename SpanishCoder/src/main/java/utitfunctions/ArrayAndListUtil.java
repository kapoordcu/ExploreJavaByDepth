package utitfunctions;

import model.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

public class ArrayAndListUtil {
    List<Employee> employeesList = List.of(
            new Employee("GK", 27, "IT", 70000),
            new Employee("HA", 34, "SOFTWARE", 56000),
            new Employee("RJ", 38, "IT", 60000),
            new Employee("PP", 28, "HR", 38000)
    );

    Map<UUID, Employee> employeesMap = Map.of(
            UUID.randomUUID(), new Employee("GK", 27, "IT", 70000),
            UUID.randomUUID(), new Employee("HA", 34, "SOFTWARE", 56000),
            UUID.randomUUID(), new Employee("RJ", 38, "IT", 60000),
            UUID.randomUUID(), new Employee("PP", 28, "HR", 38000)
    );

    public static void sortListByProperties(List<Employee> employeesList) {
        List<Employee> collect = employeesList.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .collect(Collectors.toList());
        collect.stream().map(s-> s.getAge()).forEach(System.out::println);
    }

    public static List<Integer> intArrayToList(int[] array) {
        return IntStream.of(array).boxed().collect(Collectors.toList());
    }

    public static List<String> stringArrayToList(String[] array) {
        return Arrays.asList(array);
    }

    public static int[] listToIntArray(List<Integer> arraylist) {
        return arraylist.stream().mapToInt(a -> a).toArray();
    }

    private static String[] listToStringArray(List<String> list) {
        return list.stream().toArray(String[]::new);
    }

    @Test
    public void testIntArrayToList() {
        int[] array = {8,3,0,2,5, 3};
        List<Integer> integers = ArrayAndListUtil.intArrayToList(array);
        assertTrue(integers.size()==array.length);
        assertTrue(integers.contains(0));
        assertTrue(integers.contains(2));
        assertTrue(integers.contains(3));
        assertTrue(integers.contains(5));
        assertTrue(integers.contains(8));
    }

    @Test
    public void testListToIntArray() {
        List<Integer> list = List.of(8,3,0,2,5, 3);
        int[] array = ArrayAndListUtil.listToIntArray(list);
        assertTrue(list.size()==array.length);
        for (int i = 0; i < array.length; i++) {
            assertTrue(list.contains(array[i]));
        }
    }

    @Test
    public void testStringArrayToList() {
        String[] array = {"hello", "ji", "how", "are", "you"};
        List<String> integers = ArrayAndListUtil.stringArrayToList(array);
        assertTrue(integers.size()==array.length);
        assertTrue(integers.contains("hello"));
        assertTrue(integers.contains("ji"));
        assertTrue(integers.contains("how"));
        assertTrue(integers.contains("are"));
        assertTrue(integers.contains("you"));
    }

    @Test
    public void testListToStringArray() {
        List<String> list = List.of("hello", "ji", "how", "are", "you");
        String[] strings = ArrayAndListUtil.listToStringArray(list);
        assertTrue(list.size()==strings.length);
        for (int i = 0; i < strings.length; i++) {
            assertTrue(list.contains(strings[i]));
        }
    }
}
