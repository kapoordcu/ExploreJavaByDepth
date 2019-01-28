package explore.topics.hackerrank;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SolutionTwo {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int _count = Integer.parseInt(in.nextLine());

        OutputCommonManager(_count, in);

    }

    static void OutputCommonManager(int count, Scanner in) {
        String employee = null;
        String firstEmployee = in.nextLine(); // Hillary
        String secondEmployee = in.nextLine();  // James

        Map<String, String> managerEmployeenMap = new LinkedHashMap<String, String>();
        Set<String> heirarchyManagerSet = new LinkedHashSet<String>();

        String[] emplyeeManagerArray;
        if(in.hasNextLine()) {
            employee = in.nextLine();
        }

        // Iterate Manager employee relationship
        while(!employee.isEmpty()){
            emplyeeManagerArray = employee.trim().split(" ");
            managerEmployeenMap.put(emplyeeManagerArray[1], emplyeeManagerArray[0]);
            if(in.hasNextLine()) {
                employee = in.nextLine();
            }
        }
        // Data saved in the hashmap for emplyee Manager Relationship
        heirarchyManagerSet.add(firstEmployee);
        employee = managerEmployeenMap.get(firstEmployee);
        while(employee!=null){
            heirarchyManagerSet.add(employee);
            employee = managerEmployeenMap.get(employee);
        }

        employee = secondEmployee;
        while(employee!=null){
            if(heirarchyManagerSet.contains(employee)){
                System.out.println("The common manager in the heirarchy : " + employee);
                break;
            }
            employee = managerEmployeenMap.get(employee);
        }

    }
}
