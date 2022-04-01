class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> g = new HashMap();
        for (int i = 0; i < values.length; i++) {
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            // if (g.containsKey(s1)) {
            //     g.get(s1).put(s2, values[i]);
            // }
            // else {
            //     HashMap<String, Double> hm = new HashMap();
            //     hm.put(s2, values[i]);
            //     g.put(s1, hm);
            // }
            if (!g.containsKey(s1)) {
                // HashMap<String, Double> hm = new HashMap();
                // g.put(s1, hm);
                g.put(s1, new HashMap<String, Double>());
            }
            g.get(s1).put(s2, values[i]);
            if (!g.containsKey(s2)) {
                g.put(s2, new HashMap<String, Double>());
            }
            g.get(s2).put(s1, 1/values[i]);
        }

        double[] res = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            // res[i] = bfs(queries.get(i), g);
            visited = new HashSet();
            res[i] = dfs(g, queries.get(i).get(0), queries.get(i).get(1));
        }

        return res;

    }

    private class State {
        public String s;
        public double d;

        public State() {}

        public State(String s, double d) {
            this.s = s;
            this.d = d;
        }
    }

    public double bfs(List<String> l, HashMap<String, HashMap<String, Double>> g) {
        if (!g.containsKey(l.get(0))) return -1;
        if (!g.containsKey(l.get(1))) return -1;

        Queue<State> q = new LinkedList();
        q.add(new State(l.get(0), 1));
        HashSet<String> visited = new HashSet();
        while (!q.isEmpty()) {
            // current node
            State cur = q.poll();
            if (cur.s.equals(l.get(1))) return cur.d;
            visited.add(cur.s);

            // add neighbour nodes to the queue
            HashMap<String, Double> hm = g.get(cur.s);
            for (String key : hm.keySet()) {
                if (!visited.contains(key))
                    q.add(new State(key, hm.get(key) * cur.d));
            }
        }
        return -1;
    }

    HashSet<String> visited = new HashSet();

    public double dfs(HashMap<String, HashMap<String, Double>> g, String start, String end) {
        if (!g.containsKey(start)) return -1;
        if (g.get(start).containsKey(end)) return g.get(start).get(end);
        visited.add(start);
        HashMap<String, Double> hm = g.get(start);
        for (String neighbour : hm.keySet()) {
            if (!visited.contains(neighbour)) {
                double t = dfs(g, neighbour, end);
                if (t != -1) return t * hm.get(neighbour);
            }
        }

        return -1;
    }

}





















