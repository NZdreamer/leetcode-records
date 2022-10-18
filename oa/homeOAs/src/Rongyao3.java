import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rongyao3 {
    public static int maxSheep = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < T; i++){
            int S = sc.nextInt();
            int n = sc.nextInt();
            int a = sc.nextInt();
            int[] v = new int[n];
            for(int j = 0; j < n; j++){
                v[j] = sc.nextInt();
            }
            maxSheep = -1;
            dfs(false, S, 0, 0, a, v, n);
            res.add(maxSheep);
        }
        for(int i : res) System.out.println(i);
    }

    public static void dfs(boolean flag, int totalSheep, int totalVi, int day, int a, int[] v, int n){
        if(totalVi >= totalSheep)
        {
            if (totalSheep > maxSheep) maxSheep = totalSheep;
            return;
        }
        else if(day == n) return;
        if(flag == false){
            dfs(true, totalSheep - 2 * a, totalVi + v[day] * 2, day + 1, a, v, n);
            dfs(false, totalSheep - a, totalVi + v[day], day + 1, a, v, n);
        }
        else{
            dfs(false, totalSheep - a, totalVi + v[day], day + 1, a, v, n);
        }
    }

}