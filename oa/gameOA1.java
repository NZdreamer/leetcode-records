public class gameOA1 {
    public int[][] solution(int[][] bubbles) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int n = bubbles.length;
        int m = bubbles[0].length;
        int[][] visited = new int[n][m];    // 1: vistied, -1: explode

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[n][m] == 0) {
                    int cur = bubbles[i][j];
                    int cnt = 0;
                    for (int[] dir : dirs) {
                        int dx = dir[0];
                        int dy = dir[1];
                        if (cur == bubbles[i + dx][j + dy]) {
                            cnt++;
                            visited[i + dx][j + dy] = 1;
                        }
                    }
                    if (cnt >= 3) {
                        for (int[] dir : dirs) {
                            int dx = dir[0];
                            int dy = dir[1];
                            if (cur == bubbles[i + dx][j + dy]) {
                                cnt++;
                                visited[i + dx][j + dx] = -1;
                            }
                        }
                    }
                }
            }
        }

        // explode
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == -1) {
                    bubbles[i][j] = 0;
                }
            }
        }

        // drop
        for (int j = 0; j < m; j++) {
            int k = n - 1;
            for (int i = n - 1; i >= 0; i--) {               
                if (bubbles[i][j] > 0) {
                    int tmp = bubbles[i][j];
                    bubbles[i][j] = bubbles[k][j];
                    bubbles[k][j] = tmp;
                    k--;
                }
            }
        }
        return bubbles;
    }
}
