package explore.topics.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Amazon2 {
    public static void main(String[] args) {
        List<List<Integer>> pathInfoList = new ArrayList<List<Integer>>();
        pathInfoList.add(Arrays.asList(1, 0, 0));
        pathInfoList.add(Arrays.asList(1, 0, 0));
        pathInfoList.add(Arrays.asList(1, 9, 1));
        Amazon2 amazon2 = new Amazon2();

        amazon2.removeObstacle(3, 3, pathInfoList);

    }


    private int findObstacleFrequency(int numRows, int numColumns, List<List<Integer>> lot) {
        int totalObstacles = 0;
        int obstaclekey = 9;
        for(int i=0; i<lot.size(); i++){
            for (int j = 0; j < lot.get(i).size(); j++) {
                if(lot.get(i).get(j) == obstaclekey) {
                    totalObstacles++;
                }
            }
        }

        return totalObstacles;
    }

    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
        int totalObstacles = findObstacleFrequency(numRows, numColumns, lot);
        System.out.println(totalObstacles);
        int steps = findStepsToRemoveObstacle(numRows, numColumns, lot, totalObstacles);
        return steps;
    }

    private int findStepsToRemoveObstacle(int numRows, int numColumns, List<List<Integer>> lot, int totalObstacles) {
        int obstacleCount = 0;
        for(int i=0; i<lot.size(); i++){
            for (int j = 0; j < lot.get(i).size(); j++) {
                if(lot.get(i).get(j) == 9) {
                    obstacleCount++;
                    i++;
                    break;
                }
            }
        }
        return (obstacleCount!=-1) ? obstacleCount : -1;
    }
}
