import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {
            int course = q.poll();
            result[index++] = course;

            for (int next : graph[course]) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        if (index == numCourses) {
            return result;
        }

        return new int[0];
    }
}
