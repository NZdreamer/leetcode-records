import java.util.HashSet;
import java.util.Set;

public class IMCFinancialOA1 {

    public boolean reachingPoints(int sx, int sy, int tx, int ty, int c) {
        Set<Integer> set = new HashSet<>();
        int k = 1;
        while (k * k <= tx + ty) {
            set.add(k * k);
        }
        if (sx > tx || sy > ty) return false;
        boolean[][] dp = new boolean[tx + 1][ty + 1];
        int i = sx;
        int j = sy;
        while (i <= tx) {
            dp[i][sy] = true;
            i += sy;
        }
        while (j <= ty) {
            dp[sx][j] = true;
            j += sx;
        }
        for (i = sx + 1; i < tx + 1; i++) {
            for (j = sy + 1; j < ty + 1; j++) {
                if (set.contains(i + j)) continue;
                if (j - i > 0) dp[i][j] = dp[i][j - i];
                else if (i - j > 0) dp[i][j] = dp[i - j][j];
                else dp[i][j] = dp[i][j - i] || dp[i - j][j];
                if (i - c > 0 && j - c > 0 && dp[i][j] == false) dp[i][j] = dp[i - c][j - c];
            }
        }
        return dp[tx][ty];
    }
}
