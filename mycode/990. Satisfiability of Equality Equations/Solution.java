class Solution {
    class UnionFind {
        public int[] roots;
        
        public UnionFind(int cap) {
            roots = new int[cap];
            for (int i = 0; i < cap; i++) {
                roots[i] = i;
            }
        }
        
        public int find(int i) {
            // iteration to find the root and set every root of element on the path as the root 
            // while (roots[i] != i) {
            //     roots[i] = roots[roots[i]];
            //     i = roots[i];
            // }

            // recursion to find the root and set every root of element on the path as the root 
            if (roots[i] != i) {
                roots[i] = find(roots[i]);
            }
            return roots[i];
        }
        
        public void union(int i, int j) {
            int r1 = find(i);
            int r2 = find(j);
            if (r1 != r2) {
                roots[r1] = roots[r2];
            }
        }
        
        public boolean isUnioned(int i, int j) {
            int r1 = find(i);
            int r2 = find(j);
            return r1 == r2;
        }
    }
    
    
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for (String eq : equations) {
            int v1 = eq.charAt(0) - 'a';
            int v2 = eq.charAt(3) - 'a';
            if (eq.charAt(1) == '=') {
                uf.union(v1, v2);
            }
        }
        for (String eq : equations) {
            int v1 = eq.charAt(0) - 'a';
            int v2 = eq.charAt(3) - 'a';
            if (eq.charAt(1) == '!') {
                if (uf.isUnioned(v1, v2)) return false;
            }
        }
        return true;
    }
}