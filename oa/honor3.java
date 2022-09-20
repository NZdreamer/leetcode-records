import java.util.*;

public class honor3 {
    public static int maxSheep = -1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int S = scanner.nextInt();
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int[] v= new int[n];
            for (int j = 0; j < n; j++) {
                v[j] = scanner.nextInt();
            }
            maxSheep = -1;
            dfs(false, S, 0, 0, S, a, v, n);
            res.add(maxSheep);
        }
        for (int i : res) System.out.println(i);
    }

    public static void dfs(boolean flag, int totalSheep, int totalVi, int day, int S, int a, int[] v, int n) {
        if (totalVi >= totalSheep) {
            if (totalSheep > maxSheep) maxSheep = totalSheep;
            return;
        }
        else if (day == n) {
            return;
        }
        if (flag == false) {
            dfs(true, totalSheep - 2 * a, totalVi + v[day] * 2, day + 1, S, a, v, n);
            dfs(false, totalSheep - a, totalVi + v[day], day + 1, S, a, v, n);
        }
        else {
            dfs(false, totalSheep - a, totalVi + v[day], day + 1, S, a, v, n);
        }
    }
    
}
