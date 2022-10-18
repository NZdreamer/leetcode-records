import java.util.Scanner;

public class Baidu3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        if (count == 1) System.out.println("r");
        else if (count == 2) System.out.println("re");
        else if (count == 3) System.out.println("red");
        else {
            int rNum = 0;
            for (int i = 1; i < count; i++) {
                if (i * (i + 1) / 2 > count) {
                    rNum = i - 1;
                    break;
                }
            }
            String res = "";
            for (int i = 0; i < rNum; i++) {
                res += "r";
            }
            int remains = count - rNum * (rNum + 1) / 2;
            if (remains == 0) System.out.println(res);
            else {
                int tmp = 1;
                for (int i = 0; i < remains; i++) {
                    if (tmp % 3 == 1) res += "e";
                    else if (tmp % 3 == 2) res += "d";
                    else {
                        res += "r";
                    }
                    tmp++;
                }
                System.out.println(res);
            }
        }
    }
}
