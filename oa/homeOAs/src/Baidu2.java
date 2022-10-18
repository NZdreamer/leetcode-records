import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Baidu2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());

        HashMap<String, List<String>> methods = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            String[] strs = str.split(" ");
            String name = strs[1].split("\\(")[0];
            String ps = str.split("\\(}")[1];
            if (methods.containsKey(name)) {
                if (checkValid(methods, name, ps)) {
                    methods.get(name).add(ps);
                    System.out.println("Yes");
                }
                else {
                    System.out.println("No");
                }
            }
        }
    }

    public static boolean checkValid(HashMap<String, List<String>> methods, String name, String ps) {
        String[] params = ps.split(",");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < params.length - 1; i++) {
//            String
        }
        return false;
    }
}
