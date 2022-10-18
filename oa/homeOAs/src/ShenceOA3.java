
import java.util.*;

public class ShenceOA3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        int[] a = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] prices = new List[10001];
        for (int i = 0; i < prices.length; i++) {
            prices[i] =new ArrayList<>();
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.valueOf(strs[i]);
            map.put(a[i], i);
            prices[a[i]].add(i);
        }

        Arrays.sort(a);
//        int idx1 = n - 1;
//        int idx2 = n - 2;
        int dist = Math.abs(map.get(a[n - 1]) - map.get(a[n - 2]));
        int max = a[n - 1] + a[n - 2] - dist;

//        for (int i = n - 3; i >= 0; i--) {
////            int dist1 = Math.abs(map.get(a[i]) - map.get(idx1));
////            int dist2 = Math.abs(map.get(a[i]) - map.get(idx2));
//            for (int j = n - 1; j > i; j--) {
//                int curDist = Math.abs(map.get(a[i]) - map.get(a[j]));
//                if (curDist > dist) continue;
//                int res = a[i] + a[j] - curDist;
//                if (res > max) {
//                    max = res;
//                    dist = curDist;
//                }
//            }
//        }



        System.out.println(max);
    }
}
