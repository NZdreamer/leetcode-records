import java.util.*;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        // tpological bfs
        int counter = 0;
        int[] res = new int[numCourses];
        while (!q.isEmpty()) {
            int node = q.poll();
            res[counter] = node;
            counter++;
            for (int i : graph[node]) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        return res;
    }
}
// @lc code=end
