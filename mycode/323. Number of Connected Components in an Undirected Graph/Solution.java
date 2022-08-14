class Solution {
    
    class UnionFind {
        private int[] parents;
        private int count;
        
        public UnionFind(int n) {
            parents = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }
        
            // find root of a node, while make
        public int find(int node) {
            if (parents[node] != node) {
                parents[node] = find(parents[node]); // find root and attach node to root recursively;
            }
            return parents[node];
            // int root = find(parent[node]);
            // while (root != node) {
            //     root = parent[root];
            // }
            // return root;
        }

        // public int find(int id) {
        //     int oid = id;
        //     while(parents[id] != id) id = parents[id];
        //     parents[oid] = id;  // path compression
        //     return id;
        // }

        public void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 == root2) return;
            parents[root2] = root1;
            count--;
        }
        
        public int count() {
            return count;
        }
    }
    
    
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.count();
    }
    

    
    
}