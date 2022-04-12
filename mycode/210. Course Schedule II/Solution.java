class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //List<Integer>[] g = new List[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList());
        }
        for (int[] e : prerequisites) {
            adjacency.get(e[1]).add(e[0]);
            indegree[e[0]]++;
        }        
        
        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < adjacency.size(); i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        //List<Integer> res = new LinkedList();
        int[] res = new int[numCourses];
        int j = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            //res.add(cur);
            res[j] = cur;
            j++;
            List<Integer> posts = adjacency.get(cur);
            for (int i = 0; i < posts.size(); i++) {
                indegree[posts.get(i)]--;
                if (indegree[posts.get(i)] == 0) {
                    q.offer(posts.get(i));                    
                }
            }
        }
        
        if (j < numCourses) return new int[0];
        return res;
        
//         int[] ret = new int[res.size()];
//         for (int i = 0; i < res.size(); i++) {
//             ret[i] = res.get(i);
//         }
        
//         return ret;
    }
}