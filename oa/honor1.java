import java.util.Scanner;

public class honor1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int ans = 0;
        for (int i = 0; i < p / 3; i++) {
            for (int j = i + 1; j < p / 2; j++) {
                int k = p - i - j;
                if (k < i + j && i * i + j * j == k * k) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
