import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        // build graph
        for (int[] req : prerequisites) {
            int pre = req[1];
            int cur = req[0];
            graph[pre].add(cur);
            indegree[cur]++;
        }
        // build indegree
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int counter = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            counter++;
            for (int i : graph[node]) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        return counter == numCourses;
    }
}
// @lc code=end

