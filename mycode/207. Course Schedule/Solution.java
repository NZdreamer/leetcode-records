class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> g = new HashMap();
        int[] indegree = new int[numCourses];

        for (int i =0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int course = prerequisites[i][0];
            if (!g.containsKey(pre)) {
                g.put(pre, new ArrayList());
            }
            g.get(pre).add(course);
            indegree[course]++;
        }

        // System.out.println(g);

        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int pre = q.poll();
            count++;
            if (!g.containsKey(pre)) continue;
            for (int course : g.get(pre)) {
                indegree[course]--;
                if (indegree[course] == 0) q.add(course);
            }
            g.put(pre, new ArrayList());
        }

        return count == numCourses;
    }
}