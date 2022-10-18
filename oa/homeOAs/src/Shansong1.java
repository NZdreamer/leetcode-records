import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Shansong1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();

        // [1,2,3,4,5,6,7];[-1,2,3,8]
        // [-1,1,4,5,6,7,8]

        String[] arrs = input.split(";");
        String[] stra1 = arrs[0].substring(1, arrs[0].length() - 1).split(",");
        String[] stra2 = arrs[1].substring(1, arrs[1].length() - 1).split(",");
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();

        for (int i = 0; i < stra1.length; i++) {
            a1.add(Integer.valueOf(stra1[i]));
        }
        for (int i = 0; i < stra2.length; i++) {
            a2.add(Integer.valueOf(stra2[i]));
        }

        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a1.size() || j < a2.size()) {
            if (i >= a1.size()) {
                res.add(a2.get(j));
                j++;
            }
            else if (j >= a2.size()) {
                res.add(a1.get(i));
                i++;
            }
            else {
                if (a1.get(i) < a2.get(j)) {
                    res.add(a1.get(i));
                    i++;
                }
                else if (a1.get(i) > a2.get(j)) {
                    res.add(a2.get(j));
                    j++;
                }
                else {
                    i++;
                    j++;
                }
            }
        }
        String resstr = res.toString();
        resstr = resstr.replaceAll(" ", "");
        System.out.println(resstr);
    }
}
