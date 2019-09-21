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
        //        6
        //        Hilary
        //        James
        //        Sarah Fred
        //        Sarah Paul
        //        Fred Hilary
        //        Fred Jenny
        //        Jenny James
    }

    static void OutputCommonManager(int count, Scanner in) {
        Long start = System.currentTimeMillis();
        String employee = null;
        String firstEmployee = in.nextLine(); // Hillary
        String secondEmployee = in.nextLine();  // James

        Map<String, String> managerEmployeenMap = new LinkedHashMap<String, String>();
        Set<String> heirarchyManagerSet = new LinkedHashSet<String>();

        // Iterate Manager employee relationship
        while(in.hasNextLine()) {
            String relationshipEmployeeManager = in.nextLine();
            String[] tokens = relationshipEmployeeManager.trim().split(" ");
            try {
                managerEmployeenMap.put(tokens[1], tokens[0]);
            } catch(Exception ex) {
                if("".equalsIgnoreCase(tokens[0])) {
                    System.out.println("line management relations saved in the format EmployeeX EmployeeY");
                } else if(tokens.length < 2) {
                    System.out.println("Please provide line management relations in the format EmployeeX EmployeeY, The program execution ends when you enter new line");
                }
                break;
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
