package chap12_Graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites.length == 0) return true; // As there are no pre requisite

        // if there are prerequisite
        // create a dependency graph (prerequisiste graph)

        List<List<Integer>> courses = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<Integer>());
        }

        // graph bi -> ai
        for(int i = 0; i < prerequisites.length; i++) {
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // this array is to track the visited ones
        int[] visited = new int[numCourses];

        // visit each course using dfs and is there is a cycle return false
        // cycle means you can't complete the prerequisite

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(courses, visited, i)) return false;
        }

        return true;

    }

    // dfs function
    public boolean dfs(List<List<Integer>> courses, int[] visited, int course) {
        visited[course] = 1; // mark the current node as visited

        // traverse all its adjacent and unmarked node and
        // call recursive function with index of adjacent node

        List<Integer> eligibleCourses = courses.get(course);

        for(int i = 0; i < eligibleCourses.size(); i++) {
            int eligibleCourse = eligibleCourses.get(i);

            // we are visiting it again which means cycle
            if(visited[eligibleCourse] == 1) return false;

            if(visited[eligibleCourse] == 0) {
                if(!dfs(courses, visited, eligibleCourse)) return false;
            }
        }

        visited[course] = 2; // done
        return true;
    }
}
