package graphs;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> preList = preMap.getOrDefault(prerequisites[i][0], new ArrayList<>());
            preList.add(prerequisites[i][1]);
            preMap.put(prerequisites[i][0], preList);
        }
        for (int i = 0; i < numCourses; i++) {
            if(!preMap.containsKey(i)) {
                preMap.put(i, new ArrayList<>());
            }
        }
        Set<Integer> visitSet = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if(dfs(i, preMap, visitSet)) {
                return true;
            } else {
                break;
            }
        }
        return false;

    }

    private boolean dfs(int course, Map<Integer, List<Integer>> preMap, Set<Integer> visitSet) {
        if(visitSet.contains(course)) {
            return false;
        }
        if(preMap.get(course).isEmpty()) {
            return true;
        }
        visitSet.add(course);
        for (Integer prereqCourse:         preMap.get(course)) {
            if(!dfs(prereqCourse, preMap, visitSet)) {
                return false;
            }
            visitSet.remove(prereqCourse);
            preMap.put(prereqCourse, new ArrayList<>());
            return true;
        }
        return false;
    }

    @Test
    public void test01() {
        int[][] pre = {{0,1}, {0,2}, {1,3 },{1,4}, {3, 4}};
        assertTrue(canFinish(5, pre));
    }

    @Test
    public void test02() {
        int[][] pre = {{0,1}, {1, 0}};
        assertFalse(canFinish(2, pre));
    }
}
