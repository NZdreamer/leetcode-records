import java.util.HashMap;
import java.util.Scanner;
public class Baidu1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());

        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            if (canReorder(str)) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
    }

    public static boolean canReorder(String str) {
        if (str.length() != 5) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('B', 1);
        map.put('a', 1);
        map.put('i', 1);
        map.put('d' ,1);
        map.put('u', 1);
        for (int i = 0; i < 5; i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) return false;
            if (map.get(c) == 0) return false;
            map.put(c, 0);
        }
        return true;
    }

}
