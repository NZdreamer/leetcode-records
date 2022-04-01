class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new LinkedList();

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] vp = new boolean[n][m];
        boolean[][] va = new boolean[n][m];
        Queue<int[]> pq = new LinkedList();
        Queue<int[]> aq = new LinkedList();

        for (int i = 0; i < n; i++) {
            pq.add(new int[]{i, 0});
            aq.add(new int[]{i, m-1});
            vp[i][0] = true;
            va[i][m  -1] = true;
        }
        for (int i = 0; i < m; i++) {
            pq.add(new int[]{0, i});
            aq.add(new int[]{n - 1, i});
            vp[0][i] = true;
            va[n - 1][i] = true;
        }

        int[][] dir = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

        bfs(heights, pq, vp, dir);
        bfs(heights, aq, va, dir);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vp[i][j] && va[i][j]) {
                    List<Integer> tmp = Arrays.asList(i, j);
                    res.add(tmp);
                }
            }
        }
        return res;
    }

    public void bfs(int[][] heights, Queue<int[]> q, boolean[][] v, int[][] dir) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dir) {
                int row = cur[0] + d[0];
                int col = cur[1] + d[1];
                if (row >= 0 && row < heights.length && col >= 0 && col < heights[0].length
                        && !v[row][col] && heights[cur[0]][cur[1]] <= heights[row][col]) {
                    v[row][col] = true;
                    q.add(new int[]{row, col});

                }
            }

        }
    }
}

