import java.util.*;

public class ShenceOA2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<Integer, Integer> map = new HashMap<>();
        int c1 = 0;
        int c2 = 0;
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            if (!sc.hasNextLine()) {
                c1 = Integer.valueOf(s.split(" ")[0]);
                c2 = Integer.valueOf(s.split(" ")[1]);
            }
            else {
                int src = Integer.valueOf(s.split(" ")[0]);
                int dest = Integer.valueOf(s.split(" ")[1]);
                map.put(src, dest);
            }
        }

        Set<Integer> set = new HashSet<>();
        while (c1 != 1) {
            set.add(c1);
            c1 = map.get(c1);
        }
        while (c2 != 1) {
            if (set.contains(c2)) {
                System.out.println(c2);
                return;
            }
            else {
                c2 = map.get(c2);
            }
        }
        System.out.println(1);
    }
}
