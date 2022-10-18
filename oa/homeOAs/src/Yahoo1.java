import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Yahoo1 {

    public static void main(String[] args) {

        List<Integer> q1 = new ArrayList<>(Arrays.asList(2, 1));
        List<Integer> q2 = new ArrayList<>(Arrays.asList(2, 3));
        List<List<Integer>> queries = new ArrayList<>(Arrays.asList(q1, q2));
        List<Long> res = numberOfWays(queries);
        System.out.println(res.toString());
    }

    public static List<Long> numberOfWays(List<List<Integer>> queries) {
        int n = queries.size();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int r = queries.get(i).get(0);
            int c = queries.get(i).get(1);
            int min = Math.min(r, c);
            long res = 0;
            for (int j = 0; j < min; j++) {
                res += ((r - j) * (c - j));
            }
            list.add(res);
        }
        return list;
    }
}
